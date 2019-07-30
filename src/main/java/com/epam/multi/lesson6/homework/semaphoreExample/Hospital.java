package com.epam.multi.lesson6.homework.semaphoreExample;

import java.util.concurrent.Semaphore;

public enum  Hospital {
    INSTANCE;

    public static final boolean[] WARD_BEDS = new boolean[4];
    public static final Semaphore SEMAPHORE = new Semaphore(4, true);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            new Thread(new Patient(i)).start();
            Thread.sleep(500);
        }
    }

}
