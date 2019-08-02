package hw7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Race {
    private static final int FINISH_LINE = 10;
    private List<Bettor> bettors = new ArrayList<>();
    private static Random random = new Random(47);
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;
    private int flag;
    private int circleNumber;

    public Race(int barrierNumber, final int pause) {
        cyclicBarrier = new CyclicBarrier(barrierNumber, new Runnable() {
            @Override
            public void run() {
                for (Bettor bettor : bettors) {
                    System.out.println(bettor.toString());
                }
                circleNumber++;
                int horse = random.nextInt(5);
                for (Bettor bettor : bettors) {
                    if (circleNumber >= FINISH_LINE) {
                        if (bettor.getHorse() == horse) {
                            System.out.println(bettor.winningPhrase());
                        }
                        flag++;
                    }
                }
                if (flag > 0) {
                    executorService.shutdownNow();
                    return;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.err.println("Barrier action: sleep interrupted");
                }
            }
        });

        for (int i = 0; i < barrierNumber; i++) {
            Bettor bettor = new Bettor(cyclicBarrier);
            bettors.add(bettor);
            executorService.execute(bettor);
        }
    }
}


