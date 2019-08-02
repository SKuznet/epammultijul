package com.epam.multi.homeWorks.hw3.task1;

import java.util.concurrent.TimeUnit;

public class ATM {
    private static final Object key = new Object();
    private static int money = 1000;

    public boolean giveMoney(int amount){
        synchronized (key) {
            if (amount <= money) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money -= amount;
                System.err.println("Here your: " + money + ". Be proud with that and don't worry about poor people!");
                return true;
            } else {
                System.err.println("Oooh, poor boy doesn't have enough money! :( Find job, little freelancer!");
                return false;
            }
        }
    }

    public static Object getKey() {
        return key;
    }
}
