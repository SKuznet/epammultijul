package com.epam.multi.lesson7.homework;

public class Player {

    private int playerBill;
    private String name;

    public Player(String name, int playerBill) {
        this.name = name;
        this.playerBill = playerBill;
    }

    public String getName() {
        return name;
    }

    public int getPlayerBill() {
        return playerBill;
    }

    public void setPlayerBill(int playerBill) {
        this.playerBill = playerBill;
    }
}
