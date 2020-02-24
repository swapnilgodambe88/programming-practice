package com.programming.practice.algorithms;

/**
 * Class to perform Quick Sort. Complexity: O (n log n)
 *
 * <p>Copyright 2020.
 *
 * @author Swapnil Godambe
 */
public final class QuickSort {

  /**
   * Sorts the inputArray in place in ascending order.
   *
   * @param inputArray The input integer array that needs to be sorted in place.
   * @param beginIndex The begin index for the sort.
   * @param endIndex The end index for the sort.
   */
  public static void sortAscending(
      final int[] inputArray, final int beginIndex, final int endIndex) {
    if (beginIndex < endIndex) {

      final int pivotIndex = partitionAscending(inputArray, beginIndex, endIndex);

      sortAscending(inputArray, beginIndex, pivotIndex - 1);
      sortAscending(inputArray, pivotIndex + 1, endIndex);
    }
  }

  /**
   * Partitions the inputArray and returns the partition index such that all elements to left are
   * less than pivot element, and all elements to right are greater than or equal to the pivot
   * element.
   *
   * @param inputArray The input integer array that needs to be sorted in place.
   * @param beginIndex The begin index for the sort.
   * @param endIndex The end index for the sort.
   * @return The index of the pivot element after arranging the inputArray.
   */
  private static int partitionAscending(
      final int[] inputArray, final int beginIndex, final int endIndex) {

    final int pivotElement = inputArray[endIndex];

    // Index to keep track of the last element in array which holds all elements
    // less than the pivot element
    int smallerArrayIndex = beginIndex - 1;

    // Don't include the pivot element. Therefore excluding the last index
    for (int i = beginIndex; i < endIndex; i++) {

      if (inputArray[i] < pivotElement) {
        // Increment the array length that holds elements less than pivotELement.
        smallerArrayIndex++;

        // Swap the inputArray[i] with next first element outside of the smaller array
        int tempSwap = inputArray[i];
        inputArray[i] = inputArray[smallerArrayIndex];
        inputArray[smallerArrayIndex] = tempSwap;
      }
    }

    int tempSwap = inputArray[smallerArrayIndex + 1];
    inputArray[smallerArrayIndex + 1] = inputArray[endIndex];
    inputArray[endIndex] = tempSwap;

    return smallerArrayIndex + 1;
  }
}
