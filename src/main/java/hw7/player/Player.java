package hw7.player;

/**
 * Naive guy who wants to lose his money
 */
public class Player {
    private Account account;

    public Player(int money) {
        account = new Account(money);
    }

    public int getMoney() {
        return account.money;
    }

    public Account getAccount() {
        return account;
    }
}

