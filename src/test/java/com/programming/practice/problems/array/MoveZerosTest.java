package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MoveZeros}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MoveZerosTest {

  private final MoveZeros obj = new MoveZeros();

  @Test
  public void testAllZeros() {
    final int[] nums = new int[] {0, 0, 0, 0, 0, 0, 0};
    final int[] expectedNums = new int[] {0, 0, 0, 0, 0, 0, 0};

    obj.moveZeroes(nums);
    Assert.assertArrayEquals(expectedNums, nums);
  }

  @Test
  public void testAllNonZeros() {
    final int[] nums = new int[] {1, 2, 3, 4, 5, 6};
    final int[] expectedNums = new int[] {1, 2, 3, 4, 5, 6};

    obj.moveZeroes(nums);
    Assert.assertArrayEquals(expectedNums, nums);
  }

  @Test
  public void testEmptyArray() {
    final int[] nums = new int[] {};
    final int[] expectedNums = new int[] {};

    obj.moveZeroes(nums);
    Assert.assertArrayEquals(expectedNums, nums);
  }

  @Test
  public void testAllZeroAtStart() {
    final int[] nums = new int[] {0, 0, 0, 0, 1, 2, 3, 4};
    final int[] expectedNums = new int[] {1, 2, 3, 4, 0, 0, 0, 0};

    obj.moveZeroes(nums);
    Assert.assertArrayEquals(expectedNums, nums);
  }

  @Test
  public void testAllZeroAtEnd() {
    final int[] nums = new int[] {1, 2, 3, 4, 0, 0, 0, 0};
    final int[] expectedNums = new int[] {1, 2, 3, 4, 0, 0, 0, 0};

    obj.moveZeroes(nums);
    Assert.assertArrayEquals(expectedNums, nums);
  }

  @Test
  public void testRandomZeroScenario() {
    final int[] nums = new int[] {0, 1, 2, 3, 0, 4, 5, 0, 0, 6, 7, 0};
    final int[] expectedNums = new int[] {1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0};

    obj.moveZeroes(nums);
    Assert.assertArrayEquals(expectedNums, nums);
  }
}
