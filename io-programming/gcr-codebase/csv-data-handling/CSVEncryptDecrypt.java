package csv_data_handling;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.io.*;

class Employee {
    String id;
    String name;
    String department;
    String salary; // Store as string to handle encrypted value
    String email;

    public Employee(String id, String name, String department, String salary, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + department + "," + salary + "," + email;
    }
}

public class CSVEncryptDecrypt {

    // AES key (128-bit)
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Encrypt a string
    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt a string
    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = Base64.getDecoder().decode(encryptedData);
        return new String(cipher.doFinal(decoded));
    }

    // Write CSV with encrypted fields
    public static void writeEncryptedCSV(String filePath, Employee[] employees) {
        try (FileWriter fw = new FileWriter(filePath)) {
            // Header
            fw.append("ID,Name,Department,Salary,Email\n");

            for (Employee e : employees) {
                String encryptedSalary = encrypt(e.salary);
                String encryptedEmail = encrypt(e.email);
                fw.append(e.id).append(",")
                        .append(e.name).append(",")
                        .append(e.department).append(",")
                        .append(encryptedSalary).append(",")
                        .append(encryptedEmail).append("\n");
            }

            System.out.println("CSV written with encrypted fields: " + filePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Read CSV and decrypt sensitive fields
    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            System.out.println("Header: " + header);

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String department = data[2];
                String salary = decrypt(data[3]);
                String email = decrypt(data[4]);

                System.out.println(id + "," + name + "," + department + "," + salary + "," + email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("101", "Rohit", "IT", "50000", "rohit@company.com"),
                new Employee("102", "Sneha", "HR", "45000", "sneha@company.com"),
                new Employee("103", "Ankit", "Finance", "60000", "ankit@company.com")
        };

        String filePath = "employees_encrypted.csv";

        // Write encrypted CSV
        writeEncryptedCSV(filePath, employees);

        // Read and decrypt CSV
        System.out.println("\nDecrypted CSV Records:");
        readDecryptedCSV(filePath);
    }
}
