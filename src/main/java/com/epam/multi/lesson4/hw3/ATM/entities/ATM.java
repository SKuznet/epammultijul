package com.epam.multi.lesson4.hw3.ATM.entities;

public class ATM {
    private int cash;
    private Object lock = new Object();

    public ATM(int cash) {
        this.cash = cash;
    }

    public void withdrawCash(int amount, User user) {
        synchronized (lock) {
            if (amount <= cash && user.getBalance() >= amount) {
                cash = cash - amount;
                System.err.println("Take your money, plz");
            } else if (user.getBalance() < amount) {
                System.err.println("Sorry, not enough money in your pocket");
            } else {
                System.err.println("Sorry, not enough money in this ATM");
            }
        }
    }
}
