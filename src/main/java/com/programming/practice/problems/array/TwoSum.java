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
 * @url https://leetcode.com/problems/two-sum/
 * @author swapnil
 */
class TwoSum {

  public int[] twoSum(final int[] inputArray, final int target) {

    // A map of indices keyed by values of the array.
    // NOTE: HashMap and LinkedHashMap allow null values, But TreeMap doesn't
    final Map<Integer, Integer> indexMapKeyedByValue = new TreeMap<>();

    // Populate the map
    for (int i = 0; i < inputArray.length; i++) {
      indexMapKeyedByValue.put(inputArray[i], i);
    }

    for (int i = 0; i < inputArray.length; i++) {
      final int possibleSecondElement = target - inputArray[i];

      if (indexMapKeyedByValue.containsKey(possibleSecondElement)
          && i != indexMapKeyedByValue.get(possibleSecondElement)) {
        return new int[] {i, indexMapKeyedByValue.get(possibleSecondElement)};
      }
    }

    throw new IllegalArgumentException("No solution exists for the given inputArray");
  }
}
