package com.epam.multi.lesson6;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        ExampleResource exampleResource = new ExampleResource();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new CountThread(exampleResource,semaphore,"first"));
        executorService.execute(new CountThread(exampleResource,semaphore,"second"));
        executorService.execute(new CountThread(exampleResource,semaphore,"third"));
        executorService.shutdown();
    }
}

class ExampleResource {
    AtomicInteger resourceCurrent = new AtomicInteger(0);
}

class CountThread implements Runnable {
    private ExampleResource resource;
    private Semaphore semaphore;
    private String name;

    public CountThread(ExampleResource resource, Semaphore semaphore, String name) {
        this.resource = resource;
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "waiting");
            semaphore.acquire();
            resource.resourceCurrent.set(1);
            for (int i = 0; i < 10; i++) {
                System.out.println(this.name +":" + resource.resourceCurrent.get());
                resource.resourceCurrent.getAndIncrement();
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name+"release");
        semaphore.release();
    }
}