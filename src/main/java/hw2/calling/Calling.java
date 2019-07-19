package hw2.calling;

import java.util.concurrent.Callable;

public class Calling implements Callable<Integer> {

    private int id;

    public Calling(int id) {
        this.id = id;
    }

    @Override
    public Integer call() {
        int result = 0;
        for (int i = 0; i< 10; i++) {
            System.out.println("Thread with " + id + " counting: " + i);
            result += i;
        }
        return result;
    }
}
