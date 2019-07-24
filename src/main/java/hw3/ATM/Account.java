package hw3.ATM;

public class Account {
    public static final  Account INSTANCE = new Account();
    private int moneyAmount;

    public Account() {
        this.moneyAmount = 100;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }
}
