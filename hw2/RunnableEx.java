package hw2;

public class RunnableEx implements Runnable {

    private int id;

    public RunnableEx(int id) {
        this.id = id;
    }

    public void run() {
        Thread.currentThread().setPriority(id);
        System.out.println("I'm runnable " + id);
    }

}