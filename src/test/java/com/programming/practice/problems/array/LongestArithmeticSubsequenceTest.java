package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestArithmeticSubsequence}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 */
public class LongestArithmeticSubsequenceTest {
  private final LongestArithmeticSubsequence obj = new LongestArithmeticSubsequence();

  @Test
  public void testScenario1() {
    final int[] A = new int[] {3, 6, 9, 12};

    Assert.assertEquals(4, obj.longestArithSeqLength(A));
  }

  @Test
  public void testScenario2() {
    final int[] A = new int[] {9, 4, 7, 2, 10};

    Assert.assertEquals(3, obj.longestArithSeqLength(A));
  }

  @Test
  public void testScenario3() {
    final int[] A = new int[] {20, 1, 15, 3, 10, 5, 8};

    Assert.assertEquals(4, obj.longestArithSeqLength(A));
  }

  @Test
  public void testScenario4() {
    final int[] A = new int[] {83, 20, 17, 43, 52, 78, 68, 45};

    Assert.assertEquals(2, obj.longestArithSeqLength(A));
  }
}
