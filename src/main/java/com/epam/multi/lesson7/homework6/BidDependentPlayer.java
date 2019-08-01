package com.epam.multi.lesson7.homework6;

public class BidDependentPlayer {
    private int currentHorseNumber;
    private int currentBid;
    private int cashAmount;
    private String name;
    public BidDependentPlayer(int cashAmount, String name){
        this.cashAmount = cashAmount;
        this.name = name;
    }

    public int getCurrentHorseNumber() {
        return currentHorseNumber;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public void setCurrentHorseNumber(int currentHorseNumber) {
        this.currentHorseNumber = currentHorseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(int currentBid) {
        this.currentBid = currentBid;
    }
}
