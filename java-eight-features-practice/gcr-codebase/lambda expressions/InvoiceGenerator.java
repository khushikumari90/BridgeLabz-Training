package lambda_expressions;
import java.util.Arrays;
import java.util.List;

class Invoice {
    private String transactionId;

    // Constructor
    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}

public class InvoiceGenerator {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
                "TXN1001",
                "TXN1002",
                "TXN1003"
        );

        // Constructor Reference used here
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .toList();

        // Print invoices
        invoices.forEach(i -> System.out.println(i.getTransactionId()));
    }
}
