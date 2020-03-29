package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link KLargestElementInStream}.
 *
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class KthLargestElementInStreamTest {

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {4, 5, 8, 2};
    final KthLargestElementInStream obj = new KthLargestElementInStream(3, nums);

    Assert.assertEquals(4, obj.add(3));
    Assert.assertEquals(5, obj.add(5));
    Assert.assertEquals(5, obj.add(10));
    Assert.assertEquals(8, obj.add(9));
    Assert.assertEquals(8, obj.add(4));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {};
    final KthLargestElementInStream obj = new KthLargestElementInStream(3, nums);

    Assert.assertEquals(-3, obj.add(-3));
    Assert.assertEquals(-2, obj.add(-2));
    Assert.assertEquals(0, obj.add(0));
    Assert.assertEquals(4, obj.add(4));
  }
}
