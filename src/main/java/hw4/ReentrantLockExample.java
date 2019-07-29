package hw4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static ReentrantLock lock = new ReentrantLock();
    private boolean interruptable;

    public ReentrantLockExample() {
        this.interruptable = true;
    }

    private void lockAndInterrupt(){
        Thread firstThread = new Thread(new AcquireLockExample(1, interruptable, lock), "Thread(1)");
        firstThread.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int numberOfThreads = 15;
        Thread[] others = new Thread[numberOfThreads];
        for (int i = 2; i < numberOfThreads+2; i++) {
            others[i-2] = new Thread(new AcquireLockExample(i,interruptable,lock),"Thread(" + i + ")");
            others[i-2].start();
        }

        System.err.println("Interrupt threads");

        for (int i = 0; i < numberOfThreads; i++) {
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
        ReentrantLockExample example = new ReentrantLockExample();
        example.lockAndInterrupt();
    }
}