package hw2;

public class RunnableCat implements Runnable {

    private int id;

    public RunnableCat(int id) {
        this.id = id;
    }

    public void run() {
        Thread.currentThread().setPriority(id);
        System.out.println("i'm runnable " + id);
    }

}
