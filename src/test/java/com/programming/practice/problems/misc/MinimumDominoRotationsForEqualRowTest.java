package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumDominoRotationsForEqualRow}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumDominoRotationsForEqualRowTest {

  private final MinimumDominoRotationsForEqualRow obj = new MinimumDominoRotationsForEqualRow();

  @Test
  public void testScenario1() {
    final int[] A = new int[] {2, 1, 2, 4, 2, 2};
    final int[] B = new int[] {5, 2, 6, 2, 3, 2};

    Assert.assertEquals(2, obj.minDominoRotations(A, B));
  }

  @Test
  public void testAHavingSameNumber() {
    final int[] A = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
    final int[] B = new int[] {1, 1, 1, 1, 1, 1, 1, 1};

    Assert.assertEquals(0, obj.minDominoRotations(A, B));
  }

  @Test
  public void testNoSolutionExists() {
    final int[] A = new int[] {3, 5, 1, 2, 3};
    final int[] B = new int[] {3, 6, 3, 3, 4};

    Assert.assertEquals(-1, obj.minDominoRotations(A, B));
  }
}
