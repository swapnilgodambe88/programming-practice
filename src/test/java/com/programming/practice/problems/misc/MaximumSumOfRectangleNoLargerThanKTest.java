package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximumSumOfRectangleNoLargerThanK}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumSumOfRectangleNoLargerThanKTest {

  private final MaximumSumOfRectangleNoLargerThanK obj = new MaximumSumOfRectangleNoLargerThanK();

  @Test
  public void testScenario1() {
    final int[][] matrix = new int[][] {{1, 0, 1}, {0, -2, 3}};
    final int k = 2;

    Assert.assertEquals(2, obj.maxSumSubmatrix(matrix, k));
  }

  @Test
  public void testScenario2() {
    final int[][] matrix = new int[][] {{2, 2, -1}};
    final int k = 3;

    Assert.assertEquals(3, obj.maxSumSubmatrix(matrix, k));
  }

  @Test
  public void testScenario3() {
    final int[][] matrix = new int[][] {{2, 2, -1}};
    final int k = 2;

    Assert.assertEquals(2, obj.maxSumSubmatrix(matrix, k));
  }

  @Test
  public void testScenario4() {
    final int[][] matrix = new int[][] {{2, 2, -1}};
    final int k = 0;

    Assert.assertEquals(-1, obj.maxSumSubmatrix(matrix, k));
  }
}
