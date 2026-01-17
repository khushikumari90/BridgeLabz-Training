package linearsearch_binarysearch_stringbuilder_stringbuffer_bufferedreader_filereader_inputstreamreader;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class CompareAll {

    public static void main(String[] args) throws Exception {

        // ---------- StringBuilder vs StringBuffer ----------

        int iterations = 1000000;
        String text = "hello";

        long startTime, endTime;

        // Using StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ms");

        // Using StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ms");

        // ---------- FileReader vs InputStreamReader ----------

        String filePath = "largeFile.txt";
        String line;
        long wordCount;

        // Reading file using FileReader
        startTime = System.currentTimeMillis();
        wordCount = 0;

        BufferedReader br1 = new BufferedReader(new FileReader(filePath));
        while ((line = br1.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br1.close();

        endTime = System.currentTimeMillis();
        System.out.println("FileReader Word Count: " + wordCount);
        System.out.println("FileReader Time: " + (endTime - startTime) + " ms");

        // Reading file using InputStreamReader
        startTime = System.currentTimeMillis();
        wordCount = 0;

        BufferedReader br2 = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath),
                        StandardCharsets.UTF_8
                )
        );

        while ((line = br2.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br2.close();

        endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader Word Count: " + wordCount);
        System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ms");
    }
}
