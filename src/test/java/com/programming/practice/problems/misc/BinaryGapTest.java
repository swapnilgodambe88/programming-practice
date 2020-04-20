package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BinaryGap}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryGapTest {

  private final BinaryGap obj = new BinaryGap();

  @Test
  public void testScenario1() {
    Assert.assertEquals(2, obj.binaryGap(22));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(2, obj.binaryGap(5));
  }

  @Test
  public void testScenario3() {
    Assert.assertEquals(1, obj.binaryGap(6));
  }

  @Test
  public void testScenario4() {
    Assert.assertEquals(0, obj.binaryGap(0));
  }
}
