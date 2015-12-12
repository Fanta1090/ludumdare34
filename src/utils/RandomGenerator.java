package utils;

import java.util.Random;

public class RandomGenerator {
  
  private static int min = 300;
  private static int max = 2000;

  public static int getRandomNumber() {
    Random rand = new Random();
    return rand.nextInt(max - min + 1) + min;
  }
}
