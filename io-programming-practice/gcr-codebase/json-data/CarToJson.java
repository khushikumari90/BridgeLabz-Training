package com.json;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarToJson {
    public static void main(String[] args) {
        try {
            // Create Car object
            Car car = new Car("Toyota", "Fortuner", 2023, 4200000.50);

            // Create ObjectMapper
            ObjectMapper mapper = new ObjectMapper();

            // Convert Java Object to JSON String
            String json = mapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(car);

            // Print JSON
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
