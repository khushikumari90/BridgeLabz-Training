package digital_payment_interface;

public class CreditCard implements Payment {
	@Override
    public void pay(double amount) {
    	System.out.println("Amount "+amount+" Rs is paid using Credit Card.");
    }
}
