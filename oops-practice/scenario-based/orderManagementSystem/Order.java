package orderManagementSystem;

public class Order {
    private int orderId;
    private Product product;
    private Customer customer;
    private boolean isCancelled;

    public Order(int orderId, Product product, Customer customer) {
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
        this.isCancelled = false;
    }

    public double getOrderAmount() {
        return product.getPrice();
    }

    public void cancelOrder() {
        isCancelled = true;
        System.out.println("Order " + orderId + " cancelled successfully.");
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Product: " + product.getName());
        System.out.println("Amount: ₹" + product.getPrice());
        System.out.println("Status: " + (isCancelled ? "Cancelled" : "Active"));
    }
}

