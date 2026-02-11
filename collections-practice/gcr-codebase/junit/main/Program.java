package com.example.junit_demo;
public class Program {

    private double balance;

    // Constructor
    public Program(double initialBalance) {
        this.balance = initialBalance;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount < 0) {
            throw new RuntimeException("Deposit amount cannot be negative");
        }
        balance += amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds.");
        }
        balance -= amount;
    }
}
