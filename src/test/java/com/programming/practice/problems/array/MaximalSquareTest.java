package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximalSquare}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximalSquareTest {

  private final MaximalSquare obj = new MaximalSquare();

  @Test
  public void testScenario1() {
    final char[][] matrix =
        new char[][] {
          {'1', '0', '1', '0', '0'},
          {'1', '0', '1', '1', '1'},
          {'1', '1', '1', '1', '1'},
          {'1', '0', '0', '1', '0'}
        };

    Assert.assertEquals(4, obj.maximalSquare(matrix));
  }

  @Test
  public void testScenario2() {
    final char[][] matrix = new char[][] {{'1'}};

    Assert.assertEquals(1, obj.maximalSquare(matrix));
  }
}
