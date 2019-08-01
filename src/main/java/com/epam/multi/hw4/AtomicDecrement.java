package com.epam.multi.hw4;

public class AtomicDecrement implements Runnable {
    int number;

    public AtomicDecrement(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Main.i.addAndGet(number));
        }
    }
}
