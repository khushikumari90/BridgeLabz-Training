package lambda_expressions;
import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {

    public static void main(String[] args) {

        List<String> alerts = Arrays.asList(
                "Emergency: Heart Rate High",
                "Reminder: Medicine Time",
                "Info: Appointment Tomorrow",
                "Emergency: Blood Pressure Low"
        );

        // User preference: show only Emergency alerts
        Predicate<String> emergencyOnly =
                alert -> alert.startsWith("Emergency");

        System.out.println("Filtered Alerts:");

        for (String alert : alerts) {
            if (emergencyOnly.test(alert)) {
                System.out.println(alert);
            }
        }
    }
}
