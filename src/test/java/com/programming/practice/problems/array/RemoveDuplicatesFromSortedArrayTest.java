package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RemoveDuplicatesFromSortedArray}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class RemoveDuplicatesFromSortedArrayTest {
  private final RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();

  /**
   * Performs assertions on the result.
   *
   * @param expectedLength The expected length.
   * @param actualLength The actual length.
   * @param alteredNumbers The array.
   */
  private static void assertOnResultArray(
      final int expectedLength, final int actualLength, final int[] alteredNumbers) {
    Assert.assertEquals(
        "Assertion failed on expected length of the altered array", expectedLength, actualLength);

    for (int i = 0; i < actualLength - 1; i++) {
      if (alteredNumbers[i] == alteredNumbers[i + 1]) {
        Assert.fail("Duplicate element found on the altered array");
      }
    }
  }

  @Test
  public void testAllDuplicateTwice() {
    final int[] inputNumbers = new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4};

    final int lengthOfNonDuplicateArray = obj.removeDuplicates(inputNumbers);
    assertOnResultArray(5, lengthOfNonDuplicateArray, inputNumbers);
  }

  @Test
  public void testSameElementRepeated() {
    final int[] inputNumbers = new int[] {9, 9, 9, 9, 9, 9};

    final int lengthOfNonDuplicateArray = obj.removeDuplicates(inputNumbers);
    assertOnResultArray(1, lengthOfNonDuplicateArray, inputNumbers);
  }

  @Test
  public void testSingleElement() {
    final int[] inputNumbers = new int[] {9};

    final int lengthOfNonDuplicateArray = obj.removeDuplicates(inputNumbers);
    assertOnResultArray(1, lengthOfNonDuplicateArray, inputNumbers);
  }

  @Test
  public void testAllUniqueElements() {
    final int[] inputNumbers = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};

    final int lengthOfNonDuplicateArray = obj.removeDuplicates(inputNumbers);
    assertOnResultArray(9, lengthOfNonDuplicateArray, inputNumbers);
  }

  @Test
  public void testEmptyArray() {
    final int[] inputNumbers = new int[] {};

    final int lengthOfNonDuplicateArray = obj.removeDuplicates(inputNumbers);
    assertOnResultArray(0, lengthOfNonDuplicateArray, inputNumbers);
  }
}
