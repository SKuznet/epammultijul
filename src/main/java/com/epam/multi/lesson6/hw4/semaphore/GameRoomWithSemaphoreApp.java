package com.epam.multi.lesson6.hw4.semaphore;

import com.epam.multi.lesson6.hw4.semaphore.GameRoom;

import java.util.concurrent.Semaphore;

public class GameRoomWithSemaphoreApp {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 6; i++) {
            new GameRoom(semaphore, i).start();

        }
    }
}
