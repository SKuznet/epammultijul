package main.java.hw1.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileArrayProvider {

  private List<Integer> listOfInts;
  private int[] resultArray;

 /**
  * Read integers from file one by one
  */
  public int[] readIntsInFile(String filename) throws IOException {
    listOfInts = new ArrayList<>();

    try (Scanner scanner = new Scanner(new File(filename))) {

      while (scanner.hasNextInt()) {
        listOfInts.add(scanner.nextInt());
      }
    }

    resultArray = new int[listOfInts.size()];

    for (int i = 0; i < listOfInts.size(); i++) {
      resultArray[i] = listOfInts.get(i);
    }
    return resultArray;
  }

/**
 * Get next minute(int) from file
 */
  public int getNextMinute() {
    int nextMinute = -1;
    if (!listOfInts.isEmpty()) {
      nextMinute = listOfInts.get(0);
      listOfInts.remove(0);
    }
    return nextMinute;
  }

/**
 * Check if there are more minutes(ints) in file
 */
  public boolean hasNextMinute() {
    return !listOfInts.isEmpty();
  }
}
