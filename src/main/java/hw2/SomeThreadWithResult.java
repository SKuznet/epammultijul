package hw2;

import java.util.concurrent.Callable;

public class SomeThreadWithResult implements Callable<String> {

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName() + " do something and return result" );

        return Thread.currentThread().getName() + " my result";
    }
}
