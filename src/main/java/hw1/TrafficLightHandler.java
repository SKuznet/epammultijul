package hw1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TrafficLightHandler {
  private static final int THREADS_NUMBER = 3;
  private final TrafficLight trafficLight = new TrafficLightImpl();

  /**
   * Method matches time (minutes) and traffic light color at the moment
   * and prints this information in a console.
   * @param minutes int array that represents minutes
   */
  public void printColors(int... minutes) {
    AtomicInteger atomicIndex = new AtomicInteger(0);
    Runnable runnable = () -> {
      int index;
      while ((index = atomicIndex.getAndIncrement()) < minutes.length) {
        int minute = minutes[index];
        TrafficLightColor trafficLightColor = trafficLight.getCurrentColor(minute);
        System.out.println(Thread.currentThread().getName()
            + ", minutge: " + minute
            + ", color: " + trafficLightColor);
      }
    };

    ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
    for (int i = 0; i < THREADS_NUMBER; i++) {
      executorService.execute(runnable);
    }
    executorService.shutdown();
  }

  public static void main(String[] args) {
    TrafficLightHandler trafficLightHandler = new TrafficLightHandler();
    trafficLightHandler.printColors(1, 3, 4, 6, 8, 9, 11, 14, 17, 22, 29, 44, 60, 239);
  }
}
