package order_revenue_summary;
import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueApp {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
            new Order("Khushi", 2500.50),
            new Order("Amit", 1800.00),
            new Order("Khushi", 3200.75),
            new Order("Neha", 1500.00),
            new Order("Amit", 2200.25)
        );

        // Sum order totals per customer
        Map<String, Double> revenueByCustomer =
                orders.stream()
                      .collect(Collectors.groupingBy(
                          o -> o.customerName,
                          Collectors.summingDouble(o -> o.orderTotal)
                      ));

        revenueByCustomer.forEach((customer, total) ->
                System.out.println(customer + " Total Revenue: ₹" + total));
    }
}
