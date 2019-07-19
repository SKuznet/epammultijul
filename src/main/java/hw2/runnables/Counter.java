package hw2.runnables;

public class Counter implements Runnable {

    private static final int INITIAL_VALUE = 100_000;
    private static volatile boolean shouldRun;

    private final int priority;
    private int currentCount = INITIAL_VALUE;

    Counter(int priority) {
        validatePriority(priority);
        this.priority = priority;
    }

    @Override
    public void run() {
        shouldRun = true;
        Thread.currentThread().setPriority(priority);

        while (shouldRun) {
            if (currentCount-- > 0) {
                System.err.println(getMessage());
            } else {
                shouldRun = false;
            }
        }
    }

    private void validatePriority(int priority) {
        if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
            final String message =
                    String.format(
                            "Priority must be in range from %d to %d",
                            Thread.MIN_PRIORITY,
                            Thread.MAX_PRIORITY);
            throw new IllegalArgumentException(message);
        }
    }

    private String getMessage() {
        return String.format(
                "Counter in thread %s with priority %d tells %d",
                Thread.currentThread().getName(),
                priority,
                currentCount);
    }
}
