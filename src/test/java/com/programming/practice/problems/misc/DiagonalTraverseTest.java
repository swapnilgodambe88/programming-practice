package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DiagonalTraverse}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DiagonalTraverseTest {

  private final DiagonalTraverse obj = new DiagonalTraverse();

  @Test
  public void testEmptyMatrix() {
    final int[][] matrix = new int[][] {};

    final int[] expectedDiagonalTraverse = new int[] {};
    Assert.assertArrayEquals(expectedDiagonalTraverse, obj.findDiagonalOrder(matrix));
  }

  @Test
  public void testScenario1() {
    final int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    final int[] expectedDiagonalTraverse = new int[] {1, 2, 4, 7, 5, 3, 6, 8, 9};
    Assert.assertArrayEquals(expectedDiagonalTraverse, obj.findDiagonalOrder(matrix));
  }

  @Test
  public void testSingleRowMatrix() {
    final int[][] matrix = new int[][] {{1, 2, 3, 4, 5}};

    final int[] expectedDiagonalTraverse = new int[] {1, 2, 3, 4, 5};
    Assert.assertArrayEquals(expectedDiagonalTraverse, obj.findDiagonalOrder(matrix));
  }

  @Test
  public void testSingleColumnMatrix() {
    final int[][] matrix = new int[][] {{1}, {2}, {3}, {4}, {5}};

    final int[] expectedDiagonalTraverse = new int[] {1, 2, 3, 4, 5};
    Assert.assertArrayEquals(expectedDiagonalTraverse, obj.findDiagonalOrder(matrix));
  }
}
