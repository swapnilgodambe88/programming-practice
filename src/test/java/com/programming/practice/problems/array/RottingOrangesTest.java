package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RottingOranges}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RottingOrangesTest {

  private final RottingOranges obj = new RottingOranges();

  @Test
  public void testScenario1() {
    final int[][] grid = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};

    Assert.assertEquals(4, obj.orangesRotting(grid));
  }

  @Test
  public void testScenario2() {
    final int[][] grid = new int[][] {{0, 2}};

    Assert.assertEquals(0, obj.orangesRotting(grid));
  }

  @Test
  public void testScenario3() {
    final int[][] grid = new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};

    Assert.assertEquals(-1, obj.orangesRotting(grid));
  }

  @Test
  public void testScenario4() {
    final int[][] grid = new int[][] {{0}};

    Assert.assertEquals(0, obj.orangesRotting(grid));
  }

  @Test
  public void testScenario5() {
    final int[][] grid = new int[][] {{2, 2, 2, 1, 1}};

    Assert.assertEquals(2, obj.orangesRotting(grid));
  }
}
