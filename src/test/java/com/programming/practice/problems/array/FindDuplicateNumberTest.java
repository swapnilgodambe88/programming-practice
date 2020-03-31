package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FindDuplicateNumber}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FindDuplicateNumberTest {

  private final FindDuplicateNumber obj = new FindDuplicateNumber();

  @Test
  public void testScenario1() {
    final int[] nums1 = new int[] {1, 3, 4, 2, 2};
    Assert.assertEquals(2, obj.findDuplicate(nums1));

    final int[] nums2 = new int[] {1, 3, 4, 2, 2};
    Assert.assertEquals(2, obj.findDuplicateUsingSet(nums2));

    final int[] nums3 = new int[] {1, 3, 4, 2, 2};
    Assert.assertEquals(2, obj.findDuplicateUsing2Pointer(nums3));
  }

  @Test
  public void testScenario2() {
    final int[] nums1 = new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
    Assert.assertEquals(9, obj.findDuplicate(nums1));

    final int[] nums2 = new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
    Assert.assertEquals(9, obj.findDuplicateUsingSet(nums2));

    final int[] nums3 = new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
    Assert.assertEquals(9, obj.findDuplicateUsing2Pointer(nums3));
  }

  @Test
  public void testSingleElementDuplicate() {
    final int[] nums1 = new int[] {1, 1};
    Assert.assertEquals(1, obj.findDuplicate(nums1));

    final int[] nums2 = new int[] {1, 1};
    Assert.assertEquals(1, obj.findDuplicateUsingSet(nums2));

    final int[] nums3 = new int[] {1, 1};
    Assert.assertEquals(1, obj.findDuplicateUsing2Pointer(nums3));
  }

  @Test
  public void testElementRepeatedMoreThanOnce() {
    final int[] nums1 = new int[] {2, 2, 2, 2};
    Assert.assertEquals(2, obj.findDuplicate(nums1));

    final int[] nums2 = new int[] {2, 2, 2, 2};
    Assert.assertEquals(2, obj.findDuplicateUsingSet(nums2));

    final int[] nums3 = new int[] {2, 2, 2, 2};
    Assert.assertEquals(2, obj.findDuplicateUsing2Pointer(nums3));
  }
}
