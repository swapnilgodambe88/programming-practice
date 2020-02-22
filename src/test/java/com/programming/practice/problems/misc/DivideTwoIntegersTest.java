package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DivideTwoIntegers}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public class DivideTwoIntegersTest {

  private final DivideTwoIntegers obj = new DivideTwoIntegers();

  @Test
  public void testBothDividendDivisorPositive() {
    Assert.assertEquals(3, obj.divide(10, 3));
  }

  @Test
  public void testBothDividendDivisorNegative() {
    Assert.assertEquals(3, obj.divide(-10, -3));
  }

  @Test
  public void testPerfectlyDivisible() {
    Assert.assertEquals(5, obj.divide(25, 5));
  }

  @Test
  public void testNegativeDivisor() {
    Assert.assertEquals(-6, obj.divide(36, -6));
  }

  @Test
  public void testNegativeDividend() {
    Assert.assertEquals(-6, obj.divide(-36, 6));
  }

  @Test
  public void testMaxDividendMaxDivisor() {
    Assert.assertEquals(1, obj.divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
  }

  @Test
  public void testMaxDividendMinDivisor() {
    Assert.assertEquals(0, obj.divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
  }

  @Test
  public void testMinDividendMinDivisor() {
    Assert.assertEquals(1, obj.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
  }
}
