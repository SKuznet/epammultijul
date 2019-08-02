package com.epam.multi.lesson6.hw4.exchanger;

import java.util.concurrent.Exchanger;

public class MakeSomeString implements Runnable {
    private Exchanger<String> exchanger;
    private String string;

    public MakeSomeString(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        string = "";
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = '1';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                string += (char) ch + "" + i + "";
            }
            try {
                System.err.println("Give " + string);
                string = exchanger.exchange(string);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
