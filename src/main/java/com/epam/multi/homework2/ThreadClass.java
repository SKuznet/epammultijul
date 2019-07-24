package com.epam.multi.homework2;

public class ThreadClass extends Thread {

    private int priority;

    ThreadClass(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " priority: " + priority);
        }
    }
}
