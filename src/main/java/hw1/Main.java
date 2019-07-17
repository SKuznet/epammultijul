package hw1;

import static java.lang.Thread.sleep;

/**
 *  Main class.
 *  Initializes array of ints - intervals for lights switching.
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] time = new int[]{2, 3, 4};

        final TrafficRegulator tr = new TrafficRegulator();

        new ThreadRed(tr, time[0]).run();
        new ThreadYellow(tr, time[1]).run();
        new ThreadGreen(tr, time[2]).run();

        Thread regulator = new Thread(tr);

        Thread read = new Thread(new Runnable(){
            @Override
            public void run() {
                while (true){
                    switch (tr.getLigths()){
                        case RED:
                            System.out.println("Red"); break;
                        case YELLOW:
                            System.out.println("Yellow"); break;
                        case GREEN:
                            System.out.println("Green"); break;
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        read.start();
        regulator.start();

    }





}
