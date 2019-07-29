package hw2;

import java.util.concurrent.TimeUnit;

public class CastSpell implements Runnable {

    private int priority;

    public CastSpell(){

    };

    public CastSpell(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        getStatus();
    }

    public void getStatus(){
        for (int i = 10; i > 0; i--) {
            System.out.println("Thread " +Thread.currentThread().getName() + ": " + i);
        }
    }
}
