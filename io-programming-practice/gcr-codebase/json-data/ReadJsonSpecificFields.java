package com.json;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ReadJsonSpecificFields {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Map<String, Object>> users =
                mapper.readValue(new File("users.json"),
                        new TypeReference<List<Map<String, Object>>>() {});

            for (Map<String, Object> user : users) {
                System.out.println("Name: " + user.get("name"));
                System.out.println("Email: " + user.get("email"));
                System.out.println("------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
