package com.epam.multi.homeworks.homework5;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockExmamle {

    private static ReentrantLock lock = new ReentrantLock();
    private boolean interruptable;

    public LockExmamle() {
        this.interruptable = true;
    }

    public LockExmamle(boolean interruptable) {
        this.interruptable = interruptable;
    }

    private void lockAndInterrupt() {
        Thread firstThread = new Thread(new LockClass(1, interruptable, lock), "Thread(1)");
        firstThread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread[] others = new Thread[6];

        for (int i = 2; i < 8; i++) {
            others[i - 2] = new Thread(new LockClass(i, interruptable, lock), "Thread(" + i + ")");
            others[i - 2].start();
        }

        System.err.println("Interrupt threads");

        for (int i = 0; i < 6; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500 * i / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.err.println("Interrupt " + others[i].getName());
            others[i].interrupt();
        }
    }

    public static void main(String[] args) {
        LockExmamle example = new LockExmamle();
        example.lockAndInterrupt();
    }
}
