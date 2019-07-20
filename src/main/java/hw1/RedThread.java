package hw1;

import java.util.concurrent.Semaphore;

public class RedThread implements Runnable {
    CommonResource res;
    Semaphore sem;
    String name = "RedThread";

    RedThread(CommonResource res, Semaphore sem) {
        this.res = res;
        this.sem = sem;
    }

    @Override
    public void run() {

        while (true) {
            try {
                sem.acquire();
                res.x = 1;
                while (res.x < 3) {
                    Thread.sleep(6000);
                    System.out.println(this.name + ": " + res.x);
                    res.x++;
                }
            } catch (InterruptedException e) {
                System.out.println("RED");
            }
            System.out.println(name + " освобождает разрешение");
            sem.release();

        }
    }
}
