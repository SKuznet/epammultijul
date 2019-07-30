package com.epam.multi.lesson6.homework.countDownLatchExample;

public class Student implements Runnable {

    private int timeForTest;
    private String name;

    public Student(String name) {
        this.timeForTest = 0 + (int) (Math.random() * 1000);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Student " + name + " ready for test");
            Test.START_TEST.countDown();
            Test.START_TEST.await();
            Thread.sleep(timeForTest);
            System.out.println("Student " + name + " passed the test");
        } catch (InterruptedException e) {
            new RuntimeException();
        }
    }
}
