package hw5;

public class Player {

    private static int countPlayer;
    private int id;
    private int balance;

    public Player(int balance) {
        this.balance = balance;
        this.id = countPlayer;
        countPlayer++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
