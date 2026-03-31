package streams;
import java.io.*;

public class BufferedVsUnbufferedCopy {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourcePath = "src/streams/source.txt";
        String unbufferedDest = "src/streams/unbuffered_copy.txt";
        String bufferedDest = "src/streams/buffered_copy.txt";

        copyUsingUnbufferedStreams(sourcePath, unbufferedDest);
        copyUsingBufferedStreams(sourcePath, bufferedDest);
    }

    // Unbuffered File Copy
    public static void copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(destination)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (endTime - startTime) + " ns");
    }

    // Buffered File Copy
    public static void copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();

        try (
            BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (endTime - startTime) + " ns");
    }
}

