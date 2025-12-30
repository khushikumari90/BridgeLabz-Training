package oop;

public class BankAccount {
    // Attributes
    String accountHolder;
    String accountNumber;
    double balance;

    // Method to display current balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Method to deposit money
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {
        // Creating BankAccount object
        BankAccount acc = new BankAccount();
        acc.accountHolder = "                   State of Chennai";
        acc.accountNumber = "SBI001";
        acc.balance = 700.0;

        // Initial state
        System.out.println(acc.accountHolder);
        System.out.println();
        acc.displayBalance();

        // Deposit
        acc.deposit(200.0);

        // Withdraw
        acc.withdraw(100.0);

        // Withdraw with insufficient balance
        acc.withdraw(1000.0);
    }

}
