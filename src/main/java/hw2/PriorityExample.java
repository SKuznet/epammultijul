package hw2;

public class PriorityExample implements Runnable {

    private PriorityExample(int priotity) {
        Thread.currentThread().setPriority(priotity);
    }

    private void myPriority() {
        for (int i = 0; i < 10; i++) {
            System.out.println(
                    "Hi i'm " + Thread.currentThread().getName() + ", and my priority is " + Thread
                            .currentThread().getPriority());
        }
    }

    @Override
    public void run() {
        myPriority();
    }

    public static void main(String[] args) {
        new Thread(new PriorityExample(Thread.MAX_PRIORITY)).start();
        new Thread(new PriorityExample(4)).start();
        new Thread(new PriorityExample(Thread.MIN_PRIORITY)).start();
    }
}
