package streams;
import java.io.*;

public class ImageByteArrayExample {

    public static void main(String[] args) {

        String sourceImage = "src/streams/source.jpg";
        String destinationImage = "src/streams/copied.jpg";

        try {
            // Step 1: Read image into ByteArrayOutputStream
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            fis.close();
            baos.close();

            // Step 2: Write byte array back to image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destinationImage);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            bais.close();
            fos.close();

            System.out.println("Image copied successfully using byte array streams.");

        } catch (IOException e) {
            System.out.println("Error while processing the image file.");
            e.printStackTrace();
        }
    }
}
