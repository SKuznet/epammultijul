package hw5.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Cockroaches cockroaches1 = new Cockroaches(new AtomicInteger(30));
        Cockroaches cockroaches2 = new Cockroaches(new AtomicInteger(20));
        Cockroaches cockroaches3 = new Cockroaches(new AtomicInteger(10));
        Cockroaches cockroaches4 = new Cockroaches(new AtomicInteger(5));

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new CountThread(cockroaches1,semaphore,"Room 1 cockroaches counter"));
        executorService.execute(new CountThread(cockroaches2,semaphore,"Room 2 cockroaches counter"));
        executorService.execute(new CountThread(cockroaches3,semaphore,"Room 3 cockroaches counter"));
        executorService.execute(new CountThread(cockroaches4,semaphore,"Room 4 cockroaches counter"));
        executorService.shutdown();
    }
}
