package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DivideChocolate}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DivideChocolateTest {

  private final DivideChocolate obj = new DivideChocolate();

  @Test
  public void testScenario1() {
    final int[] sweetness = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    final int K = 5;

    Assert.assertEquals(6, obj.maximizeSweetness(sweetness, K));
  }

  @Test
  public void testScenario2() {
    final int[] sweetness = new int[] {5, 6, 7, 8, 9, 1, 2, 3, 4};
    final int K = 8;

    Assert.assertEquals(1, obj.maximizeSweetness(sweetness, K));
  }

  @Test
  public void testScenario3() {
    final int[] sweetness = new int[] {1, 2, 2, 1, 2, 2, 1, 2, 2};
    final int K = 2;

    Assert.assertEquals(5, obj.maximizeSweetness(sweetness, K));
  }
}
