package com.programming.practice.problems.array;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the
 * array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums
 * up to n*k where n is also an integer.
 *
 * <pre>
 * Example 1:
 *
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 *
 * Example 2:
 *
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/continuous-subarray-sum/">Continuous subarray
 *     Sum</a>
 */
public final class ContinuousSubarraySum {

  /**
   * Checks if the array has a continuous subaray of size at least 2 that sums up to a multiple of
   * k.
   *
   * @param nums The nums array.
   * @param k The k number.
   * @return True If the array has a continuous subarray of size at least 2 that sums up to a
   *     multiple of k. False, otherwise.
   */
  public boolean checkSubarraySum(int[] nums, int k) {
    for (int i = 0; i < nums.length; ++i) {
      int sum = nums[i];
      for (int j = i + 1; j < nums.length; ++j) {
        sum += nums[j];

        if (sum == k || (k != 0 && sum % k == 0)) {
          return true;
        }
      }
    }

    return false;
  }
}
