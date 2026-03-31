package digital_payment_interface;

public class Wallet implements Payment {
	@Override
    public void pay(double amount) {
    	System.out.println("Amount "+amount+" Rs is paid using Wallet.");
    }
}
