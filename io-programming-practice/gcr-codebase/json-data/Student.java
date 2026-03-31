package com.json;
import org.json.JSONArray;
import org.json.JSONObject;

public class Student {

    public static void main(String[] args) {

        // Create JSON Object
        JSONObject student = new JSONObject();

        // Add basic fields
        student.put("name", "Amit Sharma");
        student.put("age", 21);

        // Create JSON Array for subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Mathematics");
        subjects.put("Computer Science");
        subjects.put("Physics");

        // Add array to JSON object
        student.put("subjects", subjects);

        // Print JSON
        System.out.println(student.toString(4)); // pretty print
    }
}
