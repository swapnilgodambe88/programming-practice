package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SearchInRotatedSortedArray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SearchInRotatedSortedArrayTest {

  private final SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

  @Test
  public void testRotatedElementPresent1() {
    final int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};

    Assert.assertEquals(4, obj.search(nums, 0));
  }

  @Test
  public void testRotatedElementPresent2() {
    final int[] nums = new int[] {3, 1};

    Assert.assertEquals(1, obj.search(nums, 1));
  }

  @Test
  public void testRotatedElementPresent3() {
    final int[] nums = new int[] {9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8};

    Assert.assertEquals(9, obj.search(nums, 7));
  }

  @Test
  public void testRotatedElementPresent4() {
    final int[] nums = new int[] {9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8};

    Assert.assertEquals(1, obj.search(nums, 10));
  }

  @Test
  public void testSingleElementTargetNotPresent1() {
    final int[] nums = new int[] {1};

    Assert.assertEquals(-1, obj.search(nums, 0));
  }
}
