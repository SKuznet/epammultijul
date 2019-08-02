package com.epam.multi.homeWorks.hw2;

public class TestRunnable implements Runnable {

    private int priority;

    public TestRunnable(int priority){
        this.priority = priority;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 10; i++) {
            System.out.println("Step : " + i + ". My name is " + Thread.currentThread().getName() + ", and my priority is " + priority);
        }
    }
}
