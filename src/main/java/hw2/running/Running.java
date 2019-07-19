package hw2.running;


public class Running implements Runnable {

    private int id;

    public Running(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread with " + id + " counting: " + i);
        }
    }
}
