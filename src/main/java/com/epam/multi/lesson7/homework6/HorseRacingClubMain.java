package com.epam.multi.lesson7.homework6;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HorseRacingClubMain {
    private static final int FINISH_LINE = 20;
    private List<Horse> horses = new ArrayList();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;

    public HorseRacingClubMain(int nHorses, final int pause, final BidDependentPlayer bidDependentPlayer, final CountDownLatch countDownLatch) {
        System.out.println("Player " + bidDependentPlayer.getName() + " placed a bid on horse number " + bidDependentPlayer.getCurrentHorseNumber());
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() {

            public void run() {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    builder.append("=");
                }

                System.out.println(builder);

                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }

                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + "won!");
                        if(bidDependentPlayer.getCurrentHorseNumber() == horse.getId()){
                            System.out.println(bidDependentPlayer.getName() + " won " + bidDependentPlayer.getCurrentBid()*2 + "dollars!");
                            bidDependentPlayer.setCashAmount(bidDependentPlayer.getCashAmount() + bidDependentPlayer.getCurrentBid()*2);
                        } else {
                            System.out.println(bidDependentPlayer.getName() + " loses " + bidDependentPlayer.getCurrentBid() + " dollars!");
                            bidDependentPlayer.setCashAmount(bidDependentPlayer.getCashAmount() - bidDependentPlayer.getCurrentBid());
                        }
                        Horse.restart();
                        executorService.shutdownNow();
                        countDownLatch.countDown();
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

}

