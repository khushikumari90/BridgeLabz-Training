package iot_sensor_readings;
import java.util.*;

public class IOTSensorApp {
    public static void main(String[] args) {

        List<Double> sensorReadings = Arrays.asList(
            18.5,
            22.3,
            30.8,
            15.6,
            27.4
        );

        double threshold = 25.0;

        // Print readings above threshold
        sensorReadings.stream()
                      .filter(reading -> reading > threshold)
                      .forEach(reading ->
                          System.out.println("Alert! Sensor reading: " + reading)
                      );
    }
}
