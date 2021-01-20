package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link PowTest}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class PowTest {
  private final Pow obj = new Pow();
  private static final double DELTA = 0.0001;

  @Test
  public void testScenario1() {
    Assert.assertEquals(1024.00, obj.myPow(2.0, 10), DELTA);
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(9.26100, obj.myPow(2.1, 3), DELTA);
  }

  @Test
  public void testScenario3() {
    Assert.assertEquals(0.25, obj.myPow(2.0, -2), DELTA);
  }
}
