package main.java.hm3.atm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {

    private static int account = 500;

    static Lock lock = new ReentrantLock();

    public ATM() {
    }

    public static void getMoney(int amount) {
        System.out.println("You are " + Thread.currentThread().getName() + ". You asked " + amount);
        lock.lock();
        if (amount <= account) {
            account -= amount;
            System.out.println("Take you money.");
        } else {
            System.err.println("Sorry, there are not enough money.");
        }
        lock.unlock();
        System.out.println("Current balance is " + account);
    }
}
