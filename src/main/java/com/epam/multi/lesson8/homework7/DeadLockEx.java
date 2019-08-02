package com.epam.multi.lesson8.homework7;

import java.util.concurrent.TimeUnit;

public class DeadLockEx implements Runnable {

    private Consumer consumer = new Consumer();
    private Producer producer = new Producer();

    public DeadLockEx() {
        Thread.currentThread().setName("Main thread!");
        Thread thread = new Thread(this, "enemy thread");
        thread.start();
        consumer.buySomething(producer);
        System.out.println("Back to main thread!");
    }

    public static void main(String[] args) {
        new DeadLockEx();
    }

    public void run() {
        producer.produceSomething(consumer);
        System.out.println("Back to another thread!");
    }
}



class Consumer {

    synchronized void buySomething(Producer producer) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in method Consumer.buy()");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("Consumer class interrupted");
        }

        System.out.println(name + " trying to call method Producer.last()");
        producer.last();
    }



    synchronized void last() {
        System.out.println("In method Consumer.last()");
    }

}



class Producer {

    synchronized void produceSomething(Consumer consumer) {

        String name = Thread.currentThread().getName();
        System.out.println(name + " entered in method Producer.produce()");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("Producer class interrupted");
        }

        System.out.println(name + " trying to call method Consumer.last()");
        consumer.last();
    }

    synchronized void last() {
        System.out.println("In method Producer.last()");
    }
}
