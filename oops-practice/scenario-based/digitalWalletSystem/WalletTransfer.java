package digitalWalletSystem;

public class WalletTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        from.withdrawMoney(amount);
        to.addMoney(amount);
        System.out.println("Transferred via Wallet: ₹" + amount);
    }
}
