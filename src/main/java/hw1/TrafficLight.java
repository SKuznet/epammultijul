package hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class TrafficLight {

    Semaphore sem = new Semaphore(1); // 1 разрешение
    CommonResource res = new CommonResource();

    private List<Thread> list;

    TrafficLight() {
        list = new ArrayList<>();
        list.add(new Thread(new RedThread(res, sem)));
        list.add(new Thread(new YellowThread(res, sem)));
        list.add(new Thread(new GreenThread(res, sem)));
        for (Thread thread : list) {
            thread.start();
        }
    }

    public void checkTime(int specificMinute) {
        int b = specificMinute % 9;
        if (b >= 0 && b <= 2) {
            list.get(0).interrupt();
        } else if (b > 2 && b <= 5) {
            list.get(1).interrupt();
        } else if (b > 5 && b <= 9) {
            list.get(2).interrupt();
        }
    }
}
