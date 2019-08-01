package com.epam.multi.lesson6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PhilosophyTaskEx {
    public static void main(String[] args) {
        Semaphore semaphore =  new Semaphore(2);
        for (int i = 1; i < 6; i++) {
            new Philosopher(semaphore, i).start();
        }
    }
}


class Philosopher extends Thread{
    private Semaphore semaphore;
    private int eat;
    private int id;

    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }
    
    @Override
    public void run(){
        try {
            while (eat<3){
                semaphore.acquire();
                System.out.println(id + "eating");
                TimeUnit.MILLISECONDS.sleep(500);
                eat++;
                System.out.println(id+ "stop eat");
                semaphore.release();
                TimeUnit.MILLISECONDS.sleep(500);

            }
        } catch (InterruptedException e){
            System.err.println(id+" trouble");
        }
    }
}