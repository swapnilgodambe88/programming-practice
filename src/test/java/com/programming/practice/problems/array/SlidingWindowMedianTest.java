package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SlidingWindowMedian}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class SlidingWindowMedianTest {
  private final SlidingWindowMedian obj = new SlidingWindowMedian();
  private static final double DELTA = 0.00001;

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
    final int k = 3;

    final double[] expectedMedianWindow = new double[] {1.0, -1.0, -1.0, 3.0, 5.0, 6.0};
    Assert.assertArrayEquals(expectedMedianWindow, obj.medianSlidingWindow(nums, k), DELTA);
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {1, 4, 2, 3};
    final int k = 4;

    final double[] expectedMedianWindow = new double[] {2.5};
    Assert.assertArrayEquals(expectedMedianWindow, obj.medianSlidingWindow(nums, k), DELTA);
  }

  @Test
  public void testScenario3() {
    final int[] nums = new int[] {2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647};
    final int k = 2;

    final double[] expectedMedianWindow =
        new double[] {
          1073741824.00000, 1.50000, 2.50000, 3.50000, 4.50000, 5.50000, 6.50000, 1073741827.00000
        };
    Assert.assertArrayEquals(expectedMedianWindow, obj.medianSlidingWindow(nums, k), DELTA);
  }

  @Test
  public void testScenario4() {
    final int[] nums = new int[] {5, 2, 2, 7, 3, 7, 9, 0, 2, 3};
    final int k = 9;

    final double[] expectedMedianWindow = new double[] {3.0, 3.0};
    Assert.assertArrayEquals(expectedMedianWindow, obj.medianSlidingWindow(nums, k), DELTA);
  }

  @Test
  public void testScenario5() {
    final int[] nums =
        new int[] {
          -2147483648,
          -2147483648,
          2147483647,
          -2147483648,
          1,
          3,
          -2147483648,
          -100,
          8,
          17,
          22,
          -2147483648,
          -2147483648,
          2147483647,
          2147483647,
          2147483647,
          2147483647,
          -2147483648,
          2147483647,
          -2147483648
        };
    final int k = 6;

    final double[] expectedMedianWindow =
        new double[] {
          -1073741823.50000,
          -1073741823.50000,
          -49.50000,
          -49.50000,
          2.00000,
          5.50000,
          -46.00000,
          -46.00000,
          12.50000,
          19.50000,
          1073741834.50000,
          2147483647.00000,
          2147483647.00000,
          2147483647.00000,
          2147483647.00000
        };
    Assert.assertArrayEquals(expectedMedianWindow, obj.medianSlidingWindow(nums, k), DELTA);
  }
}
