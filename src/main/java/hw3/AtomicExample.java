package main.java.hw3;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10_000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count.getAndAdd(1);
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
