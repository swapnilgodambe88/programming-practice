package com.programming.practice.problems.array;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the three integers. You may assume that each
 * input would have exactly one solution.
 *
 * <p>Example:
 *
 * <p>Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * <p>The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @see <a href = "https://leetcode.com/problems/3sum-closest/">3Sum Closest</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class ThreeSumClosest {

  /**
   * @param inputArray The input array.
   * @param target The target.
   * @return Sum closest to target.
   */
  public int threeSumClosest(final int[] inputArray, final int target) {
    Arrays.parallelSort(inputArray);

    int closestThreeSum = inputArray[0] + inputArray[1] + inputArray[2];

    for (int current = 0; current < inputArray.length - 2; current++) {
      int left = current + 1;
      int right = inputArray.length - 1;

      while (left < right) {
        final int sum = inputArray[current] + inputArray[left] + inputArray[right];

        if (sum > target) {
          right--;
        } else {
          left++;
        }

        if (Math.abs(sum - target) <= Math.abs(closestThreeSum - target)) {
          closestThreeSum = sum;
        }
      }
    }

    return closestThreeSum;
  }
}
