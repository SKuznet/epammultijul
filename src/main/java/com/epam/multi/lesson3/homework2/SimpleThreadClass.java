package com.epam.multi.lesson3.homework2;

public class SimpleThreadClass implements  Runnable {

    int priority;

    public SimpleThreadClass(int startPriority){
        priority = startPriority;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello from" + Thread.currentThread().getName() + "with number " + i);
        }
    }
}
