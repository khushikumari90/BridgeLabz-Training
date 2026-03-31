package digitalWalletSystem;

public class DigitalWalletApp {

    public static void main(String[] args) {

        User u1 = new User(1, "Amit");
        User u2 = new User(2, "Ravi");

        u1.createWallet(5000);
        u2.createWallet(2000);

        try {
            u1.getWallet().addMoney(1000);
            u1.getWallet().withdrawMoney(1500);

            TransferService bankTransfer = new BankTransfer();
            bankTransfer.transfer(u1.getWallet(), u2.getWallet(), 2000);

            TransferService walletTransfer = new WalletTransfer();
            walletTransfer.transfer(u2.getWallet(), u1.getWallet(), 500);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        u1.getWallet().showTransactions();
        u2.getWallet().showTransactions();
    }
}
