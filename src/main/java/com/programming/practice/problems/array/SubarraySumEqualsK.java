package com.programming.practice.problems.array;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous sub
 * arrays whose sum equals to k.
 *
 * <p>Example 1: Input:nums = [1,1,1], k = 2 Output: 2
 *
 * @see <a href = "https://leetcode.com/problems/subarray-sum-equals-k/">Subarray Sum Equals K</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class SubarraySumEqualsK {

  /**
   * Finds the number of contiguous sub arrays whose sum equals to k.
   *
   * @param nums The array of numbers.
   * @param k The number k.
   * @return The number of contiguous sub arrays whose sum equals to k.
   */
  public int subarraySum(final int[] nums, final int k) {

    int count = 0, cumulativeSum = 0;

    // Map to store cumulative sum
    final HashMap<Integer, Integer> map = new HashMap<>();

    // A zero entry is added for scenarios where a subset is present starting with index 0
    map.put(0, 1);
    for (final int number : nums) {
      cumulativeSum += number;

      if (map.containsKey(cumulativeSum - k)) count += map.get(cumulativeSum - k);

      map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
    }
    return count;
  }
}
