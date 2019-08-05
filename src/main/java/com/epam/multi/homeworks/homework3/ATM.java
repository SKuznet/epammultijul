package com.epam.multi.homeworks.homework3;

import java.util.concurrent.TimeUnit;

public class ATM {
    private static final Object key = new Object();

    static int money = 100;
    private static final int ATM_CAPACITY = 1000;

    private static void getMoney(int amount) {

        // logic
        synchronized (key) {
            if (amount <= money) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money -= amount;
                System.err.println("ALL OK! New amount: " + money);
            } else {
                System.err.println("Not enough money :(");
            }
        }
    }

    private static void putMoney(int amount) {
        synchronized (key) {
            if (amount < 0) {
                System.err.println("That was fun, give me you're money!");
            } else {
                if (amount + money <= ATM_CAPACITY) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    money += amount;
                    System.err.println("ALL OK! New amount: " + money);
                } else {
                    System.err.println("Too much money, =(");
                }
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
                System.err.println("User");
                putMoney(-200);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("Bill");
                putMoney(100000);
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
                System.err.println("Rich");
                putMoney(100);
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

