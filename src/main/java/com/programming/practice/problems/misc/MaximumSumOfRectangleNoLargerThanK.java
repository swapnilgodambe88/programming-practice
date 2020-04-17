package com.programming.practice.problems.misc;

/**
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the
 * matrix such that its sum is no larger than k.
 *
 * <pre>
 * Example:
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 * and 2 is the max number no larger than k (k = 2).
 * </pre>
 *
 * @see <a href =
 *     "https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/submissions/">Max Sum of
 *     Rectangle No Larger Than K</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumSumOfRectangleNoLargerThanK {

  private int[][] matrix;
  private int rowCount;
  private int colCount;

  /**
   * Finds the max sum of a rectangle in the matrix such that it's sum is no larger than k.
   *
   * @param matrix The 2D matrix.
   * @param k The k value.
   * @return The max sum of a rectangle in the matrix such that it's sum is no larger than k.
   */
  public int maxSumSubmatrix(final int[][] matrix, final int k) {
    this.matrix = matrix;
    this.rowCount = matrix.length;
    this.colCount = rowCount > 0 ? matrix[0].length : 0;
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < rowCount; ++i) {

      final int[] rowElements = new int[colCount];
      for (int j = i; j < rowCount; ++j) {
        add(rowElements, j);

        final int maxSubArraySum = maxValueInArrayLessThanEqualToK(rowElements, k);

        if (maxSum < maxSubArraySum) {
          maxSum = maxSubArraySum;
        }
      }
    }

    return maxSum;
  }

  /**
   * Add respective row elements to the array.
   *
   * @param rowElement The row array.
   * @param rowIndex The row index.
   */
  private void add(final int[] rowElement, final int rowIndex) {

    for (int i = 0; i < colCount; ++i) {
      rowElement[i] += matrix[rowIndex][i];
    }
  }

  /**
   * Finds the maximum value in array less than equal to k.
   *
   * @param nums The nums array.
   * @param k The k number.
   * @return The maximum value in array less than equal to k.
   */
  private int maxValueInArrayLessThanEqualToK(final int[] nums, final int k) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; ++i) {
      int iSum = 0;
      for (int j = i; j < nums.length; ++j) {
        iSum += nums[j];

        if (iSum <= k && maxSum < iSum) {
          maxSum = iSum;
        }
      }
    }

    return maxSum;
  }
}
