package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {

    public static void main(String[] args) {
        try {
            // Create list of Java objects
            List<Student1> students = new ArrayList<>();
            students.add(new Student1(1, "Amit", "amit@gmail.com"));
            students.add(new Student1(2, "Neha", "neha@gmail.com"));
            students.add(new Student1(3, "Ravi", "ravi@gmail.com"));

            // Convert list to JSON array
            ObjectMapper mapper = new ObjectMapper();
            String jsonArray = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(students);

            // Print JSON array
            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

