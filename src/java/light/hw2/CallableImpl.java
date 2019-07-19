package light.hw2;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable {

    @Override
    public Object call() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(Thread.currentThread().getName() + ": I'm a Callable and I'm ran.");
        Integer result = Thread.getAllStackTraces().toString().length();
        System.out.println(Thread.currentThread().getName() + ": I'm a Callable and I сделаль!!!");
        return result;
    }
}
