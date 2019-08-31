package com.epam.multi.hw7;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable{

    private String name;
    private static int counter;
    private static CyclicBarrier cyclicBarrier;
    private static Random random = new Random(47);
    private final int id = ++counter;
    private int strides;
    private static CountDownLatch latch;

    public Horse(CyclicBarrier cyclicBarrier, CountDownLatch latch, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.latch = latch;
    }

    public int getId() {
        return id;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                cyclicBarrier.await();
            }
            latch.countDown();
        } catch (InterruptedException e) {
            System.err.println("Ooops! Something went wrong while " + name + " was running.");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "Horse " + name + " (" + id + ") ";
    }

    public String tracks() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " (" + id + ") ");
        int i;
        for (i = 0; i <  getStrides(); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(i);
        return stringBuilder.toString();
    }
}
