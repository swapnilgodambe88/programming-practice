/** */
package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximumSubarray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumSubarrayTest {

  private final MaximumSubarray obj = new MaximumSubarray();

  @Test
  public void testSingleNegativeNumber() {
    final int[] nums = new int[] {-1};

    Assert.assertEquals(-1, obj.maxSubArray(nums));
  }

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    Assert.assertEquals(6, obj.maxSubArray(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4};

    Assert.assertEquals(6, obj.maxSubArray(nums));
  }
}
