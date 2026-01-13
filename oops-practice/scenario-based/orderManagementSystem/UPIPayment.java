package orderManagementSystem;

public class UPIPayment implements Payment {

    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (amount > 20000) {
            throw new PaymentFailedException("UPI transaction limit exceeded!");
        }
        System.out.println("Payment of ₹" + amount + " successful using UPI.");
    }
}
