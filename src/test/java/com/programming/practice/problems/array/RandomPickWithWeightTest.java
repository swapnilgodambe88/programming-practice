package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@linlk RandomPickWithWeight}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class RandomPickWithWeightTest {

  @Test
  public void testScenario1() {
    final int[] weights = new int[] {10};
    final RandomPickWithWeight obj = new RandomPickWithWeight(weights);

    for (int i = 0; i < 50; ++i) {
      Assert.assertEquals(0, obj.pickIndex());
    }
  }

  @Test
  public void testScenario2() {
    final int[] weights = new int[] {3, 14, 1, 7};
    final RandomPickWithWeight obj = new RandomPickWithWeight(weights);

    for (int i = 0; i < 50; ++i) {
      final int randomIndex = obj.pickIndex();
      Assert.assertTrue(randomIndex >= 0 && randomIndex <= 3);
    }
  }
}
