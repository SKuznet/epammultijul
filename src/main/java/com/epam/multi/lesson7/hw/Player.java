package com.epam.multi.lesson7.hw;

public class Player {
    private String name;
    private int cash;
    private int winStreak;

    public Player(String name) {
        this.name = name;
        cash = 1000;
        winStreak = 0;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public int getWinStreak() {
        return winStreak;
    }

    public void incrementWinStreak(){
        winStreak++;
    }

    public void resetWinStreak(){
        winStreak = 0;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", cash = " + cash;
    }
}
