package hw7.tote;

import hw7.player.Account;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * this guy take access to client's money and may take them or return depends on win or loss
 */
public class Bookmaker {

    private Account account;
    private int currentBet;
    private int currentHorse;

    /**
     * get permission to client's money
     * @param account
     */
    public void gimMoney(Account account) {
        this.account = account;
    }

    /**
     * take bet from client
     * @param bet
     * @param horse
     * @return true if bet was success and false if not
     */
    public boolean takeBet(int bet, int horse) {
        if (bet > account.money) {
            return false;
        } else {
            account.money -= bet;
            currentBet = bet;
            currentHorse = horse;
            return true;
        }
    }

    /**
     * resolve if clients won depends on his choice of horse
     * @param winners
     * @return true if player won and false if not
     */
    public boolean resolve(CopyOnWriteArrayList<Horse> winners) {
        if (currentHorse == winners.get(0).getId()) {
            returnPrize();
            return true;
        } else {
            return false;
        }
    }

    private void returnPrize() {
        account.money += currentBet*2;
    }
}
