package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RemoveElement}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class RemoveElementTest {

  private final RemoveElement obj = new RemoveElement();

  /**
   * Performs assertions on the result.
   *
   * @param expectedLength The expected length.
   * @param actualLength The actual length.
   * @param alteredNumbers The array.
   */
  private static void assertOnResultArray(
      final int expectedLength,
      final int actualLength,
      final int[] alteredNumbers,
      final int valueToRemove) {
    Assert.assertEquals(
        "Assertion failed on expected length of the altered array", expectedLength, actualLength);

    for (int i = 0; i < actualLength; i++) {
      if (alteredNumbers[i] == valueToRemove) {
        Assert.fail("Element found on array");
      }
    }
  }

  @Test
  public void testNoElementFound() {
    final int[] inputNumbers = new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4};
    final int valueToRemove = 99;

    final int lengthOfAlteredArray = obj.removeElement(inputNumbers, valueToRemove);
    assertOnResultArray(10, lengthOfAlteredArray, inputNumbers, valueToRemove);
  }

  @Test
  public void testSingleElementFound() {
    final int[] inputNumbers = new int[] {1, 2, 3, 4, 5};
    final int valueToRemove = 2;

    final int lengthOfAlteredArray = obj.removeElement(inputNumbers, valueToRemove);
    assertOnResultArray(4, lengthOfAlteredArray, inputNumbers, valueToRemove);
  }

  @Test
  public void testAllElementsSame() {
    final int[] inputNumbers = new int[] {1, 1, 1, 1, 1};
    final int valueToRemove = 1;

    final int lengthOfAlteredArray = obj.removeElement(inputNumbers, valueToRemove);
    assertOnResultArray(0, lengthOfAlteredArray, inputNumbers, valueToRemove);
  }
}
