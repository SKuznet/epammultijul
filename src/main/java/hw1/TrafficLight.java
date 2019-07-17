package main.java.hw1;

import main.java.hw1.util.FileArrayProvider;

public class TrafficLight implements Runnable {

  private FileArrayProvider fileArrayProvider;
  private ConstructorParameter constructorParameter;
  private int enteredMinute;

  TrafficLight(FileArrayProvider fileArrayProvider) {
    this.fileArrayProvider = fileArrayProvider;
    this.constructorParameter = ConstructorParameter.FILE_ARRAY_PROVIDER;
  }

  public TrafficLight(int enteredMinute) {
    this.enteredMinute = enteredMinute;
    this.constructorParameter = ConstructorParameter.ENTERED_MINUTE;
  }

  @Override
  public void run() {
    LightColor lightColor;
    switch (constructorParameter) {
      case FILE_ARRAY_PROVIDER:
        while (fileArrayProvider.hasNextMinute()) {
          enteredMinute = fileArrayProvider.getNextMinute();
          lightColor = TrafficLightColorChooser.getLightColor(enteredMinute);
          printLight(lightColor, enteredMinute);
        }
        break;

      case ENTERED_MINUTE:
        lightColor = TrafficLightColorChooser.getLightColor(enteredMinute);
        printLight(lightColor, enteredMinute);
        break;
    }
  }

  private static void printLight(LightColor lightColor, int enteredMinute) {
    System.out.println(
        lightColor + " on " + enteredMinute + " minute " + Thread.currentThread().getName());
  }
}
