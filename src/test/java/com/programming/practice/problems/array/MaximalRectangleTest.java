package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximalRectangle}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximalRectangleTest {

  private final MaximalRectangle obj = new MaximalRectangle();

  @Test
  public void testScenario1() {
    final char[][] matrix =
        new char[][] {
          {'1', '0', '1', '0', '0'},
          {'1', '0', '1', '1', '1'},
          {'1', '1', '1', '1', '1'},
          {'1', '0', '0', '1', '0'}
        };

    Assert.assertEquals(6, obj.maximalRectangle(matrix));
  }

  @Test
  public void testScenario2() {
    final char[][] matrix = new char[][] {};

    Assert.assertEquals(0, obj.maximalRectangle(matrix));
  }

  @Test
  public void testScenario3() {
    final char[][] matrix = new char[][] {{'1'}};

    Assert.assertEquals(1, obj.maximalRectangle(matrix));
  }

  @Test
  public void testScenario4() {
    final char[][] matrix = new char[][] {{'0'}};

    Assert.assertEquals(0, obj.maximalRectangle(matrix));
  }
}
