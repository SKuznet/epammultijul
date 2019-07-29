package com.epam.multi.lesson4.homework.ATM;

import java.util.concurrent.TimeUnit;

public enum ATM {
    INSTANCE;

    private static final Object key = new Object();
    private double money = 100;

    public void getMoney(double amount) {

        synchronized (key) {
            if (amount <= money) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
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

    public static void main(String[] args) {
        ATMUser daniel = new ATMUser("Daniel");
        ATMUser maria = new ATMUser("Maria");
        ATMUser nikolai = new ATMUser("Nikolai");
        new Thread(daniel).start();
        new Thread(maria).start();
        new Thread(nikolai).start();
    }
}
