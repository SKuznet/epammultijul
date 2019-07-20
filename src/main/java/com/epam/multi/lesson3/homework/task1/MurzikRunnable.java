package com.epam.multi.lesson3.homework.task1;

public class MurzikRunnable implements Runnable {
    private int priority;
    private int videosOnOwnerPhone = 0;

    public MurzikRunnable(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Murzik nickname : " + Thread.currentThread() + ":" + " videosByOwnerAmount= " + videosOnOwnerPhone + ", priority=" + priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);

        while (true) {
            System.out.println(this);
            Thread.yield();
            if (++videosOnOwnerPhone == 10) {
                System.out.println("Memory on owner phone is over");
                return;
            }
        }
    }
}
