package com.epam.multi.lesson4;

import java.util.concurrent.TimeUnit;

public class ATM {
    private static final Object key = new Object();

    static int money = 100;

    private static void getMoney(int amount) {

        synchronized (key) {

            if (amount <= money) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money -= amount;
                System.err.println("AlL OK! New amount:" + money);
            } else {
                System.err.println("Not enough money :(");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("Mike");
                getMoney(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("Jack");
                getMoney(50);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("John");
                getMoney(50);
            }
        }).start();
    }
}
