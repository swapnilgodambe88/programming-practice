package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RelativeSortArray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RelativeSortArrayTest {

  private final RelativeSortArray obj = new RelativeSortArray();

  @Test
  public void testScenario1() {
    final int[] arr1 = new int[] {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    final int[] arr2 = new int[] {2, 1, 4, 3, 9, 6};

    final int[] expectedSort = new int[] {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};

    Assert.assertArrayEquals(expectedSort, obj.relativeSortArray(arr1, arr2));
  }
}
