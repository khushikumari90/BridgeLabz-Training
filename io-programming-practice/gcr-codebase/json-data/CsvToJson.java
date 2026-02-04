package com.json;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJson {

    public static void main(String[] args) {
        try {
            CsvMapper csvMapper = new CsvMapper();
            ObjectMapper jsonMapper = new ObjectMapper();

            // Define CSV schema with header
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            // Read CSV file
            MappingIterator<Map<String, String>> iterator =
                    csvMapper.readerFor(Map.class)
                             .with(csvSchema)
                             .readValues(new File("students.csv"));

            List<Map<String, String>> data = iterator.readAll();

            // Convert to JSON
            String json = jsonMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(data);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
