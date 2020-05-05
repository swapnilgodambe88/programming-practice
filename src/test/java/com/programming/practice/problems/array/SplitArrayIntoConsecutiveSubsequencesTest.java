package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SplitArrayIntoConsecutiveSubsequences}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SplitArrayIntoConsecutiveSubsequencesTest {

  private final SplitArrayIntoConsecutiveSubsequences obj =
      new SplitArrayIntoConsecutiveSubsequences();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 2, 3, 4, 4, 5};

    Assert.assertFalse(obj.isPossible(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {1, 2, 3, 3, 4, 5};

    Assert.assertTrue(obj.isPossible(nums));
  }

  @Test
  public void testScenario3() {
    final int[] nums = new int[] {1, 2, 3, 3, 4, 4, 5, 5};

    Assert.assertTrue(obj.isPossible(nums));
  }
}
