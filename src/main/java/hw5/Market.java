package main.java.hw5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Market {
    ReentrantLock lock;
    Condition condition;
    int product;

    public Market () {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void put(){

    }

    public void get() {

    }

}
