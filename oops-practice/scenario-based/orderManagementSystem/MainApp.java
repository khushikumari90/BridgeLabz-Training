package orderManagementSystem;

public class MainApp {
    public static void main(String[] args) {

        Product product = new Product(101, "Laptop", 45000);
        Customer customer = new Customer(1, "Khushi");

        Order order = new Order(5001, product, customer);

        Payment paymentMethod = new CardPayment(); // Polymorphism

        try {
            paymentMethod.pay(order.getOrderAmount());
            order.showOrderDetails();
        } catch (PaymentFailedException e) {
            System.out.println("Payment Error: " + e.getMessage());
        }

        // Cancel Order
        order.cancelOrder();
    }
}
