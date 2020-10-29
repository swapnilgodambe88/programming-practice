package com.programming.practice.problems.array;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both
 * arrays.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/maximum-length-of-repeated-subarray/">Maximum
 *     Length of Repeated Subarray</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumLengthOfRepeatedSubarray {

  /**
   * Given two integer arrays A and B, return the maximum length of an subarray that appears in both
   * arrays.
   *
   * @param A The A array.
   * @param B The B array.
   * @return The maximum length of an subarray that appears in both arrays.
   */
  public int findLength(final int[] A, final int[] B) {
    final int[][] dp = new int[A.length][B.length];

    int max = 0;
    for (int i = 0; i < A.length; ++i) {
      for (int j = 0; j < B.length; ++j) {
        if (A[i] == B[j]) {
          if (i > 0 && j > 0) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = 1;
          }

          max = Math.max(max, dp[i][j]);
        }
      }
    }

    return max;
  }
}
