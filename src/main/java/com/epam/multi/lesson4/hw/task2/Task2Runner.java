package com.epam.multi.lesson4.hw.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2Runner {
    public void run(){
        Thread thread1 = new Thread(new AtomicTaskRunnable(1));
        Thread thread2 = new Thread(new AtomicTaskRunnable(5));
        Thread thread3 = new Thread(new AtomicTaskRunnable(10));

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
        service.shutdown();
    }
}
