package com.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode node1 = mapper.readTree(new File("json1.json"));
            JsonNode node2 = mapper.readTree(new File("json2.json"));

            // ✅ Validate JSON is object
            if (!node1.isObject() || !node2.isObject()) {
                throw new IllegalArgumentException("JSON root must be an object");
            }

            ObjectNode merged = mapper.createObjectNode();
            merged.setAll((ObjectNode) node1);
            merged.setAll((ObjectNode) node2);

            System.out.println(
                mapper.writerWithDefaultPrettyPrinter()
                      .writeValueAsString(merged)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
