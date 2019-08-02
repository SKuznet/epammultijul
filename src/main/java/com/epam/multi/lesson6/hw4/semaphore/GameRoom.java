package com.epam.multi.lesson6.hw4.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class GameRoom extends Thread {
    private Semaphore semaphore;
    private int gamePlayingCount;
    private int gamerId;

    public GameRoom(Semaphore semaphore, int gamerId) {
        this.semaphore = semaphore;
        this.gamerId = gamerId;
    }

    @Override
    public void run() {
        try {
            while (gamePlayingCount < 3) {
                semaphore.acquire();
                System.out.println("Gamer " + gamerId + " play in the game");
                TimeUnit.MILLISECONDS.sleep(500);
                gamePlayingCount++;
                System.out.println("Gamer " + gamerId + " play " + gamePlayingCount);
                System.out.println("Gamer " + gamerId + " leave the room");
                semaphore.release();

                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("Gamer " + gamerId + " is crying");
        }

    }
}
