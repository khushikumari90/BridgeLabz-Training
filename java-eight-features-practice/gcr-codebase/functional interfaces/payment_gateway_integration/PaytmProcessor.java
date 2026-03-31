package payment_gateway_integration;
class PaytmProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paytm payment of ₹" + amount + " successful");
    }
}
