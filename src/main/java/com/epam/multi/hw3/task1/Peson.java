package com.epam.multi.hw3.task1;

public class Peson {
    private String name;
    private int cashAmount;

    public Peson(String name) {
        this.name = name;
        cashAmount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }
}
