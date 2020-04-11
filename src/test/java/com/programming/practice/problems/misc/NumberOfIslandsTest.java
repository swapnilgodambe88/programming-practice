package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link NumberOfIslands}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class NumberOfIslandsTest {

  private final NumberOfIslands obj = new NumberOfIslands();

  @Test
  public void testScenario1() {
    final char[][] grid =
        new char[][] {
          {'1', '1', '1', '1', '0'},
          {'1', '1', '0', '1', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '0', '0', '0'}
        };

    Assert.assertEquals(1, obj.numIslands(grid));
  }

  @Test
  public void testAllIsland() {
    final char[][] grid =
        new char[][] {{'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}, {'1', '1', '1'}};

    Assert.assertEquals(1, obj.numIslands(grid));
  }

  @Test
  public void testAllWater() {
    final char[][] grid =
        new char[][] {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};

    Assert.assertEquals(0, obj.numIslands(grid));
  }

  @Test
  public void testEmptyGrid() {
    final char[][] grid = new char[][] {};

    Assert.assertEquals(0, obj.numIslands(grid));
  }

  @Test
  public void testSingleIslandElement() {
    final char[][] grid = new char[][] {{'1'}};

    Assert.assertEquals(1, obj.numIslands(grid));
  }

  @Test
  public void testSingleWaterElement() {
    final char[][] grid = new char[][] {{'0'}};

    Assert.assertEquals(0, obj.numIslands(grid));
  }
}
