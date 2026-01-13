package bank;

public class SavingsAccount extends Account {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}

