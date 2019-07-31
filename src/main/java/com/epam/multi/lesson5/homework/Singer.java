package com.epam.multi.lesson5.homework;

import java.util.concurrent.locks.ReentrantLock;

public class Singer implements Runnable {

    private String name;
    private boolean isInterrupt;
    private ReentrantLock lock;

    public Singer(String name, boolean isInterrupt, ReentrantLock lock) {
        this.name = name;
        this.isInterrupt = isInterrupt;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("Trying to sing on scene " + this.name);

        try {
            if (isInterrupt) {
                lock.lockInterruptibly();
            } else {
                lock.lock();
            }
        } catch (InterruptedException e){
            System.err.println("It will be very bad decision If you want to interrupt singer!");
        }

        System.out.println("Singer " + name + " is singing on scene!");
    }
}
