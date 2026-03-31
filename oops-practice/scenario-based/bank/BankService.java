package bank;

public interface BankService {

    void createAccount(Account account);

    double checkBalance(int accountNumber);

    void transferFunds(int fromAcc, int toAcc, double amount)
            throws InsufficientBalanceException;

    void showTransactionHistory(int accountNumber);
}
