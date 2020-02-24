package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StepsToReduceNumberToZero}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class StepsToReduceNumberToZeroTest {

  private final StepsToReduceNumberToZero obj = new StepsToReduceNumberToZero();

  @Test
  public void testZero() {
    Assert.assertEquals(0, obj.numberOfSteps(0));
  }

  @Test
  public void testNegativeNumber() {
    Assert.assertEquals(0, obj.numberOfSteps(-1));
  }

  @Test
  public void testPositiveNumber1() {
    Assert.assertEquals(6, obj.numberOfSteps(14));
  }

  @Test
  public void testPositiveNumber2() {
    Assert.assertEquals(4, obj.numberOfSteps(8));
  }

  @Test
  public void testPositiveNumber3() {
    Assert.assertEquals(12, obj.numberOfSteps(123));
  }
}
