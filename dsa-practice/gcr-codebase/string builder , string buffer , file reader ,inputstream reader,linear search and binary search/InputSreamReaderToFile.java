package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputSreamReaderToFile {
    public static void main(String[] args) {

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("userInput.txt");

            System.out.println("Enter text (type 'exit' to stop):");

            String input;
            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(input);
                fw.write("\n");
            }

            fw.close();
            br.close();
            isr.close();

            System.out.println("Input saved to file successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred");
        }
    }
}