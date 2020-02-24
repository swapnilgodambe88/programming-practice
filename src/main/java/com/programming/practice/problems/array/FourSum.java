package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
 * nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the
 * sum of target.
 *
 * <p>Note:
 *
 * <p>The solution set must not contain duplicate quadruplets.
 *
 * <p>Example:
 *
 * <p>Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * <p>A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 *
 * @see <a href = "https://leetcode.com/problems/4sum/">4 Sum</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FourSum {

  /**
   * @param inputArray The input array.
   * @param target The target for the 4 sum.
   * @return Combination of 4 integers such that their sum equals target.
   */
  public List<List<Integer>> fourSum(final int[] inputArray, int target) {
    Arrays.sort(inputArray);

    final List<List<Integer>> fourSumList = new ArrayList<>();

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        int start = j + 1;
        int end = inputArray.length - 1;

        while (start < end) {
          final int sum = inputArray[i] + inputArray[j] + inputArray[start] + inputArray[end];

          if (sum == target) {
            final List<Integer> quadruplet =
                Arrays.asList(inputArray[i], inputArray[j], inputArray[start], inputArray[end]);

            // Only add quadruplet if it doesn't exists on the list
            if (!fourSumList.contains(quadruplet)) {
              fourSumList.add(quadruplet);
            }

            start++;
            end--;
          } else if (sum < target) {
            start++;
          } else {
            end--;
          }
        }
      }
    }

    return fourSumList;
  }
}
