package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "large_students.csv"; // Path to large CSV
        int chunkSize = 100; // Number of lines to process at a time
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read header
            System.out.println("Header: " + header);

            List<String> chunk = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                chunk.add(line);

                // Process chunk when size reaches chunkSize
                if (chunk.size() == chunkSize) {
                    totalProcessed += processChunk(chunk);
                    chunk.clear(); // Clear the list for next batch
                }
            }

            // Process remaining lines if any
            if (!chunk.isEmpty()) {
                totalProcessed += processChunk(chunk);
            }

            System.out.println("Total records processed: " + totalProcessed);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Simulate processing of a chunk
    private static int processChunk(List<String> chunk) {
        // Example: just print number of records in this chunk
        System.out.println("Processing chunk of size: " + chunk.size());
        // You can add your actual processing logic here
        return chunk.size();
    }
}
