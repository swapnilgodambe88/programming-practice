/** */
package com.programming.practice.problems.misc;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * <p>Rotate the image by 90 degrees (clockwise).
 *
 * <p>Note:
 *
 * <p>You have to rotate the image in-place, which means you have to modify the input 2D matrix
 * directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * <p>Example 1:
 *
 * <p>Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 *
 * <p>rotate the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2], [9,6,3] ] Example
 * 2:
 *
 * <p>Given input matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7], [15,14,12,16] ],
 *
 * <p>rotate the input matrix in-place such that it becomes: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6,
 * 8, 9], [16, 7,10,11] ]
 *
 * @see <a href = "https://leetcode.com/problems/rotate-image/">Rotate Image</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RotateImage {

  /**
   * Rotates the matrix in place.
   *
   * @param matrix The matrix to rotate.
   */
  public void rotate(final int[][] matrix) {
    transposeMatrix(matrix);
    reverseElementInEveryRow(matrix);
  }

  /**
   * Performs a transpose on the matrix.
   *
   * @param matrix The matrix to transpose.
   */
  private void transposeMatrix(final int[][] matrix) {
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = i + 1; j < matrix.length; ++j) {
        final int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }

  /**
   * Reverse the elements on every row of the matrix.
   *
   * @param matrix The matrix whos rows needs to be reversed.
   */
  private void reverseElementInEveryRow(final int[][] matrix) {
    for (int row = 0; row < matrix.length; ++row) {
      for (int i = 0, j = matrix.length - 1; i < j; ++i, --j) {
        final int temp = matrix[row][i];
        matrix[row][i] = matrix[row][j];
        matrix[row][j] = temp;
      }
    }
  }
}
