package com.programming.practice.problems.array;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing
 * only 1's and return its area.
 *
 * <p><img src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" width = "25%"/>
 *
 * <pre>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 *
 * Example 2:
 *
 * Input: matrix = []
 * Output: 0
 *
 * Example 3:
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Example 4:
 *
 * Input: matrix = [["1"]]
 * Output: 1
 *
 * Example 5:
 *
 * Input: matrix = [["0","0"]]
 * Output: 0
 * </pre>
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximalRectangle {

  /**
   * Given a rows x cols binary matrix filled with 0's and 1's, finds the largest rectangle
   * containing only 1's and return its area.
   *
   * @param matrix
   * @return
   */
  public int maximalRectangle(final char[][] matrix) {
    final int rowCount = matrix.length;
    final int colCount = rowCount == 0 ? 0 : matrix[0].length;

    // A 2-d array to keep of number of consecutive ones each square in each row
    final int[][] dp = new int[rowCount][colCount];
    int maxRectangleArea = 0;

    for (int i = 0; i < rowCount; ++i) {
      for (int j = 0; j < colCount; ++j) {
        if (matrix[i][j] == '1') {

          // If j = 0 then dp[i][j] is one else add 1 to previous column's dp value
          dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;
          int width = dp[i][j];

          // Traverse up the row & try to find the minimum width, and update the maxArea accordingly
          for (int k = i; k >= 0; --k) {
            width = Math.min(width, dp[k][j]);
            final int length = i - k + 1;

            maxRectangleArea = Math.max(maxRectangleArea, length * width);
          }
        }
      }
    }

    return maxRectangleArea;
  }
}
