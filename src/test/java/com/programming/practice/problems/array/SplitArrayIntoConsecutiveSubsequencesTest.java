package com.programming.practice.problems.array;

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
    obj.isPossible(nums);
    // Assert.assertTrue(obj.isPossible(nums));
  }
}
