package hw6;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchMain {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);
    private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final Developer developer = new Developer(countDownLatch);
            service.execute(new CalbackNotifier(
                    developer, () -> System.out.println("Finished " + developer.getId())));
        }
        TimeUnit.MILLISECONDS.sleep(random.ints(80, 200).findFirst().getAsInt());
        System.out.println("Time is up!");
        service.shutdownNow();
    }
}