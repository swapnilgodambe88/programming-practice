package com.programming.practice.problems.array;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FirstLastPositionInSortedArray}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class FirstLastPositionInSortedArrayTest {

  private final FirstLastPositionInSortedArray obj = new FirstLastPositionInSortedArray();

  @Test
  public void testElementNotFound() {
    final int[] nums = new int[] {5, 7, 7, 8, 8, 10};
    final int[] expectedPositions = new int[] {-1, -1};

    Assert.assertTrue(
        "Assertion failed on arrays", Arrays.equals(expectedPositions, obj.searchRange(nums, 6)));
  }

  @Test
  public void testElementFoundMultipleOccurrences() {
    final int[] nums = new int[] {5, 7, 7, 8, 8, 10};
    final int[] expectedPositions = new int[] {3, 4};

    Assert.assertTrue(
        "Assertion failed on arrays", Arrays.equals(expectedPositions, obj.searchRange(nums, 8)));
  }

  @Test
  public void testElementFoundSingleOccurrences() {
    final int[] nums = new int[] {5, 7, 7, 8, 10};
    final int[] expectedPositions = new int[] {3, 3};

    Assert.assertTrue(
        "Assertion failed on arrays", Arrays.equals(expectedPositions, obj.searchRange(nums, 8)));
  }
}
