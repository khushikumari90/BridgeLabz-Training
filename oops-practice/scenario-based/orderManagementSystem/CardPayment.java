package orderManagementSystem;

public class CardPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 50000) {
            throw new PaymentFailedException("Card limit exceeded!");
        }
        System.out.println("Payment of ₹" + amount + " successful using Card.");
    }
}
