package com.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class FilterJsonByAge {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON array from file
            JsonNode rootNode = mapper.readTree(new File("users.json"));

            // Loop through records
            for (JsonNode node : rootNode) {
                int age = node.get("age").asInt();

                if (age > 25) {
                    System.out.println("Name  : " + node.get("name").asText());
                    System.out.println("Age   : " + age);
                    System.out.println("Email : " + node.get("email").asText());
                    System.out.println("--------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
