package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SingleNumber}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SingleNumberTest {

  private final SingleNumber obj = new SingleNumber();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {2, 2, 1};

    Assert.assertEquals(1, obj.singleNumberUsingBitManuplation(nums));
    Assert.assertEquals(1, obj.singleNumberUsingSet(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {4, 1, 2, 1, 2};

    Assert.assertEquals(4, obj.singleNumberUsingBitManuplation(nums));
    Assert.assertEquals(4, obj.singleNumberUsingSet(nums));
  }
}
