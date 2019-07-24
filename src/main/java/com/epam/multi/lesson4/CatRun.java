package com.epam.multi.lesson4;

import java.util.concurrent.TimeUnit;

public class CatRun {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.err.println(Thread.currentThread().getName() + " " + i);
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println();
                }
            }
        });

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    try {
                        System.err.println(Thread.currentThread().getName() + " " + i);
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println();
                }
            }
        });

        thread.start();
        thread1.start();


    }
}
