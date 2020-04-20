package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FindKClosestElements}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FindKClosestElementsTest {

  private final FindKClosestElements obj = new FindKClosestElements();

  @Test
  public void testScenario1() {
    final int[] arr = new int[] {1, 2, 3, 4, 5};
    final int k = 4;
    final int x = 3;

    final List<Integer> expectedKClosestElements = Arrays.asList(1, 2, 3, 4);
    Assert.assertEquals(expectedKClosestElements, obj.findClosestElements(arr, k, x));
  }

  @Test
  public void testScenario2() {
    final int[] arr = new int[] {1, 1, 1, 10, 10, 10};
    final int k = 1;
    final int x = 9;

    final List<Integer> expectedKClosestElements = Arrays.asList(10);
    Assert.assertEquals(expectedKClosestElements, obj.findClosestElements(arr, k, x));
  }
}
