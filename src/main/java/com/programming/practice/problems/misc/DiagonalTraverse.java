package com.programming.practice.problems.misc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in
 * diagonal order as shown in the below image.
 *
 * <p>Example:
 *
 * <p>Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 *
 * <p>Output: [1,2,4,7,5,3,6,8,9]
 *
 * @see <a href = "https://leetcode.com/problems/diagonal-traverse/">Diagonal Traverse</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DiagonalTraverse {

  /**
   * @param matrix The 2D matrix.
   * @return All elements of the matrix in diagonal order.
   */
  public int[] findDiagonalOrder(final int[][] matrix) {

    if (matrix.length == 0) {
      return new int[0];
    }

    final int rowCount = matrix.length;
    final int colCount = matrix.length > 0 ? matrix[0].length : 0;

    final int[] diagonalTraverse = new int[rowCount * colCount];

    int index = 0;
    // A boolean that flips for every diagonal traversal
    boolean reverse = true;

    // Loop the upper half diagonal of the matrix
    for (int colIdx = 0; colIdx < colCount; ++colIdx) {
      final List<Integer> traversal = new LinkedList<>();

      for (int rowIdx = 0, tempColIdx = colIdx;
          isPositionValid(rowIdx, tempColIdx, rowCount, colCount);
          ++rowIdx, tempColIdx--) {
        traversal.add(matrix[rowIdx][tempColIdx]);
      }

      if (reverse) {
        Collections.reverse(traversal);
      }

      for (final int element : traversal) {
        diagonalTraverse[index++] = element;
      }

      reverse = !reverse;
    }

    // Loop the lower half diagonal of the matrix
    for (int rowIdx = 1; rowIdx < rowCount; ++rowIdx) {
      final List<Integer> traversal = new LinkedList<>();

      for (int colIdx = colCount - 1, tempRowIdx = rowIdx;
          isPositionValid(tempRowIdx, colIdx, rowCount, colCount);
          ++tempRowIdx, colIdx--) {
        traversal.add(matrix[tempRowIdx][colIdx]);
      }

      if (reverse) {
        Collections.reverse(traversal);
      }

      for (final int element : traversal) {
        diagonalTraverse[index++] = element;
      }

      reverse = !reverse;
    }

    return diagonalTraverse;
  }

  /**
   * Checks if a position is valid on the matrix.
   *
   * @param rowIdx The row index on matrix.
   * @param colIdx The column index on matrix.
   * @param rowCount The total row count on matrix.
   * @param colCount The total column count on matrix.
   * @return True If the position is valid. False, otherwise.
   */
  private static boolean isPositionValid(
      final int rowIdx, final int colIdx, final int rowCount, final int colCount) {

    if (rowIdx >= 0 && rowIdx < rowCount && colIdx >= 0 && colIdx < colCount) {
      return true;
    }

    return false;
  }
}
