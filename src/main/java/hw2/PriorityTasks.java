package hw2;

public class PriorityTasks implements Runnable {

    private int countDown = 5;
    private volatile double d;
    private int priority;

    public PriorityTasks(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {

            while (true) {
                // high load operation
                for (int i = 0; i < 100000; i++) {
                    d += (Math.PI + Math.E) / (double) i;

                    if (i % 1000 == 0) {
                        Thread.yield();
                    }
                }

                System.out.println("Executing thread: "
                        + Thread.currentThread().getName()
                        + " with priority: "
                        + Thread.currentThread().getPriority());

                if (--countDown == 0) {

                    System.out.println(Thread.currentThread().getName() + " task end");
                    return;
                }
            }

        }
    }
}
