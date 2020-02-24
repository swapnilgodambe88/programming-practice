package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * <p>Note:
 *
 * <p>The solution set must not contain duplicate triplets.
 *
 * <p>Example:
 *
 * <p>Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * <p>A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 *
 * @see <a href = "https://leetcode.com/problems/3sum/">3 sum</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class ThreeSum {

  // private Map<Integer, Integer> getIndexMapKeyedByValue

  /**
   * @param inputArray The number array to evaluate.
   * @return A list of unique triplets which gives the sum of zero.
   */
  public List<List<Integer>> threeSum(final int[] inputArray) {

    Arrays.sort(inputArray);

    final List<List<Integer>> threeSumSolution = new ArrayList<>();

    for (int current = 0; current < inputArray.length - 2; current++) {
      int left = current + 1;
      int right = inputArray.length - 1;

      while (left < right) {
        final int sum = inputArray[current] + inputArray[left] + inputArray[right];

        if (sum == 0) {
          final List<Integer> triplet =
              Arrays.asList(inputArray[current], inputArray[left], inputArray[right]);

          // Only add triplet if it doesn't exists
          if (!threeSumSolution.contains(triplet)) {
            threeSumSolution.add(triplet);
          }

          left++;
          right--;
        } else if (sum > 0) {
          right--;
        } else {
          left++;
        }
      }
    }
    return threeSumSolution;
  }
}
