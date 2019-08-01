package com.epam.multi.lesson6.homework5;

import java.util.concurrent.Semaphore;

public class SemaphoreDigHoleEx {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i < 6; i++) {
            new  Thread(new SemaphoreWorker(semaphore, i)).start();
        }
    }
}

