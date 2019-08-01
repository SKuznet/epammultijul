package Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    public static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    //Думал полчаса, фантазии не хватило на другой прример
                    number.addAndGet(2);
                    if(number.get()%2!=0){
                        System.err.println(number.get());
                        System.exit(0);
                    }

                }
            }
        });
    }
}
