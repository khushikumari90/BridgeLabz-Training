//Problem 3: Bank Account Management
package constructor;
public class BankAccountManagement {

    // Parent Class
    static class BankAccount {

        // Access Modifiers
        public int accountNumber;          // public
        protected String accountHolder;    // protected
        private double balance;            // private

        // Constructor
        BankAccount(int accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Getter method for balance
        public double getBalance() {
            return balance;
        }

        // Setter method to modify balance
        public void setBalance(double balance) {
            this.balance = balance;
        }
    }

    // Child Class
    static class SavingsAccount extends BankAccount {

        double interestRate;

        SavingsAccount(int accountNumber, String accountHolder,
                       double balance, double interestRate) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
        }

        // Method to demonstrate access to public & protected members
        void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);     // public
            System.out.println("Account Holder: " + accountHolder);     // protected
            System.out.println("Balance: " + getBalance());             // private via method
            System.out.println("Interest Rate: " + interestRate + "%");
        }
    }

    // Main Method
    public static void main(String[] args) {

        SavingsAccount sa =
                new SavingsAccount(123456, "Khushi Rawat", 50000, 4.5);

        // Modify private balance using public method
        sa.setBalance(55000);

        // Display details
        sa.displayAccountDetails();
    }
}

