package com.epam.multi.lesson6.homework5;

import java.util.concurrent.Exchanger;

public class IllegalCurrencyExchanger implements Runnable {
    private Exchanger<Integer> exchanger;
    private Integer amount;
    public IllegalCurrencyExchanger(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                amount = exchanger.exchange(100 + (int)(Math.random() * ((3500 - 100) + 1)));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}