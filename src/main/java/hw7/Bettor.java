package hw7;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Bettor implements Runnable {
    private static int counter;
    private static CyclicBarrier cyclicBarrier;
    private static Random random = new Random(47);
    private final int id = counter++;
    private int bet;
    private int horse;


    public int getHorse() {
        return horse;
    }

    public void setHorse(int horse) {
        this.horse = horse;
    }


    public Bettor(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public synchronized int getBet() {
        return bet;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    bet += random.nextInt(3);
                    horse = random.nextInt(5);
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
        return "Bettor " + id + " set on horse " + horse + " : " + bet + " dollars";
    }

}
