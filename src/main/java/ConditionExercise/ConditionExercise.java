package ConditionExercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExercise {

    public static void main(String[] args) {
        Store store = new Store();
        Manufacturer manufacturer = new Manufacturer(store);
        Customer customer = new Customer(store);

        new Thread(manufacturer).start();
        new Thread(customer).start();
    }

    static class Store{
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

                // signal to all
                condition.signalAll();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static class Manufacturer implements Runnable{

        private Store store;

        public Manufacturer(Store store){
            this.store = store;
        }

        @Override
        public void run() {
            for (int i = 0; i<50; i++){
                store.put();
            }
        }
    }

    static class Customer implements Runnable{
        private Store store;

        public Customer(Store store){
            this.store = store;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                store.get();
            }
        }
    }



}
