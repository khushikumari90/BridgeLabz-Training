package logging_transactions;
import java.time.LocalDateTime;
import java.util.*;

public class TransactionLoggerApp {
    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList(
            "TXN1001",
            "TXN1002",
            "TXN1003"
        );

        // Log each transaction with timestamp
        transactionIds.forEach(id ->
            System.out.println(LocalDateTime.now() + " - Transaction: " + id)
        );
    }
}
