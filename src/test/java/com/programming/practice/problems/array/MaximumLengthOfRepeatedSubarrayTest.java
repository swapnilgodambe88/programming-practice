package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximumLengthOfRepeatedSubarray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumLengthOfRepeatedSubarrayTest {

  private final MaximumLengthOfRepeatedSubarray obj = new MaximumLengthOfRepeatedSubarray();

  @Test
  public void testScenario1() {
    final int[] A = new int[] {1, 2, 3, 2, 1};
    final int[] B = new int[] {3, 2, 1, 4, 7};

    Assert.assertEquals(3, obj.findLength(A, B));
  }

  @Test
  public void testScenario2() {
    final int[] A = new int[] {70, 39, 25, 40, 7};
    final int[] B = new int[] {52, 20, 67, 5, 31};

    Assert.assertEquals(0, obj.findLength(A, B));
  }
}
