package streams;
import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {

        String filePath = "src/streams/student.dat";

        // Writing data to file
        try (
            DataOutputStream dos =
                new DataOutputStream(new FileOutputStream(filePath))
        ) {
            int rollNumber = 101;
            String name = "Khushi";
            double gpa = 8.5;

            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading data from file
        try (
            DataInputStream dis =
                new DataInputStream(new FileInputStream(filePath))
        ) {
            int roll = dis.readInt();
            String studentName = dis.readUTF();
            double studentGpa = dis.readDouble();

            System.out.println("Retrieved Student Details:");
            System.out.println("Roll Number: " + roll);
            System.out.println("Name: " + studentName);
            System.out.println("GPA: " + studentGpa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
