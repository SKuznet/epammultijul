package hw7;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Horse implements Runnable {

    private int speed;
    private int id;
    private ArrayList<Integer> winnerList;

    public Horse(int id, ArrayList<Integer> winnerList) {
        this.id = id;
        this.winnerList = winnerList;
    }

    @Override
    public void run() {
        speed = new Random().nextInt(5)*10;
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        winnerList.add(id);
    }
}
