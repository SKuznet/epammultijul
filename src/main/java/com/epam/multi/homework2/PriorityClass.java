package com.epam.multi.homework2;

/**
 * Class release thread priority logic
 */
public class PriorityClass implements Runnable {

    private int priority;

    PriorityClass(int priority) {
        this.priority = priority;
    }

    /**
     * Sets priority of current thread and shows its name with priority number
     */
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " priority: " + priority);
        }
    }
}
