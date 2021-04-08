package com.programming.practice.problems.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 *
 * <p>Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ...
 * < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same
 * value (for 0 <= i < B.length - 1).
 *
 * <pre>
 * Example 1:
 *
 * Input: A = [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 *
 * Example 2:
 *
 * Input: A = [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 *
 * Example 3:
 *
 * Input: A = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 * @see <a href = "https://leetcode.com/problems/longest-arithmetic-subsequence/">Longest Arithmetic
 *     Subsequence</a>
 */
public class LongestArithmeticSubsequence {

  /**
   * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
   *
   * @param A An array of integers.
   * @return The length of the longest arithmetic subsequence in A.
   */
  public int longestArithSeqLength(final int[] A) {
    // An array of map where each map value will store the difference and the count for that index
    // e.g. mapArray[10]{2:4, 3:8} => at index 10 we so far had 4 subsequences with difference = 2 &
    // 8 subsequences with difference = 3
    final Map<Integer, Integer>[] mapArray = new HashMap[A.length];

    int result = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; ++i) {
      mapArray[i] = new HashMap<>();
      for (int j = 0; j < i; ++j) {
        final int difference = A[i] - A[j];

        // Check if index j had any subsequence with the same difference
        if (mapArray[j].containsKey(difference)) {
          // If yes then add 1 since j & i now have the same difference
          mapArray[i].put(difference, mapArray[j].get(difference) + 1);
        } else {
          // No previous occurrences. Therefore this is the first subsequence with value = 2
          mapArray[i].put(difference, 2);
        }

        result = Math.max(result, mapArray[i].get(difference));
      }
    }

    return result;
  }
}
