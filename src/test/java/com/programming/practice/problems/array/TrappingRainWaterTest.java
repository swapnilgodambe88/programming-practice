package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TrappingRainWater}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TrappingRainWaterTest {

  private final TrappingRainWater obj = new TrappingRainWater();

  @Test
  public void testScenario1() {
    final int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    Assert.assertEquals(6, obj.trap(height));
  }
}
