package com.epam.multi.lesson6.homework.countDownLatchExample;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static final CountDownLatch START_TEST = new CountDownLatch(5);
    private static String[] registratedStudents = {"Mike","John","Bob"};

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new Student(registratedStudents[i])).start();
            Thread.sleep(500);
        }

        while (START_TEST.getCount() > 2) {
            Thread.sleep(100);
        }

        System.out.println("Prepare your pencils...");
        START_TEST.countDown();
        Thread.sleep(1500);
        System.out.println("Start test!");
        START_TEST.countDown();
        Thread.sleep(1500);
    }
}
