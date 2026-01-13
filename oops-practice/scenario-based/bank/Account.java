package bank;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: " + amount);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Polymorphism
    public abstract double calculateInterest();
}

