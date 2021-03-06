package com.programming.practice.problems.array;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TwoSum}
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class TwoSumTest {

  private final TwoSum obj = new TwoSum();

  private static void assertArraysAreEqual(final int[] array1, final int[] array2) {
    Assert.assertTrue("Arrays are not equal", Arrays.equals(array1, array2));
  }

  @Test
  public void testNoSolutionExists() {
    final int[] inputArray = {1, 2, 3, 4, 5, 6};

    Assert.assertThrows(
        "No solution exists for the given inputArray",
        IllegalArgumentException.class,
        () -> {
          obj.twoSum(inputArray, 20);
        });
  }

  @Test
  public void testNoSolutionExistsWithSameElementTwice() {
    final int[] inputArray = {1, 2, 3, 4, 5, 6};
    final TwoSum obj = new TwoSum();

    Assert.assertThrows(
        "No solution exists for the given inputArray",
        IllegalArgumentException.class,
        () -> {
          obj.twoSum(inputArray, 12);
        });
  }

  @Test
  public void testPositiveElements() {
    final int[] inputArray = {1, 12, 3, 4, 5, 6};
    final TwoSum obj = new TwoSum();

    final int[] expectedSolutionArray = {3, 4};
    assertArraysAreEqual(expectedSolutionArray, obj.twoSum(inputArray, 9));
  }

  @Test
  public void testNegativeElements() {
    final int[] inputArray = {-1, -12, -3, -4, -5, -9};
    final TwoSum obj = new TwoSum();

    final int[] expectedSolutionArray = {2, 3};
    assertArraysAreEqual(expectedSolutionArray, obj.twoSum(inputArray, -7));
  }

  @Test
  public void testPositiveNegativeElements() {
    final int[] inputArray = {12, 67, 19, -8, 4};
    final TwoSum obj = new TwoSum();

    final int[] expectedSolutionArray = {0, 3};
    assertArraysAreEqual(expectedSolutionArray, obj.twoSum(inputArray, 4));
  }

  @Test
  public void testNegativePositiveElements() {
    final int[] inputArray = {-12, 67, 19, 8, 4};
    final TwoSum obj = new TwoSum();

    final int[] expectedSolutionArray = {0, 3};
    assertArraysAreEqual(expectedSolutionArray, obj.twoSum(inputArray, -4));
  }

  @Test
  public void testWithZeroElements() {
    final int[] inputArray = {1, 2, 3, 4, 19, 44, 0};
    final TwoSum obj = new TwoSum();

    final int[] expectedSolutionArray = {4, 6};
    assertArraysAreEqual(expectedSolutionArray, obj.twoSum(inputArray, 19));
  }

  @Test
  public void testSameElementButDifferentIndex() {
    final int[] inputArray = {1, 9, 8, 9, 59};
    final TwoSum obj = new TwoSum();

    final int[] expectedSolutionArray = {1, 3};
    assertArraysAreEqual(expectedSolutionArray, obj.twoSum(inputArray, 18));
  }

  @Test
  public void testSameElementSameIndex() {
    final int[] inputArray = {1, 9, 8, 59};
    final TwoSum obj = new TwoSum();

    Assert.assertThrows(
        "No solution exists for the given inputArray",
        IllegalArgumentException.class,
        () -> {
          obj.twoSum(inputArray, 18);
        });
  }
}
