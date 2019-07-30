package com.epam.multi.homeworks.homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarierExample {
    private static final int FINISH_LINE = 20;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;

    public CyclicBarierExample(int nHorses, final int pause) {
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    // fence
                    builder.append("=");
                }

                System.out.println(builder);

                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }

                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + "won!");
                        executorService.shutdownNow();
                        return;
                    }
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.err.println("Barrier action: sleep interrupted");
                }
            }
        });

        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause  = 200;
        new CyclicBarierExample(nHorses, pause);
    }
}

class Horse implements Runnable {
    private static int counter;
    private static CyclicBarrier cyclicBarrier;
    private static Random random = new Random(47);
    private final int id = counter++;
    private int strides;

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
            // never repeat this
        } catch (BrokenBarrierException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "Horse " + +id + " ";
    }

    public String tracks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <  getStrides(); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(id);
        return stringBuilder.toString();
    }
}
