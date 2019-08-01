package hw3;

import java.util.concurrent.atomic.AtomicInteger;

public class ATM {

    public static final ATM atm = new ATM();
    private static AtomicInteger money;

    private ATM() {
        money = new AtomicInteger(0);
    }

    public void getMoney(int amount) {
        synchronized (atm) {
            int intMoney=money.get();
            if (intMoney>=amount) {
                System.err.println("New amount: " + money.addAndGet(-amount));
            } else {
                System.err.println("Not enough money");
            }
        }
    }

    public void addMoney(int amount) {
        System.err.println("New amount: " + money.addAndGet(amount));
    }

    public void seeMoney() {
        System.err.println("New amount: " + money.get());
    }
}