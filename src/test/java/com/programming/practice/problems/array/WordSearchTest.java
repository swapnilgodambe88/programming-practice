package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link WordSearch}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class WordSearchTest {

  private final WordSearch obj = new WordSearch();

  @Test
  public void testScenario1() {
    final char[][] board =
        new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

    Assert.assertTrue(obj.exist(board, "ABCCED"));
    Assert.assertTrue(obj.exist(board, "SEE"));
    Assert.assertFalse(obj.exist(board, "ABCB"));
  }

  @Test
  public void testScenario2() {
    final char[][] board =
        new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};

    Assert.assertTrue(obj.exist(board, "ABCESEEEFS"));
  }
}
