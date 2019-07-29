package com.epam.multi.lesson5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcLockExample implements Runnable {
    private Resource resource;
    private Lock lock;

    public ConcLockExample(Resource resource) {
        this.resource = resource;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        System.err.println("trying to write to the file...");

        //try to get lock in 5 sec
        boolean isLocked = false;

        try {
            isLocked = lock.tryLock(100, TimeUnit.MILLISECONDS);

            if (isLocked) {
                TimeUnit.SECONDS.sleep(2);

                resource.writeToFile();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (isLocked) {
                lock.unlock();
            } else {
                System.err.println("Writing failed");
            }
        }

        // non thread safe
        resource.doLogging();
    }
}
