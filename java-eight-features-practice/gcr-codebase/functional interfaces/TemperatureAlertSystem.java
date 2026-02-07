package functional_interface;
import java.util.function.Predicate;

public class TemperatureAlertSystem {

    public static void main(String[] args) {

        double threshold = 37.5;

        // Predicate to check temperature alert
        Predicate<Double> temperatureAlert =
                temp -> temp > threshold;

        // Test temperatures
        checkTemperature(36.8, temperatureAlert);
        checkTemperature(38.2, temperatureAlert);
    }

    // Method using Predicate
    static void checkTemperature(double temperature,
                                 Predicate<Double> alertPredicate) {

        if (alertPredicate.test(temperature)) {
            System.out.println("ALERT! Temperature crossed threshold: " + temperature);
        } else {
            System.out.println("Temperature normal: " + temperature);
        }
    }
}
