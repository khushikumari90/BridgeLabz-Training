package payment_gateway_integration;
public class PaymentApp {
    public static void main(String[] args) {

        PaymentProcessor p1 = new PaytmProcessor();
        PaymentProcessor p2 = new StripeProcessor();

        p1.pay(5000);
        p1.refund(5000);   // Uses default method

        p2.pay(3000);
        p2.refund(3000);   // Uses overridden method
    }
}
