package com.programming.practice.problems.array;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * <p>Example:
 *
 * <p>Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 *
 * <p>Note:
 *
 * <p>You must do this in-place without making a copy of the array. Minimize the total number of
 * operations.
 *
 * @see <a href = "https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class MoveZeros {

  /**
   * Moves all the zeros to the end of the array while maintaining the relative order of non-zero
   * elements.
   *
   * @param nums The array of numbers.
   */
  public void moveZeroes(final int[] nums) {

    int insertIndex = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) {
        nums[insertIndex++] = nums[i];
      }
    }

    while (insertIndex < nums.length) {
      nums[insertIndex++] = 0;
    }
  }
}
