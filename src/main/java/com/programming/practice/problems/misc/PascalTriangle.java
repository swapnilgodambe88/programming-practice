package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * <p>In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * <pre>
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/pascals-triangle/">Pascal's Triangle</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class PascalTriangle {

  /**
   * Given an integer numRows, return the first numRows of Pascal's triangle.
   *
   * @param numRows The number of rows to return from Pascal's triangle.
   * @return The first numRows of Pascal's triangle.
   */
  public List<List<Integer>> generate(final int numRows) {
    List<List<Integer>> output = new ArrayList<>();

    if (numRows == 0) {
      return output;
    }

    output.add(List.of(1));
    while (output.size() < numRows) {
      List<Integer> currentRow = new ArrayList<>();
      List<Integer> previousRow = output.get(output.size() - 1);
      final int previousRowSize = previousRow.size();

      // Add first element as is
      currentRow.add(previousRow.get(0));
      for (int i = 1; i < previousRowSize; ++i) {
        currentRow.add(previousRow.get(i) + previousRow.get(i - 1));
      }
      // Add last element as is
      currentRow.add(previousRow.get(previousRowSize - 1));

      output.add(currentRow);
    }

    return output;
  }
}
