package com.programming.practice.problems.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>Example:
 *
 * <p>Given nums = [2, 7, 11, 15], target = 9,
 *
 * <p>Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @see <a href = "https://leetcode.com/problems/two-sum/">LeetCode - Two Sum</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
class TwoSum {

  /**
   * @param inputArray The input Array to find the two integer who's sum equals target.
   * @param target The target.
   * @return An array containing the indices of the two integers who's sum equals target.
   */
  public int[] twoSum(final int[] inputArray, final int target) {

    // A map of indices keyed by values of the array.
    // NOTE: HashMap and LinkedHashMap allow null values, But TreeMap doesn't
    final Map<Integer, Integer> indexMapKeyedByValue = new TreeMap<>();

    for (int i = 0; i < inputArray.length; i++) {
      final int possibleSecondElement = target - inputArray[i];

      if (!indexMapKeyedByValue.containsKey(possibleSecondElement)) {
        indexMapKeyedByValue.put(inputArray[i], i);
      } else {
        return new int[] {indexMapKeyedByValue.get(possibleSecondElement), i};
      }
    }

    throw new IllegalArgumentException("No solution exists for the given inputArray");
  }
}
