package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumMovesToEqualArrayElements}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumMovesToEqualArrayElementsTest {

  private final MinimumMovesToEqualArrayElements obj = new MinimumMovesToEqualArrayElements();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 2, 3};
    Assert.assertEquals(3, obj.minMoves(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {13, 18, 3, 10, 35, 68, 50, 20, 50};
    Assert.assertEquals(240, obj.minMoves(nums));
  }
}
