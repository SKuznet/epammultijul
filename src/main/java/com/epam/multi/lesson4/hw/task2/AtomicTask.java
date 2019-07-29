package com.epam.multi.lesson4.hw.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTask {
    private volatile static AtomicInteger atomicInteger = new AtomicInteger();

    public static void incrementAtomicInteger(int amount){
        System.out.println(atomicInteger.addAndGet(amount));
    }
}
