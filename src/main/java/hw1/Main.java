package hw1;
//идея была в реализации попеременного включения света светофор в реальном времени, немного не
//не получилось, но по минтуам проверка работает

public class Main {

  public static void main(String[] args) {

    int[] minutes = {1,5,7,1,3,2};

    TrafficLight trafficLight = new TrafficLight();

    for (int minute : minutes) {
      try {
        {
          Thread.sleep(1000);
          trafficLight.checkTime(minute);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
