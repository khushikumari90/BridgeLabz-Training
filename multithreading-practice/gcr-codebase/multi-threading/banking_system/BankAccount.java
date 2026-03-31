package banking_system;
import java.time.LocalDateTime;

class BankAccount {
    private int balance = 10000;

    // synchronized method
    public synchronized boolean withdraw(String customerName, int amount) {
        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println(
                "Transaction successful: " + customerName +
                ", Amount: " + amount +
                ", Balance: " + balance +
                ", Time: " + LocalDateTime.now()
            );
            return true;
        } else {
            System.out.println(
                "Transaction failed: " + customerName +
                ", Amount: " + amount +
                ", Balance: " + balance +
                ", Time: " + LocalDateTime.now()
            );
            return false;
        }
    }
}
