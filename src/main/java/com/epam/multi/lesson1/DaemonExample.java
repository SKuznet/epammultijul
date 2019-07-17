package main.java.com.epam.multi.lesson1;

import java.util.concurrent.TimeUnit;

public class DaemonExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println("I am daemon. Waiting...");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.setDaemon(true);
        thread.start();

        System.out.println("Working process...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
