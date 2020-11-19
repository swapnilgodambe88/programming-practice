package com.programming.practice.problems.array;

import java.util.Arrays;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all
 * array elements equal, where a move is incrementing n - 1 elements by 1. </pre>
 *
 * Example:
 *
 * <p>Input: [1,2,3]
 *
 * <p>Output: 3
 *
 * <p>Explanation: Only three moves are needed (remember each move increments two elements):
 *
 * <p>[1,2,3] => [2,3,3] => [3,4,3] => [4,4,4] </pre>
 *
 * @see <a href = "https://leetcode.com/problems/minimum-moves-to-equal-array-elements/">Minimum
 *     Moves to Equal Array Elements</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumMovesToEqualArrayElements {

  /**
   * Finds the minimum number of moves required to make all array elements equal.
   *
   * @param nums The nums array.
   * @return The minimum number of moves required to make all array elements equal.
   */
  public int minMoves(final int[] nums) {
    Arrays.sort(nums);

    int moves = 0;

    // Sorting makes the last element the largest element.
    // After every iteration we make the nums[0] equal to the largest element (and hence we can
    // ignore the nums[i] in following iterations, since it will be increments along with any
    // increments with nums[0]

    // Every iteration makes nums[i-1] element the largest element for the next iteration
    for (int i = nums.length - 1; i > 0; --i) {
      moves += nums[i] - nums[0];
    }

    return moves;
  }
}
