package com.programming.practice.problems.array;

/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be
 * horizontal, vertical, diagonal or anti-diagonal.
 *
 * <pre>
 * Example:
 * Input:
 * [[0,1,1,0],
 * [0,1,1,0],
 * [0,0,0,1]]
 * Output: 3
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/">Longest
 *     Line of Consecutive One in Matrix</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class LongestLineOfConsecutiveOneInMatrix {

  private static final int HORIZONTAL = 0;
  private static final int VERTICAL = 1;
  private static final int DIAGONAL = 2;
  private static final int ANTI_DIAGONAL = 3;

  /**
   * Given a 01 matrix M, finds the longest line of consecutive one in the matrix. The line could be
   * horizontal, vertical, diagonal or anti-diagonal.
   *
   * @param M The 2D matrix.
   * @return The longest line of consecutive one in the matrix.
   */
  public int longestLine(final int[][] M) {

    final int rows = M.length;
    final int cols = rows > 0 ? M[0].length : 0;

    // dp is 3D array to keep track of maximum line with 1
    // e.g. dp[i][j][0] is used to store the number of continuous 1's found so far(till we reach the
    // element M[i][j]), along the horizontal lines only.
    final int[][][] dp = new int[rows][cols][4];
    int longestLine = 0;

    for (int rowIdx = 0; rowIdx < rows; ++rowIdx) {
      for (int colIdx = 0; colIdx < cols; ++colIdx) {

        if (M[rowIdx][colIdx] == 1) {
          dp[rowIdx][colIdx][HORIZONTAL] = colIdx > 0 ? dp[rowIdx][colIdx - 1][HORIZONTAL] + 1 : 1;
          dp[rowIdx][colIdx][VERTICAL] = rowIdx > 0 ? dp[rowIdx - 1][colIdx][VERTICAL] + 1 : 1;
          dp[rowIdx][colIdx][DIAGONAL] =
              rowIdx > 0 && colIdx > 0 ? dp[rowIdx - 1][colIdx - 1][DIAGONAL] + 1 : 1;

          dp[rowIdx][colIdx][ANTI_DIAGONAL] =
              rowIdx > 0 && colIdx < cols - 1 ? dp[rowIdx - 1][colIdx + 1][ANTI_DIAGONAL] + 1 : 1;

          longestLine =
              Math.max(
                  longestLine,
                  Math.max(
                      Math.max(dp[rowIdx][colIdx][HORIZONTAL], dp[rowIdx][colIdx][VERTICAL]),
                      Math.max(dp[rowIdx][colIdx][DIAGONAL], dp[rowIdx][colIdx][ANTI_DIAGONAL])));
        }
      }
    }

    return longestLine;
  }
}
