package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SquareOfSortedArray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SquareOfSortedArrayTest {

  private final SquareOfSortedArray obj = new SquareOfSortedArray();

  @Test
  public void testEmptyArray() {
    final int[] nums = new int[] {};
    final int[] expectedSquares = new int[] {};

    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingSorting(nums));
    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingTwoPointers(nums));
  }

  @Test
  public void testAllPositiveElements() {
    final int[] nums = new int[] {1, 2, 3, 4, 5};
    final int[] expectedSquares = new int[] {1, 4, 9, 16, 25};

    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingSorting(nums));
    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingTwoPointers(nums));
  }

  @Test
  public void testAllNegativeElements() {
    final int[] nums = new int[] {-5, -4, -3, -2, -1};
    final int[] expectedSquares = new int[] {1, 4, 9, 16, 25};

    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingSorting(nums));
    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingTwoPointers(nums));
  }

  @Test
  public void testMixOfPositiveNegativeElements() {
    final int[] nums = new int[] {-5, -3, -1, 2, 4, 5};
    final int[] expectedSquares = new int[] {1, 4, 9, 16, 25, 25};

    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingSorting(nums));
    Assert.assertArrayEquals(expectedSquares, obj.sortedSquares_usingTwoPointers(nums));
  }
}
