package com.programming.practice.algorithms;

/**
 * Class to perform Insertion Sort. Complexity: O (n ^ 2)
 *
 * <p>Copyright 2020.
 *
 * @author Swapnil Godambe
 */
public final class InsertionSort {

  /** Constructor for {@link InsertionSort}. Declared private to prevent direct instantiation. */
  public InsertionSort() {
    throw new UnsupportedOperationException("Constructor invocation for InsertionSort forbidden");
  }

  /**
   * Sorts the inputArray in place in ascending order.
   *
   * @param inputArray The input integer array that needs to be sorted in place.
   */
  public static void sortAscending(final int[] inputArray) {

    final int inputArrayLength = inputArray.length;
    for (int i = 0; i < inputArrayLength; ++i) {

      final int elementToInsert = inputArray[i];
      int j = i - 1;

      while (j >= 0 && inputArray[j] > elementToInsert) {
        inputArray[j + 1] = inputArray[j];
        --j;
      }

      inputArray[j + 1] = elementToInsert;
    }
  }

  /**
   * Sorts the inputArray in place in descending order.
   *
   * @param inputArray The input integer array that needs to be sorted in place.
   */
  public static void sortDescending(final int[] inputArray) {

    final int inputArrayLength = inputArray.length;
    for (int i = 0; i < inputArrayLength; ++i) {

      final int elementToInsert = inputArray[i];
      int j = i - 1;

      while (j >= 0 && inputArray[j] < elementToInsert) {
        inputArray[j + 1] = inputArray[j];
        --j;
      }

      inputArray[j + 1] = elementToInsert;
    }
  }
}
