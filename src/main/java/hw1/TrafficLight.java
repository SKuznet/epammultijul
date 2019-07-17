package main.java.hw1;

import main.java.hw1.util.FileArrayProvider;

public class TrafficLight implements Runnable {

 private FileArrayProvider fileArrayProvider;
  private int enteredMinute;

   TrafficLight(FileArrayProvider fileArrayProvider) {
    this.fileArrayProvider = fileArrayProvider;
  }

  @Override
  public void run() {
    while (fileArrayProvider.hasNextMinute()) {

      enteredMinute = fileArrayProvider.getNextMinute();
      LightColor lightColor = TrafficLightColorChooser.getLightColor(enteredMinute);
      System.out.println(lightColor + " on " + enteredMinute + " minute " + Thread.currentThread().getName());
    }
  }
}
