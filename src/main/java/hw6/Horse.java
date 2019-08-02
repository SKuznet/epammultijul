package hw6;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable {
    private static int counter = 1;
    private final int id = counter++;
    private static CyclicBarrier cyclicBarrier;
    private static Random random = new Random(47);
    private int strides;

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    public Horse(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
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
            System.err.println(e.getMessage());
        } catch (BrokenBarrierException e) {
            throw new RuntimeException();
        }
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
