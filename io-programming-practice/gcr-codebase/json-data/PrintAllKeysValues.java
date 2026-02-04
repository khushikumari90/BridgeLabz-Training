package com.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintAllKeysValues {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            // Read JSON file
            JsonNode rootNode = mapper.readTree(new File("data.json"));

            // Print all keys and values
            printJson(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Recursive method
    private static void printJson(JsonNode node, String parentKey) {

        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                printJson(entry.getValue(), parentKey + entry.getKey() + ".");
            }

        } else if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                printJson(arrayItem, parentKey);
            }

        } else {
            // Print key and value
            System.out.println(parentKey.substring(0, parentKey.length() - 1)
                    + " : " + node.asText());
        }
    }
}
