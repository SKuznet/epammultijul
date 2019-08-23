package com.epam.multi.lesson1;

public class Example {

    public static void main(String[] args) {
        getThread().start();
    }

    private static Thread getThread() {

        return new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        });
    }
}
