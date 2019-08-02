package hw6;

import java.util.concurrent.*;

public class Factory {

    private static Car car = new Car();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Exchanger<Car> exchanger = new Exchanger<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        //Welders start to weld a car, they can only weld one at a time
        executorService.execute(new Welder(semaphore, car));
        executorService.execute(new Welder(semaphore, car));
        executorService.execute(new Welder(semaphore, car));
        //when welding is complete, welder sets car parameter isWelded to true
        //then Painters start to paint
        //Painter has to paint 5 times, then another Painter can start painting
        executorService.execute(new Painter(countDownLatch, exchanger, car));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        executorService.execute(new Painter(countDownLatch, exchanger, car));
        //when painting is complete, painter sets car parameter isPainted to true
        //Painter gives car to cleaner (through exchange)
        Thread cleaner = new Thread(new Cleaner(exchanger));
        //Cleaner cleans received car, sets parameter isCleaned to true, and shows its status
        executorService.execute(cleaner);
    }
}