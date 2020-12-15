package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumKnightMoves}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumKnightMovesTest {

  private final MinimumKnightMoves obj = new MinimumKnightMoves();

  @Test
  public void testScenario1() {
    Assert.assertEquals(0, obj.minKnightMoves(0, 0));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(1, obj.minKnightMoves(2, 1));
  }

  @Test
  public void testScenario3() {
    Assert.assertEquals(4, obj.minKnightMoves(5, 5));
  }

  @Test
  public void testScenario4() {
    Assert.assertEquals(2, obj.minKnightMoves(1, 1));
  }
}
