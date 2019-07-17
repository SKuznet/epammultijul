package hw1;

/**
 * Runnable that takes input int and assigns it to TrafficRegulator internal varible
 *
 */
public class ThreadYellow implements Runnable{

    ThreadYellow(TrafficRegulator tr, int time){
        this.tr = tr;
        this.time = time;
    }

    private TrafficRegulator tr;
    private int time;

    @Override
    public void run() {
        tr.setYellowTime(time);
    }
}
