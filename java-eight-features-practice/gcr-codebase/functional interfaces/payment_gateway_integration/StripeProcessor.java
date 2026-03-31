package payment_gateway_integration;

class StripeProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Stripe payment of ₹" + amount + " successful");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Stripe refund of ₹" + amount + " completed with gateway rules");
    }
}
