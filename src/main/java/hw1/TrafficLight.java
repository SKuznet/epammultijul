package main.java.hw1;

import main.java.hw1.util.FileArrayProvider;

public class TrafficLight implements Runnable {

  FileArrayProvider fileArrayProvider;
  private int enteredMinute;

  public TrafficLight(FileArrayProvider fileArrayProvider) {
    this.fileArrayProvider = fileArrayProvider;
  }

  @Override
  public void run() {
    double tmp;

    while (fileArrayProvider.hasNextMinute()) {

      enteredMinute = fileArrayProvider.getNextMinute();
      tmp = enteredMinute % 9;

      if (tmp >= 0 && tmp < 2) {
        System.out.println(LightColor.RED + " on " + enteredMinute + " minute "
            + Thread.currentThread().getName());
      } else if (tmp >= 2 && tmp < 5) {
        System.out.println(LightColor.YELLOW + " on " + enteredMinute + " minute "
            + Thread.currentThread().getName());
      } else {
        System.out.println(LightColor.GREEN + " on " + enteredMinute + " minute "
            + Thread.currentThread().getName());
      }
    }
  }
}
