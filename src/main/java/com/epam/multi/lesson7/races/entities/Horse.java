package com.epam.multi.lesson7.races.entities;

public class Horse extends Thread {
    private String name;
    private boolean winning;

    public Horse(String name) {
        this.name = name;
        this.start();
    }

    @Override
    public void run() {
        Finish.line(this);
        if (Finish.line(this) == 1) {
            winning = true;
        } else {
            winning = false;
        }
    }

    public boolean isWinning() {
        return winning;
    }
}
