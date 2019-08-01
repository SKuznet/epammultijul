package com.epam.multi.lesson6.homework5;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTouristGroup {

    public static void main(String[] args) {
        int groupSize = 19;
        CountDownLatch countDownLatch = new CountDownLatch(groupSize);
        System.out.println("Waiting for all tourists...");
        for (int i = 0; i < groupSize; i++) {
            new CountDownLatchTourist(countDownLatch);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Group is ready, we can move on!");
    }
}



