package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SubarraySumEqualsK}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SubarraySumEqualsKTest {

  private final SubarraySumEqualsK obj = new SubarraySumEqualsK();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 1, 1};

    Assert.assertEquals(2, obj.subarraySum(nums, 2));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {1, 2, 3};

    Assert.assertEquals(2, obj.subarraySum(nums, 3));
  }

  @Test
  public void testScenario3() {
    final int[] nums = new int[] {1, 2, 1, 2, 1};

    Assert.assertEquals(4, obj.subarraySum(nums, 3));
  }

  @Test
  public void testScenario4() {
    final int[] nums = new int[] {1};

    Assert.assertEquals(0, obj.subarraySum(nums, 0));
  }
}
