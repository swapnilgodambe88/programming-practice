package com.programming.practice.problems.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral
 * order.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/spiral-matrix/">Spiral Matrix</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class SpiralMatrix {

  /**
   * Returns all elements of the matrix in spiral order.
   *
   * @param matrix The 2D matrix.
   * @return Elements of the matrix in spiral order.
   */
  public List<Integer> spiralOrder(final int[][] matrix) {

    final List<Integer> result = new LinkedList<>();

    int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1;
    int colEnd = rowEnd >= 0 ? matrix[0].length - 1 : 0;

    while (rowStart <= rowEnd && colStart <= colEnd) {

      // left -> right
      for (int i = colStart; i <= colEnd; ++i) {
        result.add(matrix[rowStart][i]);
      }
      rowStart++;

      // top -> bottom
      for (int i = rowStart; i <= rowEnd; ++i) {
        result.add(matrix[i][colEnd]);
      }
      colEnd--;

      // right -> left
      if (rowStart <= rowEnd) {
        for (int i = colEnd; i >= colStart; --i) {
          result.add(matrix[rowEnd][i]);
        }
        rowEnd--;
      }

      // bottom -> top
      if (colStart <= colEnd) {
        for (int i = rowEnd; i >= rowStart; --i) {
          result.add(matrix[i][colStart]);
        }
        colStart++;
      }
    }
    return result;
  }
}
