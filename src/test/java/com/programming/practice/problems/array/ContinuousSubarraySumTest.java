package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ContinuousSubarraySum}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ContinuousSubarraySumTest {

  private final ContinuousSubarraySum obj = new ContinuousSubarraySum();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {23, 2, 4, 6, 7};
    final int k = 6;

    Assert.assertTrue(obj.checkSubarraySum(nums, k));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {23, 2, 6, 4, 7};
    final int k = 6;

    Assert.assertTrue(obj.checkSubarraySum(nums, k));
  }
}
