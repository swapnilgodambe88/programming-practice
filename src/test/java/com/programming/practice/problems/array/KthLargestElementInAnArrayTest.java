package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link KthLargestElementInAnArray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class KthLargestElementInAnArrayTest {

  private final KthLargestElementInAnArray obj = new KthLargestElementInAnArray();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {3, 2, 1, 5, 6, 4};

    Assert.assertEquals(5, obj.findKthLargest(nums, 2));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};

    Assert.assertEquals(4, obj.findKthLargest(nums, 4));
  }
}
