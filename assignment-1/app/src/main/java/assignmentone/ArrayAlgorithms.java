package assignmentone;

import java.util.Random;

/**
 * in the class get array and work with it.
 */
public class ArrayAlgorithms {
  Random rand = new Random();

  /**
   *  return average of all elements.
   */
  public double average(int[] list) {
    double ave = 0;

    for (int i = 0; i < list.length; i++) {
      ave += list[i];
    }
    return ave / list.length;
  }

  /**
   *  return max value in the list.
   */
  public int maxValue(int[] list) {
    int max = 0;
    
    for (int i = 0; i < list.length; i++) {
      if (list[i] > max) {
        max = list[i];
      }
    }
    return max;
  }

  /**
   *  return minimum value in the list.
   */
  public int minIndex(int[] list) {
    int smallestIndexPosition = 0;
    int smallestValue = list[0];
    for (int i = 0; i < list.length; i++) {
      if (list[i] < smallestValue) {
        smallestValue = list[i];
        smallestIndexPosition = i;
      }
    }
    return smallestIndexPosition;
  }

  /**
   *  return back list with move first element to left.
   */
  public int[] shift(int[] list) {
    int first = list[0];
    for (int i = 0; i < list.length - 1; i++) {
      list[i] = list[i + 1];
    }
    list[list.length - 1] = first;
    return list;
  }

  /**
   *  return back list but with shuffled .
   */
  public int[] shuffle(int[] list) {
    for (int i = 0; i < list.length; i++) {
      int index = rand.nextInt(list.length);
      int temp = list[i];
      list[i] = list[index];
      list[index] = temp;
    }
    return list;
  }
}
