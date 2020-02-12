package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StepsToReduceNumberToZero}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class StepsToReduceNumberToZeroTest {

  @Test
  public void testZero() {
    final StepsToReduceNumberToZero obj = new StepsToReduceNumberToZero();

    Assert.assertEquals(0, obj.numberOfSteps(0));
  }

  @Test
  public void testNegativeNumber() {
    final StepsToReduceNumberToZero obj = new StepsToReduceNumberToZero();

    Assert.assertEquals(0, obj.numberOfSteps(-1));
  }

  @Test
  public void testPositiveNumber1() {
    final StepsToReduceNumberToZero obj = new StepsToReduceNumberToZero();

    Assert.assertEquals(6, obj.numberOfSteps(14));
  }

  @Test
  public void testPositiveNumber2() {
    final StepsToReduceNumberToZero obj = new StepsToReduceNumberToZero();

    Assert.assertEquals(4, obj.numberOfSteps(8));
  }

  @Test
  public void testPositiveNumber3() {
    final StepsToReduceNumberToZero obj = new StepsToReduceNumberToZero();

    Assert.assertEquals(12, obj.numberOfSteps(123));
  }
}
