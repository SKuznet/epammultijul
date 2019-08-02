package com.epam.multi.lesson8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    private final String[] messages = {
            "You are preparing for assessment...",
            "You passed the assessment",
            "You received new grade",
            "What next?"
    };

    private BlockingQueue<String> drop;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.drop = new ArrayBlockingQueue<>(1, true);
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    class Producer implements Runnable{

        @Override
        public void run() {
            try{
                int count = 0;
                for(String message : messages){
                    drop.put(message);
                    if(++count < 4){
                        TimeUnit.SECONDS.sleep(2);
                    }
                }
                drop.put("done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            try{
                String msg;
                while(!(drop.take()).equals("done")){

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
