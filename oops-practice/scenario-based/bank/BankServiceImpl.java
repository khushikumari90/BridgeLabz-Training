package bank;

import java.util.HashMap;
import java.util.Map;

public class BankServiceImpl implements BankService {

    private Map<Integer, Account> accounts = new HashMap<>();

    @Override
    public void createAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created for " + account.holderName);
    }

    @Override
    public double checkBalance(int accountNumber) {
        return accounts.get(accountNumber).getBalance();
    }

    @Override
    public synchronized void transferFunds(int fromAcc, int toAcc, double amount)
            throws InsufficientBalanceException {

        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        sender.withdraw(amount);
        receiver.deposit(amount);

        sender.transactionHistory.add("Transferred " + amount + " to " + toAcc);
        receiver.transactionHistory.add("Received " + amount + " from " + fromAcc);
    }

    @Override
    public void showTransactionHistory(int accountNumber) {
        Account acc = accounts.get(accountNumber);
        acc.getTransactionHistory().forEach(System.out::println);
    }
}
