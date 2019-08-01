package com.epam.multi.lesson4.hw3.ATM.entities;

public class User {

    private String name;
    private int balance;

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
