package com.epam.multi.lesson6.hw4.exchanger;

import java.util.concurrent.Exchanger;

public class UseSomeString implements Runnable {

    private Exchanger<String> exchanger;
    private String string;

    public UseSomeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                string = exchanger.exchange(new String());
                System.out.println("Got: " + string);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
