package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * <p>In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * <pre>
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/pascals-triangle-ii/description/">Pascal's Triangle
 *     2</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class PascalTriangle2 {

  /**
   * @param rowIndex The integer rowIndex (0-indexed).
   * @return THe rowIndexth row of the Pascal's traingle.
   */
  public List<Integer> getRow(int rowIndex) {
    List<Integer> currentRow = new ArrayList<>();
    currentRow.add(1);

    int currentIndex = 0;
    while (rowIndex > currentIndex++) {
      final int currentRowSize = currentRow.size();

      final List<Integer> processingRow = new ArrayList<>();

      // Add first element of previous row as is
      processingRow.add(currentRow.get(0));
      for (int i = 1; i < currentRowSize; ++i) {
        // Middle rows will be addition of current element + previous element of last row
        processingRow.add(currentRow.get(i) + currentRow.get(i - 1));
      }

      // Add last element of previous row as is
      processingRow.add(currentRow.get(currentRowSize - 1));
      currentRow = processingRow;
    }

    return currentRow;
  }
}
