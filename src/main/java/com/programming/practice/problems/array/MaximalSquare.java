package com.programming.practice.problems.array;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and
 * return its area.
 *
 * <pre>
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 * </pre>
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class MaximalSquare {

  /**
   * Given a 2D binary matrix filled with 0's and 1's, finds the largest square containing only 1's
   * and return its area.
   *
   * @param matrix The 2D matrix.
   * @return The area of largest square containing only 1's.
   */
  public int maximalSquare(final char[][] matrix) {

    final int rows = matrix.length;
    final int cols = rows > 0 ? matrix[0].length : 0;

    // dp(i,j) area of the maximum square whose bottom right corner is the cell with index (i,j) in
    // the original matrix.
    final int[][] dp = new int[rows][cols];
    int maxLength = 0;

    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {

        if (matrix[i][j] == '1') {
          if (i > 0 && j > 0) {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          } else {
            // For first row or first column the dp[i][j] will always be 1 if the cell is 1.
            dp[i][j] = 1;
          }

          maxLength = Math.max(maxLength, dp[i][j]);
        }
      }
    }
    return maxLength * maxLength;
  }
}
