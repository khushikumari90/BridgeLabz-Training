//Online Banking System : Key Features (CRUD)
package extraoopsscenariobased;
import java.util.*;

//================= Custom Exception =================
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String msg) {
     super(msg);
 }
}

//================= Abstraction =================
interface BankService {
 void deposit(double amount);
 void withdraw(double amount) throws InsufficientBalanceException;
 double calculateInterest();
}

//================= Base Class =================
abstract class Account implements BankService {
 protected int accountNumber;
 protected String holderName;
 protected double balance;
 protected List<String> transactionHistory = new ArrayList<>();

 public Account(int accountNumber, String holderName, double balance) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
 }

 // synchronized for concurrent access
 public synchronized void deposit(double amount) {
     balance += amount;
     transactionHistory.add("Deposited: ₹" + amount);
     System.out.println(holderName + " deposited ₹" + amount);
 }

 public synchronized void withdraw(double amount) throws InsufficientBalanceException {
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance!");
     }
     balance -= amount;
     transactionHistory.add("Withdrawn: ₹" + amount);
     System.out.println(holderName + " withdrew ₹" + amount);
 }

 public synchronized void transfer(Account toAccount, double amount) throws InsufficientBalanceException {
     if (amount > balance) {
         throw new InsufficientBalanceException("Transfer failed: Insufficient balance");
     }
     this.withdraw(amount);
     toAccount.deposit(amount);
     transactionHistory.add("Transferred ₹" + amount + " to " + toAccount.holderName);
 }

 public void showBalance() {
     System.out.println(holderName + " Balance: ₹" + balance);
 }

 public void showTransactions() {
     System.out.println("Transaction History of " + holderName);
     for (String t : transactionHistory) {
         System.out.println("- " + t);
     }
 }
}

//================= Savings Account =================
class SavingsAccount extends Account {

 public SavingsAccount(int accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 // Polymorphism
 @Override
 public double calculateInterest() {
     return balance * 0.04; // 4% interest
 }
}

//================= Current Account =================
class CurrentAccount extends Account {

 public CurrentAccount(int accNo, String name, double balance) {
     super(accNo, name, balance);
 }

 // Polymorphism
 @Override
 public double calculateInterest() {
     return balance * 0.02; // 2% interest
 }
}

//================= Multithreading =================
class TransactionTask extends Thread {
 private Account account;
 private double amount;

 public TransactionTask(Account account, double amount) {
     this.account = account;
     this.amount = amount;
 }

 @Override
 public void run() {
     try {
         account.withdraw(amount);
     } catch (InsufficientBalanceException e) {
         System.out.println(e.getMessage());
     }
 }
}

//================= Main Class =================
public class OnlineBankingSystem {

 public static void main(String[] args) {

     // Account Creation
     Account acc1 = new SavingsAccount(101, "Khushi", 10000);
     Account acc2 = new CurrentAccount(102, "Amit", 5000);

     // Balance Check
     acc1.showBalance();
     acc2.showBalance();

     // Deposit
     acc1.deposit(2000);

     // Fund Transfer
     try {
         acc1.transfer(acc2, 3000);
     } catch (InsufficientBalanceException e) {
         System.out.println(e.getMessage());
     }

     // Interest Calculation (Polymorphism)
     System.out.println("Savings Interest: ₹" + acc1.calculateInterest());
     System.out.println("Current Interest: ₹" + acc2.calculateInterest());

     // Multithreading (Concurrent Withdrawals)
     Thread t1 = new TransactionTask(acc1, 4000);
     Thread t2 = new TransactionTask(acc1, 4000);

     t1.start();
     t2.start();

     try {
         t1.join();
         t2.join();
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Final Balance & History
     acc1.showBalance();
     acc1.showTransactions();
 }
}

