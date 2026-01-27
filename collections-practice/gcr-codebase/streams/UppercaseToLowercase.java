package streams;
import java.io.*;

public class UppercaseToLowercase {
    public static void main(String[] args) {

        String sourceFile = "src/streams/input.txt";
        String destinationFile = "src/streams/output.txt";

        try (
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(destinationFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {
            int ch;

            while ((ch = br.read()) != -1) {
                // Convert character to lowercase
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File content converted to lowercase successfully.");

        } catch (IOException e) {
            System.out.println("Error while reading or writing the file.");
            e.printStackTrace();
        }
    }
}
