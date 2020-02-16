package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ContainerWithMostWater}.
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class ContainerWithMostWaterTest {

  @Test
  public void testTwoHeights() {
    final ContainerWithMostWater obj = new ContainerWithMostWater();

    Assert.assertEquals(8, obj.maxArea(new int[] {9, 8}));
  }

  @Test
  public void testRandom1() {
    final ContainerWithMostWater obj = new ContainerWithMostWater();

    Assert.assertEquals(49, obj.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  @Test
  public void testAllZeroHeight() {
    final ContainerWithMostWater obj = new ContainerWithMostWater();

    Assert.assertEquals(0, obj.maxArea(new int[] {0, 0, 0, 0}));
  }
}
