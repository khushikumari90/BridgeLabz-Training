package digital_payment_interface;

class UPI implements Payment {
	@Override
    public void pay(double amount) {
    	System.out.println("Amount "+amount+" Rs is paid using UPI.");
    }
}
