package hw7.tote;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * This guy starts the race. Also he may change amount of horses in race or its distance.
 */
public class Judge {
    private int amountOfHorses = 5;
    private int distance = 1000;
    private CopyOnWriteArrayList<Horse> winners;

    public Judge(CopyOnWriteArrayList<Horse> winners) {
        this.winners = winners;
    }

    public void setAmountOfHorses(int amountOfHorses) {
        this.amountOfHorses = amountOfHorses;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Create new barrier depends on horses amount and starts race
     */
    public void startRace() {
        winners.clear();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(amountOfHorses);
        for (int i = 1; i < amountOfHorses + 1; i++) {
            new Thread(new Horse(i, distance, winners, cyclicBarrier)).start();
        }
        while (winners.size() < amountOfHorses) {
            Thread.yield();
        }
    }

    /**
     * Prints winners list in console with little delay for looking good
     */
    public void printResults() {
        System.out.println("Winners:");
        for (Horse horse : winners) {
            System.out.println(horse.getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
