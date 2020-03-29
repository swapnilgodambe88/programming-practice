package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RotateArrayTest}
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class RotateArrayTest {

  private final RotateArray obj = new RotateArray();

  @Test
  public void testSingleElementKGreaterThanNumsLength() {
    final int[] nums1 = new int[] {-1};
    final int[] nums2 = new int[] {-1};
    final int k = 2;
    final int[] expectedRotatedArray = new int[] {-1};

    obj.rotate(nums1, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums1);

    obj.rotateUsingQueue(nums2, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums2);
  }

  @Test
  public void testKGreaterThanNumsLength() {
    final int[] nums1 = new int[] {1, 2, 3, 4, 5, 6, 7};
    final int[] nums2 = new int[] {1, 2, 3, 4, 5, 6, 7};
    final int k = 10;
    final int[] expectedRotatedArray = new int[] {5, 6, 7, 1, 2, 3, 4};

    obj.rotate(nums1, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums1);

    obj.rotateUsingQueue(nums2, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums2);
  }

  @Test
  public void testScenario1() {
    final int[] nums1 = new int[] {1, 2, 3, 4, 5, 6, 7};
    final int[] nums2 = new int[] {1, 2, 3, 4, 5, 6, 7};
    final int k = 3;
    final int[] expectedRotatedArray = new int[] {5, 6, 7, 1, 2, 3, 4};

    obj.rotate(nums1, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums1);

    obj.rotateUsingQueue(nums2, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums2);
  }

  @Test
  public void testScenario2() {
    final int[] nums1 = new int[] {-1, -100, 3, 99};
    final int[] nums2 = new int[] {-1, -100, 3, 99};
    final int k = 2;
    final int[] expectedRotatedArray = new int[] {3, 99, -1, -100};

    obj.rotate(nums1, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums1);

    obj.rotateUsingQueue(nums2, k);
    Assert.assertArrayEquals(expectedRotatedArray, nums2);
  }
}
