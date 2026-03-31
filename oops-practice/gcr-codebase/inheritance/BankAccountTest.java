//Bank Account Types
package inheritance;
//Superclass
class BankAccount {
 int accountNumber;
 double balance;

 BankAccount(int accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 void displayDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: " + balance);
 }
}

//Subclass 1
class SavingsAccount extends BankAccount {
 double interestRate;

 SavingsAccount(int accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 void displayAccountType() {
     System.out.println("Account Type: Savings Account");
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

//Subclass 2
class CheckingAccount extends BankAccount {
 int withdrawalLimit;

 CheckingAccount(int accountNumber, double balance, int withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 void displayAccountType() {
     System.out.println("Account Type: Checking Account");
     System.out.println("Withdrawal Limit: " + withdrawalLimit);
 }
}

//Subclass 3
class FixedDepositAccount extends BankAccount {
 int depositPeriod; // in years

 FixedDepositAccount(int accountNumber, double balance, int depositPeriod) {
     super(accountNumber, balance);
     this.depositPeriod = depositPeriod;
 }

 void displayAccountType() {
     System.out.println("Account Type: Fixed Deposit Account");
     System.out.println("Deposit Period: " + depositPeriod + " years");
 }
}

//Main class
public class BankAccountTest {
 public static void main(String[] args) {

     SavingsAccount sa = new SavingsAccount(101, 50000, 4.5);
     sa.displayDetails();
     sa.displayAccountType();

     System.out.println();

     CheckingAccount ca = new CheckingAccount(102, 30000, 5);
     ca.displayDetails();
     ca.displayAccountType();

     System.out.println();

     FixedDepositAccount fd = new FixedDepositAccount(103, 100000, 3);
     fd.displayDetails();
     fd.displayAccountType();
 }
}

