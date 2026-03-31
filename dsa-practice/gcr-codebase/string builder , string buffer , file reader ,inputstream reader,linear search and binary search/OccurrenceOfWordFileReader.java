package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class OccurrenceOfWordFileReader {
    public static void main(String[] args) {
        String targetWord = "java";
        int count = 0;

        try {
            FileReader fr = new FileReader("sample.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

            System.out.println("Occurrence of word '" + targetWord + "' : " + count);

        } catch (IOException e) {
            System.out.println("Error while reading the file");
        }
    }

}
