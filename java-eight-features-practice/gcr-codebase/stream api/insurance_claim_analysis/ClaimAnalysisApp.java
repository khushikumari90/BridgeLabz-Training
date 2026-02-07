package insurance_claim_analysis;
import java.util.*;
import java.util.stream.Collectors;

public class ClaimAnalysisApp {
    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("Health", 50000),
            new InsuranceClaim("Vehicle", 30000),
            new InsuranceClaim("Health", 70000),
            new InsuranceClaim("Life", 100000),
            new InsuranceClaim("Vehicle", 45000),
            new InsuranceClaim("Life", 120000)
        );

        // Average claim amount for each claim type
        Map<String, Double> averageClaimByType =
                claims.stream()
                      .collect(Collectors.groupingBy(
                          c -> c.claimType,
                          Collectors.averagingDouble(c -> c.claimAmount)
                      ));

        averageClaimByType.forEach((type, avg) ->
                System.out.println(type + " Average Claim: ₹" + avg));
    }
}
