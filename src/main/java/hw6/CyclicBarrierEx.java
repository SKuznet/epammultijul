package hw6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CyclicBarrierEx {
    private static final int FINISH_LINE = 20;
    private List<Horse> horses = new ArrayList<>();
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;
    private int horseWinnerId;

    public CyclicBarrierEx(int nHorses, final int pause) {
        cyclicBarrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    // fence
                    builder.append("=");
                }
                System.out.println(builder);

                for (Horse horse : horses){
                    System.out.println(horse.tracks());
                }

                for (Horse horse : horses){
                    if (horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse + " won!");
                        setHorseWinnerId(horse.getId());
                        executorService.shutdownNow();
                        return;
                    }
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.err.println("Barrier action: sleep was interrupted");
                }
            }
        });

        for (int i = 1; i <= nHorses; i++) {
            Horse horse = new Horse(cyclicBarrier);
            horses.add(horse);
            executorService.execute(horse);
        }
    }

    public int getHorseWinnerId() {
        return horseWinnerId;
    }

    public void setHorseWinnerId(int horseWinnerId) {
        this.horseWinnerId = horseWinnerId;
    }
}