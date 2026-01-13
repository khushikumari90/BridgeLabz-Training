package bank;

public class MainApp {

    public static void main(String[] args) {

        BankService bank = new BankServiceImpl();

        Account acc1 = new SavingsAccount(101, "Priya", 5000.0);
        Account acc2 = new CurrentAccount(102, "Rahul", 3000.0);

        bank.createAccount(acc1);
        bank.createAccount(acc2);

        // Multithreading (Concurrent Transactions)
        Thread t1 = new Thread(() -> {
            try {
                bank.transferFunds(101, 102, 1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                bank.transferFunds(101, 102, 500);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nBalance of 101: " + bank.checkBalance(101));
        System.out.println("Balance of 102: " + bank.checkBalance(102));

        System.out.println("\nTransaction History (101):");
        bank.showTransactionHistory(101);
    }
}

