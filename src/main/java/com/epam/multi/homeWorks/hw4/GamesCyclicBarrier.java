package com.epam.multi.homeWorks.hw4;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class GamesCyclicBarrier implements Runnable {
    private static final int FINISH_LINE = 20;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;
    private Horse winner;
    private int nHorses;
    private int pause;
    private final Object key;
    private List<Bet> bets;

    public Horse getWinner() {
        return winner;
    }

    public GamesCyclicBarrier(int nHorses, int pause, Object key, List<Bet> bets) {
        this.nHorses = nHorses;
        this.pause = pause;
        this.key = key;
        this.bets = bets;
    }

    public void run() {
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

                synchronized (key) {
                    for (Horse horse : horses) {
                        if (horse.getStrides() >= FINISH_LINE) {
                            System.out.println(horse + "won!");
                            executorService.shutdownNow();
                            winner = horse;
                            Horse.resetCounter();
                            key.notify();
                        }
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
            Horse horse = new Horse(cyclicBarrier, bets);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    private void startRace() {

    }
}
