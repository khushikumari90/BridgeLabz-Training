package digitalWalletSystem;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private User user;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Wallet(User user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("CREDIT", amount));
        System.out.println("Money added: ₹" + amount);
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("DEBIT", amount));
        System.out.println("Money withdrawn: ₹" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void showTransactions() {
        System.out.println("\nTransaction History:");
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }
}
