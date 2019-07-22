package com.epam.multi.hw2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dota2PlayersNicknameRunn implements Runnable {
    private int count = 0;
    private volatile double d;
    private int priority;

    @Override
    public String toString() {
        return "Dota2player nickname :" + Thread.currentThread() + ":" + " priority=" + priority;
    }

    public Dota2PlayersNicknameRunn(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        while (true) {

            System.out.println(this);

            Thread.yield();

            if (++count == 5) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Dota2PlayersNicknameRunn(Thread.MAX_PRIORITY));

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Dota2PlayersNicknameRunn(Thread.MIN_PRIORITY));
        }

        executorService.shutdown();
    }
}
