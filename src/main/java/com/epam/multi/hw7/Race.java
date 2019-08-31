package com.epam.multi.hw7;

import java.util.*;
import java.util.concurrent.*;

public class Race {

    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;
    private static List<Horse> winners = new ArrayList<>();

    public Race(List<String> horsesNames, int distance, final int pause) {

        int nHorses = horsesNames.size();
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < distance; i++) {
                    builder.append("=");
                }

                System.out.println(builder);

                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                Iterator<Horse> iterator = horses.iterator();
                boolean weHaveAWinner = false;
                while (iterator.hasNext()) {
                    Horse horse = iterator.next();
                    if (horse.getStrides() >= distance) {
                        if (winners.isEmpty()) {
                            winners.add(horse);
                        } else {
                            if (winners.get(0).getStrides() < horse.getStrides()){
                                winners = Collections.emptyList();
                                winners.add(horse);
                            } else if (winners.get(0).getStrides() == horse.getStrides()){
                                winners.add(horse);
                            }
                        }
                        weHaveAWinner = true;
                    }
                    if (!iterator.hasNext() && weHaveAWinner) {
                        System.out.println();
                        System.out.println("The winners are: ");
                        Utils.printList(winners);
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

        CountDownLatch latch = new CountDownLatch(horsesNames.size());
        for (String name: horsesNames) {
            Horse horse = new Horse(cyclicBarrier, latch, name);
            horses.add(horse);
            executorService.execute(horse);
        }

        try {
            latch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static List<Horse> startRace(List<String> names, int pause, int distance) {
        new Race(names, distance, pause);
        return winners;
    }
}
