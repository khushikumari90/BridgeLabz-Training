package stock_price_logger;
import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {

        List<Double> stockPrices = Arrays.asList(
            2450.75,
            2465.30,
            2448.90,
            2472.10
        );

        // Log each stock price update
        stockPrices.forEach(price ->
                System.out.println("Live Stock Price: ₹" + price));
    }
}
