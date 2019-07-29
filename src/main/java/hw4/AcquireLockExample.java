package hw4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AcquireLockExample implements Runnable {
    private int id;
    private boolean isInterrupt;
    private ReentrantLock lock;

    public AcquireLockExample(int id, boolean isInterrupt, ReentrantLock lock) {
        this.id = id;
        this.isInterrupt = isInterrupt;
        this.lock = lock;
    }

    @Override
    public void run() {
        print("Trying to lock...");
        try {
            if (isInterrupt) {
                print("Is lock locked: " + lock.isLocked());
                lock.lockInterruptibly();
                print("Is lock locked after lockInterruptibly(): " + lock.isLocked());
                print("LockInterruptibly count: " + lock.getHoldCount());
            } else {
                lock.lock();
            }
        } catch (InterruptedException e) {
            print("Acquiring lock failed due to " + e);
            return;
        }

        print("Got lock(" + id + ")");

        try {
            if (id == 1) {
                TimeUnit.SECONDS.sleep(1);
            } else {
                TimeUnit.MILLISECONDS.sleep(2500);
            }
        } catch (InterruptedException e) {
            print("Sleep has been interrupted");
        } finally {
            lock.unlock();
            print("Unlocked Thread(" + id + ")");
        }
    }

    private static void print(String text) {
        System.err.println(Thread.currentThread().getName() + ": " +  text);
    }
}
