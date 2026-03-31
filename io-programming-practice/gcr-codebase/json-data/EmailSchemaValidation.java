package com.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class EmailSchemaValidation {

    public static void main(String[] args) throws IOException, ProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        // Load schema
        JsonNode schemaNode = objectMapper.readTree(new File("email-schema.json"));
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        JsonSchema schema = factory.getJsonSchema(schemaNode);

        // Load JSON data
        JsonNode jsonData = objectMapper.readTree(new File("valid-user.json"));
        // JsonNode jsonData = objectMapper.readTree(new File("invalid-user.json"));

        // Validate
        if (schema.validate(jsonData).isSuccess()) {
            System.out.println("Email is valid according to JSON Schema");
        } else {
            System.out.println("❌ Invalid email format");
            System.out.println(schema.validate(jsonData));
        }
    }
}
