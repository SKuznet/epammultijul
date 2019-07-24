package com.epam.multi.lesson4;

public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.err.println("interrupted");
        }

        System.out.println(getName() + " join is end!");
    }

}
