package hw1.lesson1.entities;

import hw1.lesson1.Application;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Traffic light entity extends Thread interface
 * Contains information about schedule, colors and current color
 */
@Data
public class TrafficLight extends Thread{
    private int redLightMinutes;
    private int yellowLightMinutes;
    private int greenLightMinutes;

    private TrafficLightColor red = TrafficLightColor.RED;
    private TrafficLightColor yellow = TrafficLightColor.YELLOW;
    private TrafficLightColor green = TrafficLightColor.GREEN;
    private TrafficLightColor currentColor = red;

    final static Logger logger = LogManager.getLogger(Application.class);

    @Override
    public void run() {
        while (true) {
            try {
                currentColor = red;
                TimeUnit.SECONDS.sleep(redLightMinutes);
                currentColor = yellow;
                TimeUnit.SECONDS.sleep(yellowLightMinutes);
                currentColor = green;
                TimeUnit.SECONDS.sleep(greenLightMinutes);
            } catch (InterruptedException e) {
                logger.error(e);
            }
        }
    }
}
