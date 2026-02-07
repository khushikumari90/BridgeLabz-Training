package payment_gateway_integration;
interface PaymentProcessor {

    void pay(double amount);

    // Default method added later (backward compatible)
    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed using standard flow");
    }
}
