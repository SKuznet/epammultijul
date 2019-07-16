package hw1;

import java.util.concurrent.TimeUnit;

/**
 * Represents a traffic light.
 * Have three possible colors plus current color.
 * Current color changes depending on duration time of all three basic colors.
 */
public class TrafficLight extends Thread {

    private int minutesForRedLight;
    private int minutesForYellowLight;
    private int minutesForGreenLight;

    private TrafficLightColor redColor = new TrafficLightColor(TrafficLightsThreeColors.RED);
    private TrafficLightColor yellowColor = new TrafficLightColor(TrafficLightsThreeColors.YELLOW);
    private TrafficLightColor greenColor = new TrafficLightColor(TrafficLightsThreeColors.GREEN);
    private TrafficLightColor currentColor = redColor;

    public void setMinutesForRedLight(int minutesForRedLight) {
        this.minutesForRedLight = minutesForRedLight;
    }

    public void setMinutesForYellowLight(int minutesForYellowLight) {
        this.minutesForYellowLight = minutesForYellowLight;
    }

    public void setMinutesForGreenLight(int minutesForGreenLight) {
        this.minutesForGreenLight = minutesForGreenLight;
    }

    public TrafficLightsThreeColors getCurrentColor() {
        return currentColor.getColor();
    }

    @Override
    public void run() {
        while (true) {
            try {
                currentColor = redColor;
                TimeUnit.SECONDS.sleep(minutesForRedLight);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                currentColor = yellowColor;
                TimeUnit.SECONDS.sleep(minutesForYellowLight);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                currentColor = greenColor;
                TimeUnit.SECONDS.sleep(minutesForGreenLight);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
