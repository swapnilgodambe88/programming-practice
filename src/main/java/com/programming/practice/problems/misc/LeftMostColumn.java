package com.programming.practice.problems.misc;

import java.util.List;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this
 * row is sorted in non-decreasing order.
 *
 * <p>Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at
 * least a 1 in it. If such index doesn't exist, return -1.
 *
 * <p>You can't access the Binary Matrix directly. You may only access the matrix using a
 * BinaryMatrix interface:
 *
 * <p>BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is
 * rows * cols.
 *
 * <p>Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also,
 * any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * <p>For custom testing purposes you're given the binary matrix mat as input in the following four
 * examples. You will not have access the binary matrix directly.
 *
 * <pre>
 * Example 1:
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 *
 * Example 2:
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 *
 * Example 3:
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 *
 * Example 4:
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/leftmost-column-with-at-least-a-one/">Leftmost
 *     Column with at Least a One</a>
 */
public final class LeftMostColumn {

  /** Representation of the Binary matrix. */
  interface BinaryMatrix {
    /**
     * @param row The row index.
     * @param col The col index.
     * @return The value present on the matrix for the provided row and column.
     */
    public int get(int row, int col);

    /** @return A list of 2 element with row and column */
    public List<Integer> dimensions();
  }

  /**
   * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at
   * least a 1 in it. If such index doesn't exist, return -1.
   *
   * @param binaryMatrix The {@link BinaryMatrix}.
   * @return The leftmost column index with at least a 1 in it.
   */
  public int leftMostColumnWithOne(final BinaryMatrix binaryMatrix) {
    final List<Integer> dimensions = binaryMatrix.dimensions();

    final int rowCount = dimensions.get(0);
    int minIndex = Integer.MAX_VALUE;

    for (int i = 0; i < rowCount; ++i) {
      final int searchIndex = binarySearch(i, binaryMatrix);

      if (searchIndex != -1) {
        minIndex = Math.min(minIndex, searchIndex);
      }
    }

    // If min index is still MAX_VALUE then the matrix has all zeros. In such scenario return -1.
    return minIndex != Integer.MAX_VALUE ? minIndex : -1;
  }

  /**
   * Performs a binary search on the matrix for the provided rowIndex. The search will return the
   * index with the very first occurrence of 1 on the row.
   *
   * @param rowIndex The row index.
   * @param binaryMatrix The {@linkl BinaryMatrix}.
   * @return The index with very first occurrence of 1. If none exists then return -1;
   */
  private int binarySearch(final int rowIndex, final BinaryMatrix binaryMatrix) {
    final List<Integer> dimensions = binaryMatrix.dimensions();

    final int colCount = dimensions.get(1);
    int startIndex = 0;
    int endIndex = colCount - 1;

    while (startIndex <= endIndex) {
      final int midIndex = Math.floorDiv((startIndex + endIndex), 2);

      final int midValue = binaryMatrix.get(rowIndex, midIndex);

      // Edge case where midValue is either of the two bounds.
      if (midIndex == startIndex || midIndex == endIndex) {
        if (midValue == 1) {
          return midIndex;
        }
      } else if (midValue == 1) {
        // If mid value is 1 and left value is 0, then this is the first occurrence of 1 on the row
        // matrix
        if (binaryMatrix.get(rowIndex, midIndex - 1) == 0) {
          return midIndex;
        }
      }

      if (midValue == 1) {
        // If mid value is 1 then there exists 1 on the left to search for
        endIndex = midIndex - 1;
      } else {
        startIndex = midIndex + 1;
      }
    }
    return -1;
  }
}
