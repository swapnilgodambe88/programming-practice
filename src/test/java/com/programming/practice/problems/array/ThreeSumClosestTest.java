package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ThreeSumClosest}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ThreeSumClosestTest {

  private final ThreeSumClosest obj = new ThreeSumClosest();

  @Test
  public void testRandom1() {
    final int[] inputArray = new int[] {-1, 2, 1, -4};
    Assert.assertEquals(2, obj.threeSumClosest(inputArray, 1));
  }

  @Test
  public void testRandom2() {
    final int[] inputArray = new int[] {1, 2, 4, 8, 16, 32, 64, 128};
    Assert.assertEquals(82, obj.threeSumClosest(inputArray, 82));
  }
}
