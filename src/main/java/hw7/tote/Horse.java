package hw7.tote;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * Just horse. Simple fast and furious
 */
public class Horse implements Runnable {

    private int id;
    private CyclicBarrier barrier;
    private int distance;
    private CopyOnWriteArrayList<Horse> winners;
    private StringBuilder trace = new StringBuilder();

    public Horse(int id, int distance, CopyOnWriteArrayList<Horse> winners, CyclicBarrier barrier){
        this.id = id;
        this.distance = distance;
        this.winners = winners;
        this.barrier = barrier;
    }

    public String getName() {
        return "Horse Nº " + id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            while (trace.length() < distance) {
                trace.append("=");
            }
            winners.add(this);

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
