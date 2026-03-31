package digitalWalletSystem;

public class User {
    private int userId;
    private String name;
    private Wallet wallet;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void createWallet(double initialBalance) {
        this.wallet = new Wallet(this, initialBalance);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }
}

