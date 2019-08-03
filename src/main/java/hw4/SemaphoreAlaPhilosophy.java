package hw4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreAlaPhilosophy {

    public static void main(String[] args) {

        // There are only two box office
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Book(semaphore, i).start();
        }
    }

}

class Book extends Thread {

    private Semaphore semaphore;
    private int instanceCount = 3;
    private int bookId;

    Book(Semaphore semaphore, int bookId) {
        this.semaphore = semaphore;
        this.bookId = bookId;
    }

    @Override
    public void run() {
        try {

            while (instanceCount > 0) {
                semaphore.acquire();
                System.out.println("Someone buy book " + bookId);
                TimeUnit.MILLISECONDS.sleep(500);
                instanceCount--;
                System.out.println("Book " + bookId + " left in the store: " + instanceCount);
                semaphore.release();
            }

            System.out.println("All bookId " + bookId + " were bought");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

