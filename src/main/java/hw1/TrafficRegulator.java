package hw1;

import java.util.concurrent.TimeUnit;

import static hw1.Lights.*;

/**
 * Has an instance of enum Lights, changes it's state
 * periodically, with intervals.
 * Intervals are initially set by external threads
 *
 */
public class TrafficRegulator implements Runnable{

    private int redTime = 0;
    private int yellowTime = 0;
    private int greenTime = 0;
    private Lights lights = RED;

    public Lights getLigths(){
        return lights;
    }

    public void setRedTime(int redTime) {
        this.redTime = redTime;
    }

    public void setYellowTime(int yellowTime) {
        this.yellowTime = yellowTime;
    }

    public void setGreenTime(int greenTime) {
        this.greenTime = greenTime;
    }

    @Override
    public void run() {

        while (true){
            try{
                TimeUnit.SECONDS.sleep(redTime);
                lights = Lights.YELLOW;
                TimeUnit.SECONDS.sleep(yellowTime);
                lights = Lights.GREEN;
                TimeUnit.SECONDS.sleep(greenTime);
                lights = RED;
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
