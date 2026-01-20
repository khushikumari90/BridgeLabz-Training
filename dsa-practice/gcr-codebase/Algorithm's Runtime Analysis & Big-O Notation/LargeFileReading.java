package algorithms_runtimeanalysis_and_bigOnotation;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LargeFileReading {

    // Using FileReader (Character Stream)
    public static void readUsingFileReader(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        int ch;
        while ((ch = reader.read()) != -1) {
            // reading character by character
        }
        reader.close();
    }

    // Using InputStreamReader (Byte Stream -> Character Stream)
    public static void readUsingInputStreamReader(String filePath) throws IOException {
        InputStreamReader reader =
                new InputStreamReader(new FileInputStream(filePath));
        int ch;
        while ((ch = reader.read()) != -1) {
            // reading byte converted to character
        }
        reader.close();
    }

    public static void main(String[] args) {

        String filePath = "largefile.txt"; // example: 100MB / 500MB file

        try {
            // FileReader timing
            long startTime = System.nanoTime();
            readUsingFileReader(filePath);
            long endTime = System.nanoTime();
            System.out.println("FileReader Time: "
                    + (endTime - startTime) / 1_000_000.0 + " ms");

            // InputStreamReader timing
            startTime = System.nanoTime();
            readUsingInputStreamReader(filePath);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Time: "
                    + (endTime - startTime) / 1_000_000.0 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
