package light.hw2;

import java.util.concurrent.TimeUnit;

public class RunnableImpl implements Runnable {

    int personalPriority;

    public RunnableImpl(int personalPriority) {
        this.personalPriority = personalPriority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(personalPriority);
        System.out.println(Thread.currentThread().getName() + ": I'm a Runnable and I'm ran. And my priority is: " + Thread.currentThread().getPriority());
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": I'm a Runnable and I сделаль!!! And my priority is: " + Thread.currentThread().getPriority());
    }
    //сет приорити
}
