package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SurroundedRegions}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SurroundedRegionsTest {

  private final SurroundedRegions obj = new SurroundedRegions();

  @Test
  public void testScenario1() {
    final char[][] board =
        new char[][] {
          {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
    final char[][] expectedCapturedBoard =
        new char[][] {
          {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}
        };

    obj.solve(board);

    Assert.assertArrayEquals(expectedCapturedBoard, board);
  }
}
