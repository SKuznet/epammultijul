package atm;

import java.util.concurrent.*;

public class AtmService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Withdrawal(500));
        executorService.execute(new Withdrawal(300));
        executorService.execute(new Withdrawal(300));
        executorService.shutdown();
    }
}
