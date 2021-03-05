package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ProductOfArrayExceptSelf}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ProductOfArrayExceptSelfTest {

  private final ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 2, 3, 4};
    final int[] expectedResult = new int[] {24, 12, 8, 6};

    Assert.assertArrayEquals(expectedResult, obj.productExceptSelf(nums));
  }

  @Test
  public void testSingleElement() {
    final int[] nums = new int[] {9};
    final int[] expectedResult = new int[] {9};

    Assert.assertArrayEquals(expectedResult, obj.productExceptSelf(nums));
  }

  @Test
  public void testEmptyArray() {
    final int[] nums = new int[] {};
    final int[] expectedResult = new int[] {};

    Assert.assertArrayEquals(expectedResult, obj.productExceptSelf(nums));
  }

  @Test
  public void testAllZeros() {
    final int[] nums = new int[] {0, 0};
    final int[] expectedResult = new int[] {0, 0};

    Assert.assertArrayEquals(expectedResult, obj.productExceptSelf(nums));
  }

  @Test
  public void testOneZero() {
    final int[] nums = new int[] {1, 0};
    final int[] expectedResult = new int[] {0, 1};

    Assert.assertArrayEquals(expectedResult, obj.productExceptSelf(nums));
  }
}
