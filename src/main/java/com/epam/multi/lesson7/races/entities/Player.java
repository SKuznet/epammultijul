package com.epam.multi.lesson7.races.entities;

public class Player {
    private String name;
    private int balance;


    public Player(String name) {
        this.name = name;
    }

    public void makeABet(int amount, Horse horse, int koef) {
        balance = amount;
        if (horse.isWinning()) {
            balance = balance * koef;
            System.err.println(this.name + " win: " + balance);
        } else {
            balance = 0;
            System.err.println(this.name + " lose. Balance: " + balance);
        }
    }
}
