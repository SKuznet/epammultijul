package com.epam.multi.lesson1.hm2.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Car implements Runnable {
    private static int fuelCount = 100;

    public static void main(String[] args) {
        Car audi = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();

    }

    @Override
    public void run() {
        while (fuelCount-- != 0) {
            imStillDriving();
        }
    }

    private void imStillDriving() {
        System.out.println("Im still driving ");
    }
}
