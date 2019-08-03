package hw5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {
    private static int counter;
    private static CyclicBarrier cyclicBarrier;
    private static Random random = new Random(47);
    private final int id = counter++;
    private int strides;

    public Horse(CyclicBarrier cyclicBarrier) {
        Horse.cyclicBarrier = cyclicBarrier;
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public String tracks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(id);
        return stringBuilder.toString();
    }

    public int getId() {
        return id;
    }
}
