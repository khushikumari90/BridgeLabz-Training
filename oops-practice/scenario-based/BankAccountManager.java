// A banking app needs to perform operations like deposit,withdraw,and check balance for a user.
package oopsscenariobased;
class BankAccount {

    // Fields / Properties
    private int accountNumber;
    private double balance;

    // Constructor
    BankAccount(int accNo, double initialBalance) {
        accountNumber = accNo;
        balance = initialBalance;
    }

    // Method to deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Amount: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Method to check balance
    void checkBalance() {
        System.out.println("Account Number : "+accountNumber+"\nCurrent Balance: " + balance);
    }
}

// Main class
public class BankAccountManager {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(101, 5000);

        account.checkBalance();
        account.deposit(2000);
        account.withdraw(3000);
        account.withdraw(5000);   // Overdraft prevented
        account.checkBalance();
    }
}
