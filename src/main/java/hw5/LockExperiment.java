package hw5;

import java.util.concurrent.locks.ReentrantLock;

public class LockExperiment {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(() -> {
            lock.lock();
            int i = 0;
            System.out.println("I've locked");
            try {
                lock.lockInterruptibly();
                while (true) {
                    System.out.println("I've looped" + i++);
                }
            } catch (InterruptedException e) {
                System.out.println("I've interrupted");
            }
        });
        thread.start();
        thread.interrupt();
    }
    
}
