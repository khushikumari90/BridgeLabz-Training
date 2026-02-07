package date_format_utility;
import java.time.LocalDate;

public class InvoiceApp {
    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        String format1 = DateUtils.formatDate(invoiceDate, "dd-MM-yyyy");
        String format2 = DateUtils.formatDate(invoiceDate, "MMM dd, yyyy");
        String format3 = DateUtils.formatDate(invoiceDate, "yyyy/MM/dd");

        System.out.println("Invoice Date (Format 1): " + format1);
        System.out.println("Invoice Date (Format 2): " + format2);
        System.out.println("Invoice Date (Format 3): " + format3);
    }
}
