package hw4;

public class AtomicIncrement implements Runnable {
    private int number;
    
    public AtomicIncrement(int number) {
        this.number=number;
    }
    
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Main.atomicInteger.addAndGet(number));
        }
    }
}