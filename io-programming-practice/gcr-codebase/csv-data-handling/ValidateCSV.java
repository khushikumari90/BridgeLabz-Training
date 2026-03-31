package csv_data_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "contacts.csv"; // CSV file path
        String line = "";
        String splitBy = ",";

        // Regex patterns
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$";
        String phoneRegex = "\\d{10}";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read header
            String header = br.readLine();
            System.out.println("Validating CSV Data: " + header);

            int rowNumber = 1; // To track the line number (excluding header)
            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] data = line.split(splitBy);

                if (data.length < 3) {
                    System.out.println("Row " + rowNumber + " is incomplete: " + line);
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();

                boolean valid = true;

                // Validate email
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Row " + rowNumber + " invalid email: " + email);
                    valid = false;
                }

                // Validate phone number
                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Row " + rowNumber + " invalid phone number: " + phone);
                    valid = false;
                }

                if (valid) {
                    System.out.println("Row " + rowNumber + " is valid: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
