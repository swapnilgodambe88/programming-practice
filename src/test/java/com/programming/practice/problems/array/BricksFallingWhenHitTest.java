package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BricksFallingWhenHit}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BricksFallingWhenHitTest {

  private final BricksFallingWhenHit obj = new BricksFallingWhenHit();

  @Test
  public void testScenario1() {
    final int[][] grid = new int[][] {{1, 0, 0, 0}, {1, 1, 1, 0}};
    final int[][] hits = new int[][] {{1, 0}};

    final int[] expectedHitBricks = new int[] {2};
    Assert.assertArrayEquals(expectedHitBricks, obj.hitBricks(grid, hits));
  }

  @Test
  public void testScenario2() {
    final int[][] grid = new int[][] {{1, 0, 0, 0}, {1, 1, 0, 0}};
    final int[][] hits = new int[][] {{1, 1}, {1, 0}};

    final int[] expectedHitBricks = new int[] {0, 0};
    Assert.assertArrayEquals(expectedHitBricks, obj.hitBricks(grid, hits));
  }

  @Test
  public void testScenario3() {
    final int[][] grid = new int[][] {{1}, {1}, {1}, {1}, {1}};
    final int[][] hits = new int[][] {{3, 0}, {4, 0}, {1, 0}, {2, 0}, {0, 0}};

    final int[] expectedHitBricks = new int[] {1, 0, 1, 0, 0};
    Assert.assertArrayEquals(expectedHitBricks, obj.hitBricks(grid, hits));
  }

  @Test
  public void testScenario4() {
    final int[][] grid = new int[][] {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
    final int[][] hits = new int[][] {{0, 2}, {2, 0}, {0, 1}, {1, 2}};

    final int[] expectedHitBricks = new int[] {0, 0, 1, 0};
    Assert.assertArrayEquals(expectedHitBricks, obj.hitBricks(grid, hits));
  }
}
