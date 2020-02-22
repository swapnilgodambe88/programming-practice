package com.programming.practice.problems.array;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the
 * new length.
 *
 * <p>Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * <p>The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * <p>Example 1:
 *
 * <p>Given nums = [3,2,2,3], val = 3,
 *
 * <p>Your function should return length = 2, with the first two elements of nums being 2.
 *
 * <p>It doesn't matter what you leave beyond the returned length.
 *
 * <p>Example 2:
 *
 * <p>Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * <p>Your function should return length = 5, with the first five elements of nums containing 0, 1,
 * 3, 0, and 4.
 *
 * <p>Note that the order of those five elements can be arbitrary.
 *
 * <p>It doesn't matter what values are set beyond the returned length.
 *
 * @see <a href = "https://leetcode.com/problems/remove-element/">Remove Element</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class RemoveElement {

  /**
   * Removes the valueToRemove element from the array.
   *
   * @param inputArray The input array.
   * @param valueToRemove The value to be removed from the array.
   * @return The length of the array after removing the value.
   */
  public int removeElement(final int[] inputArray, final int valueToRemove) {
    int ptr = 0;

    for (final int element : inputArray) {
      if (element != valueToRemove) {
        inputArray[ptr++] = element;
      }
    }
    return ptr;
  }
}
