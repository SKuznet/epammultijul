package com.epam.multi.lesson1.hw1;

import java.util.concurrent.TimeUnit;

public enum Light implements Runnable{
    RED, GREEN, YELLOW;

    int shineTime;
    int delay;

    @Override
    public void run() {
        try {
            while (true) {
                shine(shineTime);
                TimeUnit.SECONDS.sleep(delay);
            }
        } catch (InterruptedException e) {
        }
    }

    public Light setTime(int shineTime, int delay) {
        this.shineTime = shineTime;
        this.delay = delay;
        return this;
    }

    private class Shine extends Thread {

        int time;

        Shine(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void shine(int time) throws InterruptedException {
        Thread thread = new Shine(time);
        thread.start();
        thread.join();
    }
}
