package com.json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class JsonToXml {

    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            // Read JSON file
            JsonNode jsonNode = jsonMapper.readTree(new File("data.json"));

            // Convert JSON to XML
            String xml = xmlMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(jsonNode);

            System.out.println(xml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
