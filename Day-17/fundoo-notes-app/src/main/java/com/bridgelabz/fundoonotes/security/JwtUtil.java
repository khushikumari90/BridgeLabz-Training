package com.bridgelabz.fundoonotes.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;

// UC2/UC3: generates and validates JWT tokens
// UC9: repeated requests with the same token skip redundant cryptographic validation via Redis
@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final String CACHE_PREFIX = "jwt:valid:";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private final StringRedisTemplate redisTemplate;

    public JwtUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(int userId, String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public int extractUserId(String token) {
        return extractAllClaims(token).get("userId", Integer.class);
    }

    public boolean isTokenValid(String token) {
        String cacheKey = CACHE_PREFIX + token;

        String cached = redisTemplate.opsForValue().get(cacheKey);
        if (cached != null) {
            logger.debug("Redis HIT for token validation");
            return Boolean.parseBoolean(cached);
        }

        logger.debug("Redis MISS for token validation - doing real check");
        boolean valid = realTokenCheck(token);

        if (valid) {
            // critical: TTL must never exceed the token's OWN remaining expiry,
            // otherwise a cache entry could outlive the token itself
            long remainingMillis = extractAllClaims(token).getExpiration().getTime() - System.currentTimeMillis();
            if (remainingMillis > 0) {
                redisTemplate.opsForValue().set(cacheKey, "true", Duration.ofMillis(remainingMillis));
            }
        }

        return valid;
    }

    private boolean realTokenCheck(String token) {
        try {
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            // any parsing/signature/expiry problem = invalid token
            return false;
        }
    }
}
