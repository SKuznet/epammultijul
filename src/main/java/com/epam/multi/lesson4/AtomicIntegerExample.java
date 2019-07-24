package com.epam.multi.lesson4;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample implements Runnable {
    private AtomicInteger i = new AtomicInteger(0);

    public int getValue(){
        return i.get();
    }

    private void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while(true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting...");
                System.exit(0);
            }
        }, 5000); //end in 5 sec

        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerExample atomicIntegerExample = new AtomicIntegerExample();
        executorService.execute(atomicIntegerExample);

        while (true) {
            int val = atomicIntegerExample.getValue();

            if(val %2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
