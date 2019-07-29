package hw5.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountThread implements Runnable{
    private Cockroaches cockroaches;
    private Semaphore semaphore;
    private String name;

    public CountThread(Cockroaches cockroaches, Semaphore semaphore, String name) {
        this.cockroaches = cockroaches;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting permission to clean the room...");
            semaphore.acquire();
            int cockroachesLeft = cockroaches.amount.get();

            for (int i = cockroachesLeft; i >= 0; i--) {
                System.out.println(this.name + ": " + cockroaches.amount.get());
                cockroaches.amount.getAndDecrement();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " release permission, room is clean...");
        semaphore.release();
    }
}