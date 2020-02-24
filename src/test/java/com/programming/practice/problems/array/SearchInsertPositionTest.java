package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SearchInsertPosition}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SearchInsertPositionTest {

  private final SearchInsertPosition obj = new SearchInsertPosition();

  @Test
  public void testTargetNotFoundInsertInBetween1() {
    final int[] nums = new int[] {1, 3, 5, 6};

    Assert.assertEquals(2, obj.searchInsert(nums, 5));
  }

  @Test
  public void testTargetNotFoundInsertInBetween2() {
    final int[] nums = new int[] {1, 3, 5, 6};

    Assert.assertEquals(1, obj.searchInsert(nums, 2));
  }

  @Test
  public void testTargetNotFoundInsertAtEnd() {
    final int[] nums = new int[] {1, 3, 5, 6};

    Assert.assertEquals(4, obj.searchInsert(nums, 7));
  }

  @Test
  public void testTargetNotFoundInsertAtStart() {
    final int[] nums = new int[] {1, 3, 5, 6};

    Assert.assertEquals(0, obj.searchInsert(nums, 0));
  }
}
