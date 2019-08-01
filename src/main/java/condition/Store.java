package condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private ReentrantLock lock;
    private Condition condition;
    private int productAmount;

    public Store(){
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void get(){
        lock.lock();

        try{
            while (productAmount<1){
                condition.await();
            }
            productAmount--;
            System.out.println("1 product sold");
            System.out.println("Products on storage: " + productAmount);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void put(){
        lock.lock();

        try {
            while (productAmount >= 3) {
                condition.await();
            }
            productAmount++;
            System.out.println("1 product manufactured");
            System.out.println("Products on storage: " + productAmount);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
