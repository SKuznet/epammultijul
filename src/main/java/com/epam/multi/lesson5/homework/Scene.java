package com.epam.multi.lesson5.homework;

import com.epam.multi.lesson5.iterrupt.AquireLockRunnable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Scene {

    private static String[] singerNames = {"Joe", "Bob", "Frank"};
    private static ReentrantLock lock = new ReentrantLock();
    private boolean interruptable;

    public Scene() {
        this.interruptable = true;
    }

    private void lockAndInterrupt() {
        Thread firstSinger = new Thread(new Singer("David", interruptable, lock), "Singer David");
        firstSinger.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread[] otherSingers = new Thread[singerNames.length];

        for (int i = 0; i < singerNames.length; i++) {
            otherSingers[i] = new Thread(new Singer(singerNames[i], interruptable, lock), "Singer " + singerNames[i]);
            otherSingers[i].start();
        }

        System.err.println("Interrupt threads");

        for (int i = 0; i < otherSingers.length; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500 * i / 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.err.println("Interrupt " + otherSingers[i].getName());
            otherSingers[i].interrupt();
        }
    }

    public static void main(String[] args) {
        new Scene().lockAndInterrupt();
    }
}
