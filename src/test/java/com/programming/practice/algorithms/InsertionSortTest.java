package com.programming.practice.algorithms;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;

/**
 * White box test for {@link InsertionSort}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public class InsertionSortTest {

  /** Verifies ascending Bubble sort for empty array. */
  @Test
  public void testEmptyAscending() {
    final int inputArray[] = {};

    final int expectedSortedArray[] = {};
    InsertionSort.sortAscending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies ascending possitive Bubble sort for random numbers. */
  @Test
  public void testRandomPositiveAscending() {
    final int inputArray[] = {9, 11, 2, 5, 8, 9, 17, 14, 1, 0};

    final int expectedSortedArray[] = {0, 1, 2, 5, 8, 9, 9, 11, 14, 17};
    InsertionSort.sortAscending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies ascending negative Bubble sort for random numbers. */
  @Test
  public void testRandomNegativeAscending() {
    final int inputArray[] = {-9, -11, -2, -5, -8, -9, -17, -14, -1, 0};

    final int expectedSortedArray[] = {-17, -14, -11, -9, -9, -8, -5, -2, -1, 0};
    InsertionSort.sortAscending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies ascending Bubble sort for random numbers. */
  @Test
  public void testRandomAscending() {
    final int inputArray[] = {-9, 11, -2, -5, 8, -9, 17, 14, -1, 0};

    final int expectedSortedArray[] = {-9, -9, -5, -2, -1, 0, 8, 11, 14, 17};
    InsertionSort.sortAscending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies descending Bubble sort for empty array. */
  @Test
  public void testEmptyDescending() {
    final int inputArray[] = {};

    final int expectedSortedArray[] = {};
    InsertionSort.sortDescending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies descending positive Bubble sort for random numbers. */
  @Test
  public void testRandomPositiveDescending() {
    final int inputArray[] = {9, 11, 2, 5, 8, 9, 17, 14, 1, 0};

    final int expectedSortedArray[] = {17, 14, 11, 9, 9, 8, 5, 2, 1, 0};
    InsertionSort.sortDescending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies descending negative Bubble sort for random numbers. */
  @Test
  public void testRandomNegativeDescending() {
    final int inputArray[] = {-9, -11, -2, -5, -8, -9, -17, -14, -1, -0};

    final int expectedSortedArray[] = {0, -1, -2, -5, -8, -9, -9, -11, -14, -17};
    InsertionSort.sortDescending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }

  /** Verifies descending Bubble sort for random numbers. */
  @Test
  public void testRandomDescending() {
    final int inputArray[] = {-9, -11, -2, -5, -8, -9, -17, -14, -1, -0};

    final int expectedSortedArray[] = {0, -1, -2, -5, -8, -9, -9, -11, -14, -17};
    InsertionSort.sortDescending(inputArray);

    assertTrue(Arrays.equals(inputArray, expectedSortedArray));
  }
}
