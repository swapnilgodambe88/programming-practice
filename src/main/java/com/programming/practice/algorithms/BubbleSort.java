package com.programming.practice.algorithms;

/**
 * Class to perform bubble sort. Complexity: O (n ^ 2)
 *
 * <p>Copyright 2020.
 *
 * @author Swapnil Godambe
 */
final class BubbleSort {

  /**
   * Sorts the inputArray in place in ascending order.
   *
   * @param inputArray The input integer array that needs to be sorted in place.
   */
  public static void sortAscending(final int inputArray[]) {
    final int inputArrayLength = inputArray.length;

    for (int i = 0; i < inputArrayLength - 1; ++i) {

      boolean innerSwapHappened = false;
      for (int j = 0; j < inputArrayLength - i - 1; ++j) {

        if (inputArray[j + 1] < inputArray[j]) {
          innerSwapHappened = true;
          int temp = inputArray[j];
          inputArray[j] = inputArray[j + 1];
          inputArray[j + 1] = temp;
        }
      }

      if (!innerSwapHappened) {
        break;
      }
    }
  }

  /**
   * Sorts the inputArray in place in descending order.
   *
   * @param inputArray The input integer array that needs to be sorted in place.
   */
  public static void sortDescending(final int inputArray[]) {
    final int inputArrayLength = inputArray.length;

    for (int i = 0; i < inputArrayLength - 1; ++i) {

      boolean innerSwapHappened = false;
      for (int j = 0; j < inputArrayLength - i - 1; ++j) {

        if (inputArray[j + 1] > inputArray[j]) {
          innerSwapHappened = true;
          int temp = inputArray[j];
          inputArray[j] = inputArray[j + 1];
          inputArray[j + 1] = temp;
        }
      }

      if (!innerSwapHappened) {
        break;
      }
    }
  }
}
