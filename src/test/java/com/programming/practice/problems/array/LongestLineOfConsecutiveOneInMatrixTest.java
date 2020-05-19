package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestLineOfConsecutiveOneInMatrix}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LongestLineOfConsecutiveOneInMatrixTest {

  private final LongestLineOfConsecutiveOneInMatrix obj = new LongestLineOfConsecutiveOneInMatrix();

  @Test
  public void testScenario1() {
    final int[][] M = new int[][] {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};

    Assert.assertEquals(3, obj.longestLine(M));
  }

  @Test
  public void testScenario2() {
    final int[][] M =
        new int[][] {
          {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
          {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
          {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
          {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
          {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
          {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
          {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
          {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
          {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
          {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        };

    Assert.assertEquals(9, obj.longestLine(M));
  }
}
