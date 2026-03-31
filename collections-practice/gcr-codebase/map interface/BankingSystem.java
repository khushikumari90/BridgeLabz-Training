package map_interface;
import java.util.*;

public class BankingSystem {

    // HashMap stores account number -> balance
    static HashMap<Integer, Integer> accountMap = new HashMap<>();

    // TreeMap stores balance -> list of account numbers (sorted by balance)
    static TreeMap<Integer, List<Integer>> balanceSortedMap = new TreeMap<>();

    // Queue for withdrawal requests (account number)
    static Queue<Integer> withdrawalQueue = new LinkedList<>();

    // Add account
    static void addAccount(int accountNumber, int balance) {
        accountMap.put(accountNumber, balance);

        balanceSortedMap.putIfAbsent(balance, new ArrayList<>());
        balanceSortedMap.get(balance).add(accountNumber);
    }

    // Request withdrawal
    static void requestWithdrawal(int accountNumber) {
        if (accountMap.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        }
    }

    // Process withdrawal requests
    static void processWithdrawals(int amount) {
        System.out.println("Processing withdrawal requests:");

        while (!withdrawalQueue.isEmpty()) {
            int accNo = withdrawalQueue.poll();
            int balance = accountMap.get(accNo);

            if (balance >= amount) {
                balance -= amount;
                accountMap.put(accNo, balance);
                System.out.println("Withdrawal successful for Account " + accNo);
            } else {
                System.out.println("Insufficient balance for Account " + accNo);
            }
        }
    }

    // Display customers sorted by balance
    static void displaySortedByBalance() {
        System.out.println("Accounts sorted by balance:");

        for (Map.Entry<Integer, List<Integer>> entry : balanceSortedMap.entrySet()) {
            for (int accNo : entry.getValue()) {
                System.out.println("Account " + accNo + " -> Balance: " + entry.getKey());
            }
        }
    }

    // Display all accounts
    static void displayAccounts() {
        System.out.println("All customer accounts:");
        for (Map.Entry<Integer, Integer> entry : accountMap.entrySet()) {
            System.out.println("Account " + entry.getKey() + " -> Balance: " + entry.getValue());
        }
    }

    // Main method
    public static void main(String[] args) {

        addAccount(1001, 5000);
        addAccount(1002, 12000);
        addAccount(1003, 8000);
        addAccount(1004, 5000);

        requestWithdrawal(1001);
        requestWithdrawal(1003);
        requestWithdrawal(1002);

        System.out.println();

        processWithdrawals(3000);
        System.out.println();

        displaySortedByBalance();
        System.out.println();

        displayAccounts();
    }
}
