package com.epam.multi.lesson6.homework5;

import java.util.concurrent.Exchanger;

public class JustAManWithExtraDollars implements Runnable {
    private Exchanger<Integer> exchanger;
    private Integer dollarsToExchange;
    public JustAManWithExtraDollars(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
        this.dollarsToExchange = 100 + (int)(Math.random() * ((500 - 100) + 1));
        new Thread(this).start();
    }

    public void run() {

            try {
                System.out.println("Giving a " + dollarsToExchange.toString() + " dollars to an illegal exchanger...");
                dollarsToExchange = exchanger.exchange(dollarsToExchange);
                System.out.println("Received a " + dollarsToExchange.toString() + " rubles from an illegal exchanger...");
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }
