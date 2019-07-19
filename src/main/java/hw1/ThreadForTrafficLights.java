package hw1;

public class ThreadForTrafficLights {

    private TrafficLights trafficLights;
    private Thread thread;
    private int millis;

    public ThreadForTrafficLights(final TrafficLights trafficLights, final int millis) {

        this.trafficLights = trafficLights;
        if (millis > 0) {
            this.millis = millis;
        }

        this.thread = new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(millis);
                    System.out.println(Thread.currentThread() + " " + trafficLights.getLight());
                } catch (InterruptedException e) { System.err.print("Ouch"); }
            }
        });
    }

    public void startThread() {
        thread.start();
    }
}
