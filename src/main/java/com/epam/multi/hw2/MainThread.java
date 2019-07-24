package com.epam.multi.hw2;

public class MainThread extends Thread{
    private static Thread thread1;
    private static Thread thread2;
    private static Thread thread3;

    public static void main(String[] args) {
        thread1 = new MainThread();
        thread2 = new MainThread();
        thread3 = new MainThread();

        thread1.setPriority(2);
        thread2.setPriority(5);
        thread3.setPriority(8);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        System.out.println("Im a " + Thread.currentThread().getName() + " with the priority: " + Thread.currentThread().getPriority());
    }
}