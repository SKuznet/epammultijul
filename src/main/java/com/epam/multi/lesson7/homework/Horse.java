package com.epam.multi.lesson7.homework;

import java.util.concurrent.CopyOnWriteArrayList;

public class Horse implements Runnable {
    int horseId;
    int timeForRace;
    public static CopyOnWriteArrayList<Integer> winnerHorses = new CopyOnWriteArrayList<>();

    public Horse(int horseId) {
        this.horseId = horseId;
        this.timeForRace = 0 + (int) (Math.random() * 1000);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeForRace);
            winnerHorses.add(horseId);
        } catch (InterruptedException e) {
            new RuntimeException();
        }
    }
}
