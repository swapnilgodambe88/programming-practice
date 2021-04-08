package com.programming.practice.problems.array;

import java.util.*;

/**
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 *
 * <p>Return the least number of moves to make every value in A unique.
 *
 * <pre>
 * Example 1:
 *
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 *
 * Example 2:
 *
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 * @see <a href = "https://leetcode.com/problems/minimum-increment-to-make-array-unique/">Minimum
 *     Increment to Make Array Unique</a>
 */
public class MinimumIncrementToMakeArrayUnique {

  /**
   * Return the least number of moves to make every value in A unique.
   *
   * @param A The array.
   * @return The least number of moves to make every value in A unique.
   */
  public int minIncrementForUnique(final int[] A) {

    // Sort the input array.
    // Compared with previous number,
    // the current number need to be at least prev + 1.
    if (A.length == 0) {
      return 0;
    }

    Arrays.sort(A);
    int moves = 0;

    // Keeps track of the current unique number
    int currentUniqueNumber = A[0];

    for (int i = 1; i < A.length; ++i) {

      // Since the array is sorted, both the below conditions means a duplicate A[i]:
      // A[i] == A[i - 1] -> A[i - 1] was unaltered and A[i] is duplicate
      // A[i] <  A[i - 1] -> A[i - 1] was altered/incremented and A[i] is duplicate
      if (A[i] <= A[i - 1]) {
        currentUniqueNumber = A[i - 1] + 1;
        moves += (currentUniqueNumber - A[i]);

        // Change A[i] to the current unique number for the next iterations
        A[i] = currentUniqueNumber;
      } else {
        currentUniqueNumber = A[i];
      }
    }

    return moves;
  }
}
