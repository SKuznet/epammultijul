package hw1;

/**
 * Runnable that takes input int and assigns it to TrafficRegulator internal varible
 *
 */
public class ThreadRed implements Runnable{

    ThreadRed(TrafficRegulator tr, int time){
        this.tr = tr;
        this.time = time;
    }

    private TrafficRegulator tr;
    private int time;

    @Override
    public void run() {
        tr.setRedTime(time);
    }
}
