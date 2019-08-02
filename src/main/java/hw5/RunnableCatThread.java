package hw5;

import hw6.Conditional.CatState;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RunnableCatThread implements Runnable {
    private Semaphore semaphore;

    private CatState catState;
    private int id;
    private static int counter;

    public RunnableCatThread(Semaphore semaphore, CatState catState) {
        this.semaphore = semaphore;
        this.catState = catState;
        this.id = counter++;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < 2; i++) {
                feedCat();
                System.out.println(this.id + " is " + catState.toString());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
    
    private void feedCat(){
        if (catState.equals(CatState.FULL))
            catState = CatState.OVERFEED;
        if (catState.equals(CatState.HUNGRY))
            catState = CatState.FULL;
        
    }
}
