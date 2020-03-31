package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SpiralMatrix}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SpiralMatrixTest {

  private final SpiralMatrix obj = new SpiralMatrix();

  @Test
  public void testSquareMatrix() {
    final int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    final List<Integer> expectedSpiralMatrix =
        new LinkedList<>(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }

  @Test
  public void testRectangleMatrix1() {
    final int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

    final List<Integer> expectedSpiralMatrix =
        new LinkedList<>(Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }

  @Test
  public void testRectangleMatrix2() {
    final int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}};

    final List<Integer> expectedSpiralMatrix =
        new LinkedList<>(Arrays.asList(1, 2, 3, 4, 8, 7, 6, 5));

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }

  @Test
  public void testSingleRow() {
    final int[][] matrix = new int[][] {{1, 2, 3, 4}};

    final List<Integer> expectedSpiralMatrix = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }

  @Test
  public void testSingleColumn() {
    final int[][] matrix = new int[][] {{1}, {2}, {3}, {4}};

    final List<Integer> expectedSpiralMatrix = new LinkedList<>(Arrays.asList(1, 2, 3, 4));

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }

  @Test
  public void testSingleElement() {
    final int[][] matrix = new int[][] {{1}};

    final List<Integer> expectedSpiralMatrix = new LinkedList<>(Arrays.asList(1));

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }

  @Test
  public void testEmptyMatrix() {
    final int[][] matrix = new int[][] {};

    final List<Integer> expectedSpiralMatrix = new LinkedList<>();

    Assert.assertEquals(expectedSpiralMatrix, obj.spiralOrder(matrix));
  }
}
