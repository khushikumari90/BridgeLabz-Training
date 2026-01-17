package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteStreamToCharacterStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("sample.txt");

            InputStreamReader isr =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);

            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            isr.close();
            fis.close();

        } catch (IOException e) {
            System.out.println("Error while reading the file");
        }
    }

}
