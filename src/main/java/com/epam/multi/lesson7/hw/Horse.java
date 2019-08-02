package com.epam.multi.lesson7.hw;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Horse implements Runnable {
    private static int counter;
    private CyclicBarrier cyclicBarrier;
    private static Random random = new Random(47);
    private final int id = counter++;
    private int strides;
    private double winingCoefficient;

    public Horse(CyclicBarrier cyclicBarrier, List<Bet> bets) {
        this.cyclicBarrier = cyclicBarrier;
        winingCoefficient = calculateWiningCoefficient(bets);
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
                    strides += random.nextInt(3)*winingCoefficient;
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
        for (int i = 0; i < getStrides(); i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(id);
        return stringBuilder.toString();
    }

    private double calculateWiningCoefficient(List<Bet> bets){
        double winningsAverage = 0;
        int countOfWins = 0;
        int countOfBets = 0;

        for(Bet bet : bets){
            if(bet.getHorseId() == id){
                countOfBets++;
                countOfWins += bet.getPlayer().getWinStreak();
            }
        }

        if(countOfBets == 0){
            return 1;
        }

        winningsAverage = countOfWins/countOfBets;

        if(winningsAverage < 3){
            return 1.0;
        }
        if(winningsAverage < 6){
            return 0.75;
        }
        if (winningsAverage < 9){
            return 0.5;
        } else {
            return 0.25;
        }
    }

    public static void resetCounter(){
        counter = 0;
    }
}