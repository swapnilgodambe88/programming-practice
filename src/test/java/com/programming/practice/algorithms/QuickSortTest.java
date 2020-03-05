package com.programming.practice.algorithms;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * White box test for {@link QuickSort}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class QuickSortTest {

  @Rule public final ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void testConstructorInvocationThrowsError() {
    exceptionRule.expect(UnsupportedOperationException.class);
    exceptionRule.expectMessage("Constructor invocation for QuickSort forbidden");

    new QuickSort();
  }
  /** Verifies ascending Bubble sort for empty array. */
  @Test
  public void testEmptyAscending() {
    final int inputArray[] = {};

    final int expectedSortedArray[] = {};
    QuickSort.sortAscending(inputArray, 0, inputArray.length - 1);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies ascending positive Bubble sort for random numbers. */
  @Test
  public void testRandomPositiveAscending() {
    final int inputArray[] = {9, 11, 2, 5, 8, 9, 17, 14, 1, 0};

    final int expectedSortedArray[] = {0, 1, 2, 5, 8, 9, 9, 11, 14, 17};
    QuickSort.sortAscending(inputArray, 0, inputArray.length - 1);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies ascending negative Bubble sort for random numbers. */
  @Test
  public void testRandomNegativeAscending() {
    final int inputArray[] = {-9, -11, -2, -5, -8, -9, -17, -14, -1, 0};

    final int expectedSortedArray[] = {-17, -14, -11, -9, -9, -8, -5, -2, -1, 0};
    QuickSort.sortAscending(inputArray, 0, inputArray.length - 1);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies ascending Bubble sort for random numbers. */
  @Test
  public void testRandomAscending() {
    final int inputArray[] = {-9, 11, -2, -5, 8, -9, 17, 14, -1, 0};

    final int expectedSortedArray[] = {-9, -9, -5, -2, -1, 0, 8, 11, 14, 17};
    QuickSort.sortAscending(inputArray, 0, inputArray.length - 1);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }
}
