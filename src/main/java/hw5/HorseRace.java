package hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
    private static final int FINISH_LINE = 20;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;
    private Bookmaker bookmaker;

    public HorseRace(final int horsesNum, final int pause, final Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
        cyclicBarrier = new CyclicBarrier(horsesNum, new Runnable() {
            @Override
            public void run() {

                for (Map.Entry<Player, Integer> bet : bookmaker.getBets().entrySet()) {
                    System.err.println("Player #" + bet.getKey().getId() + " bet on horse #" + bet.getValue());
                }

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
                        System.out.println(horse + " won!");
                        bookmaker.giveOutPrize(horse.getId());
                        executorService.shutdownNow();
                        return;
                    }
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.err.println("Barrier action sleep is interrupted");
                }
            }
        });

        for (int i = 0; i < horsesNum; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }
}
