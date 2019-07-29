package ATM;

public enum Atm {
    INSTANCE;

    private int balance = 1000;

     Atm() {

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
