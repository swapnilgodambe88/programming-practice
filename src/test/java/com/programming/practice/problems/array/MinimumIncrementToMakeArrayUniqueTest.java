package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumIncrementToMakeArrayUnique}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 */
public class MinimumIncrementToMakeArrayUniqueTest {
  private final MinimumIncrementToMakeArrayUnique obj = new MinimumIncrementToMakeArrayUnique();

  @Test
  public void testScenario1() {
    final int[] A = new int[] {1, 2, 2};

    Assert.assertEquals(1, obj.minIncrementForUnique(A));
  }

  @Test
  public void testScenario2() {
    final int[] A = new int[] {3, 2, 1, 2, 1, 7};

    Assert.assertEquals(6, obj.minIncrementForUnique(A));
  }

  @Test
  public void testScenario3() {
    final int[] A = new int[] {1, 1, 1, 1, 10};

    Assert.assertEquals(6, obj.minIncrementForUnique(A));
  }

  @Test
  public void testEmptyA() {
    final int[] A = new int[] {};

    Assert.assertEquals(0, obj.minIncrementForUnique(A));
  }

  @Test
  public void testAllUniqueA() {
    final int[] A = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};

    Assert.assertEquals(0, obj.minIncrementForUnique(A));
  }
}
