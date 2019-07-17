package hw1;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.FI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TrafficActor extends AbstractActor {

    private final int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private final TrafficLight trafficLight = new TrafficLight();

    static Props props() {
        return Props.create(TrafficActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, new FI.UnitApply<String>() {
                    @Override
                    public void apply(String s) {
                        if (s.equals("Start")) {
                            makeAction();
                        }
                    }
                })
                .build();
    }

    private void makeAction() {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int value : values) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new Runnable() {
                public void run() {
                    final LightColors lightColor = trafficLight.getCurrentLightColor(value);
                    final String answer = String.format("At the moment %d (s) the  color is %s", value, lightColor);
                    System.out.println(answer);
                }
            });
        }

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
