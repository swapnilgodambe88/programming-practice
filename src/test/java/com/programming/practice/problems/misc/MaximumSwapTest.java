package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MaximumSwap}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class MaximumSwapTest {
  private final MaximumSwap obj = new MaximumSwap();

  @Test
  public void testScenario1() {
    Assert.assertEquals(7236, obj.maximumSwap(2736));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(9973, obj.maximumSwap(9973));
  }
}
