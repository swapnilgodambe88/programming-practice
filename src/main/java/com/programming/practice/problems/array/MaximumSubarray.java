/** */
package com.programming.practice.problems.array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * <p>Example:
 *
 * <p>Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * @see <a href = "https://leetcode.com/problems/maximum-subarray/">Maximum Subarray</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumSubarray {

  /**
   * Finds the largest sum among the contiguous subarray.
   *
   * @param nums The array of numbers.
   * @return The maximum sum.
   */
  public int maxSubArray(final int[] nums) {

    int maxSoFar = Integer.MIN_VALUE, maxEndHere = 0;

    for (final int num : nums) {
      maxEndHere += num;

      if (maxEndHere > maxSoFar) {
        maxSoFar = maxEndHere;
      }

      // For negative number the max sum will only be single negative integer. Therefore no point in
      // evaluating further and resetting the maxEndHere to zero.
      if (maxEndHere < 0) {
        maxEndHere = 0;
      }
    }

    return maxSoFar;
  }
}
