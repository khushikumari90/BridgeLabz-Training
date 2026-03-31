package oopsscenariobased;
//Custom Exception
class InvalidInvoiceFormatException extends Exception {
 public InvalidInvoiceFormatException(String message) {
     super(message);
 }
}

public class InvoiceGenerator2 {

 // Method to parse invoice
 public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
     if (!input.contains("-")) {
         throw new InvalidInvoiceFormatException("Invalid format: Missing '-'");
     }
     return input.split(",");
 }

 // Method to calculate total amount
 public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
     int total = 0;

     for (String task : tasks) {
         String[] parts = task.split("-");

         if (parts.length < 2) {
             throw new InvalidInvoiceFormatException("Invalid task format: " + task);
         }

         String amountPart = parts[1].trim();

         // Extract digits from amount
         String numberOnly = amountPart.replaceAll("[^0-9]", "");

         if (numberOnly.isEmpty()) {
             throw new InvalidInvoiceFormatException("Amount missing in task: " + task);
         }

         total += Integer.parseInt(numberOnly);
     }
     return total;
 }

 // Main method
 public static void main(String[] args) {
     String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

     try {
         String[] tasks = parseInvoice(input);
         int totalAmount = getTotalAmount(tasks);

         System.out.println("Total Invoice Amount: " + totalAmount + " INR");
     } catch (InvalidInvoiceFormatException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}



