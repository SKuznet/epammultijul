package com.epam.multi.lesson3;

import java.util.concurrent.TimeUnit;

public class CastSpell implements Runnable {

    private static int taskCount = 0;
    private final int id = taskCount++;
    protected int countDown = 10;

    public CastSpell() {
    }

    public CastSpell(int countDown) {
        this.countDown = countDown;
    }

    public String getStatus() {
        return "#" + id + ("(" + (countDown > 0 ? countDown : "Spell is end!") + ").");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
//            Thread.sleep(200);
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (countDown-- > 0) {
            System.out.println(getStatus());
            Thread.yield();
        }
    }
}
