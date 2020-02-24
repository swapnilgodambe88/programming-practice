package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ContainerWithMostWater}.
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ContainerWithMostWaterTest {

  private final ContainerWithMostWater obj = new ContainerWithMostWater();

  @Test
  public void testTwoHeights() {
    Assert.assertEquals(8, obj.maxArea(new int[] {9, 8}));
  }

  @Test
  public void testRandom1() {
    Assert.assertEquals(49, obj.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  @Test
  public void testAllZeroHeight() {
    Assert.assertEquals(0, obj.maxArea(new int[] {0, 0, 0, 0}));
  }
}
