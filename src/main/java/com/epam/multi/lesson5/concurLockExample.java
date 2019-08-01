package com.epam.multi.lesson5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class concurLockExample implements Runnable {
    
    private Resource resource;
    private Lock lock;

    public concurLockExample(Resource resource) {
        this.resource = resource;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        System.err.println("trying to ");
        boolean isLocked = false;
        try{
            isLocked = lock.tryLock(10, TimeUnit.MILLISECONDS);
            if (isLocked){
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (isLocked)
                lock.unlock();
        }
    }
}
