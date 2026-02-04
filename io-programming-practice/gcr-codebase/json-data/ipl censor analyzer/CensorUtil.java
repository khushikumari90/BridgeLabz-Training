package ipl_censor_analyzer;

public class CensorUtil {

    // Mask last word of team name
    public static String maskTeam(String teamName) {
        String[] parts = teamName.split(" ");
        if (parts.length > 1) {
            return parts[0] + " ***";
        }
        return "***";
    }

    // Redact player name
    public static String redactPlayer() {
        return "REDACTED";
    }
}
