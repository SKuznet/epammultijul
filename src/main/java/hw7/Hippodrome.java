package hw7;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Hippodrome {
    private static int nHorses = 7;
    private static ArrayList<Integer> winnerList = new ArrayList<>();

    public static int startRace() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.err.println("Race started...");
        for (int i = 1; i < nHorses + 1; i++) {
            executorService.execute(new Horse(i, winnerList));
        }
        for (int i = 0; i < 10; i++) {
            System.err.print("=|");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.err.println();
        executorService.shutdownNow();
        System.err.println("--------------------");
        System.err.println("Race results:");
        System.err.println("Place | Horse #");
        for (int i = 0; i < nHorses; i++) {
            try {
                System.err.println("  " + (i + 1) + "   |   " + winnerList.get(i));
            } catch (IndexOutOfBoundsException e) {
                System.err.println("One horse broke a leg and did not finish race!");
            }
        }
        int winner = winnerList.get(0);
        winnerList.clear();
        return winner;
    }
}
