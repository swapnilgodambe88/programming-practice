package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MergeSortedArray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MergeSortedArrayTest {

  private final MergeSortedArray obj = new MergeSortedArray();

  @Test
  public void testBothArrayEmpty() {
    final int[] nums1 = new int[] {};
    final int[] nums2 = new int[] {};

    final int[] expectedMerge = new int[] {};

    obj.merge(nums1, 0, nums2, 0);

    Assert.assertArrayEquals(expectedMerge, nums1);
  }

  @Test
  public void testNums2Empty() {
    final int[] nums1 = new int[] {1, 2, 3, 4, 5};
    final int[] nums2 = new int[] {};

    final int[] expectedMerge = new int[] {1, 2, 3, 4, 5};

    obj.merge(nums1, 5, nums2, 0);

    Assert.assertArrayEquals(expectedMerge, nums1);
  }

  @Test
  public void testScenario1() {
    final int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
    final int[] nums2 = new int[] {2, 5, 6};

    final int[] expectedMerge = new int[] {1, 2, 2, 3, 5, 6};

    obj.merge(nums1, 3, nums2, 3);

    Assert.assertArrayEquals(expectedMerge, nums1);
  }

  @Test
  public void testScenario2() {
    final int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
    final int[] nums2 = new int[] {4, 5, 6};

    final int[] expectedMerge = new int[] {1, 2, 3, 4, 5, 6};

    obj.merge(nums1, 3, nums2, 3);

    Assert.assertArrayEquals(expectedMerge, nums1);
  }

  @Test
  public void testScenario3() {
    final int[] nums1 = new int[] {4, 5, 6, 0, 0, 0};
    final int[] nums2 = new int[] {1, 2, 3};

    final int[] expectedMerge = new int[] {1, 2, 3, 4, 5, 6};

    obj.merge(nums1, 3, nums2, 3);

    Assert.assertArrayEquals(expectedMerge, nums1);
  }
}
