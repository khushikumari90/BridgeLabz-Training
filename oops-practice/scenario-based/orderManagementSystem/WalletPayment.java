package orderManagementSystem;

public class WalletPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 10000) {
            throw new PaymentFailedException("Insufficient wallet balance!");
        }
        System.out.println("Payment of ₹" + amount + " successful using Wallet.");
    }
}
