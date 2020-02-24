package com.programming.practice.problems.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 *
 * <p>Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * <p>Example 1:
 *
 * <p>Given nums = [1,1,2],
 *
 * <p>Your function should return length = 2, with the first two elements of nums being 1 and 2
 * respectively.
 *
 * <p>It doesn't matter what you leave beyond the returned length.
 *
 * <p>Example 2:
 *
 * <p>Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * <p>Your function should return length = 5, with the first five elements of nums being modified to
 * 0, 1, 2, 3, and 4 respectively.
 *
 * <p>It doesn't matter what values are set beyond the returned length.
 *
 * @see <a href = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/">Remove
 *     Duplicates from Sorted Array</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class RemoveDuplicatesFromSortedArray {

  /**
   * Removes the duplicates from the sorted array in place and returns the lenght of the new array.
   *
   * @param inputNumbers The array of numbers.
   * @return The length of the new array after removing the duplicates.
   */
  public int removeDuplicates(final int[] inputNumbers) {

    if (inputNumbers.length == 0) {
      return 0;
    }

    int ptr = 0;

    for (int i = 0; i < inputNumbers.length - 1; ++i) {
      if (inputNumbers[i] != inputNumbers[i + 1]) {
        inputNumbers[ptr++] = inputNumbers[i];
      }
    }

    // Input the last index element
    inputNumbers[ptr] = inputNumbers[inputNumbers.length - 1];

    return ptr + 1;
  }
}
