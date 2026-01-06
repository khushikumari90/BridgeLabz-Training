package oopsscenariobased;
public class InvoiceGenerator {

    // Method to parse invoice and return amounts
    public static int[] parseInvoice(String input) {
        String[] items = input.split(",");
        int[] amounts = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            // Split using dash (-)
            String[] parts = items[i].split("-");
            
            // Extract amount (remove INR and spaces)
            String amountStr = parts[1].replace("INR", "").trim();
            amounts[i] = Integer.parseInt(amountStr);
        }
        return amounts;
    }

    // Method to calculate total amount
    public static int getTotalAmount(int[] amounts) {
        int total = 0;
        for (int amount : amounts) {
            total += amount;
        }
        return total;
    }

    public static void main(String[] args) {
        String invoiceInput = "Logo Design - 3000 INR, Web Page - 4500 INR";

        int[] amounts = parseInvoice(invoiceInput);
        int total = getTotalAmount(amounts);

        System.out.println("Total Invoice Amount: " + total + " INR");
    }
}

