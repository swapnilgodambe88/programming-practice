package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RotateImage}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RotateImageTest {

  private final RotateImage obj = new RotateImage();

  @Test
  public void testEmptyMatrix() {
    final int[][] matrix = new int[][] {};

    obj.rotate(matrix);

    Assert.assertArrayEquals(matrix, matrix);
  }

  @Test
  public void testScenario1() {
    final int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    final int[][] expectedRotatedMatrix = new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};

    obj.rotate(matrix);

    Assert.assertArrayEquals(matrix, expectedRotatedMatrix);
  }

  @Test
  public void testScenario2() {
    final int[][] matrix =
        new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

    final int[][] expectedRotatedMatrix =
        new int[][] {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};

    obj.rotate(matrix);

    Assert.assertArrayEquals(matrix, expectedRotatedMatrix);
  }
}
