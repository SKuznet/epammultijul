package hw3.entities;

import java.util.concurrent.TimeUnit;

public class ATM {

    private static final Object synch = new Object();
    private static int moneyBalance;

    public ATM(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public void withdrawMoney(Consumer consumer, int amount) {
        synchronized (synch) {
            if (amount < moneyBalance) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moneyBalance -= amount;
                System.err.println("Take your card and money");
            } else {
                System.err.println("Not enough money in ATM");
            }
        }
    }
}
