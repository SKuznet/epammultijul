package main.java.hw1;

import java.io.IOException;
import main.java.hw1.util.FileArrayProvider;

public class Demo {

  public static void main(String[] args) throws IOException {
      FileArrayProvider fileProvider = new FileArrayProvider();

      fileProvider.readIntsInFile("epammultijul/src/main/java/hw1/resources/Ints.txt");

      TrafficLight tl1 = new TrafficLight(fileProvider);
      TrafficLight tl2 = new TrafficLight(fileProvider);
      TrafficLight tl3 = new TrafficLight(fileProvider);

      Thread t1 = new Thread(tl1);
      Thread t2 = new Thread(tl2);
      Thread t3 = new Thread(tl3);

      if (fileProvider.hasNextMinute()) {
          t1.start();
          t2.start();
          t3.start();
      }
  }
}
