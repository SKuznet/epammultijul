package com.epam.multi.lesson4.homework3;


import java.util.concurrent.TimeUnit;

public class MainATM {
    private static final Object key = new Object();
    private static AutomatedTellerMachine automatedTellerMachine = new AutomatedTellerMachine(2000);

    private static void getMoney(int amount) {

        synchronized (key) {

            if (amount <= automatedTellerMachine.getMoney()) {

                try {

                    TimeUnit.MILLISECONDS.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                automatedTellerMachine.setMoney(automatedTellerMachine.getMoney() - amount);

                System.err.println("ALL OK! New amount: " + automatedTellerMachine.getMoney());

            } else {

                System.err.println("Not enough money :(");

            }

        }

    }
    public static void main(String[] args) {

        for (int i = 0; i < 15; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "taking money");
                    getMoney(100 + (int)(Math.random() * ((500 - 100) + 1)));
                }
            }).start();
        }
    }
}
