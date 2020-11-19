package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link IntersectionOfTwoArrays}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class IntersectionOfTwoArraysTest {

  private final IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();

  @Test
  public void testScenario1() {
    final int[] nums1 = new int[] {1, 2, 2, 1};
    final int[] nums2 = new int[] {2, 2};

    final int[] expectedIntersection = new int[] {2};
    Assert.assertArrayEquals(expectedIntersection, obj.intersection(nums1, nums2));
  }

  @Test
  public void testScenario2() {
    final int[] nums1 = new int[] {4, 9, 5};
    final int[] nums2 = new int[] {9, 4, 9, 8, 4};

    final int[] expectedIntersection = new int[] {4, 9};
    Assert.assertArrayEquals(expectedIntersection, obj.intersection(nums1, nums2));
  }
}
