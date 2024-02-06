package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link Sqrtx}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class SqrtxTest {

  private final Sqrtx obj = new Sqrtx();

  @Test
  public void testSqrtOf4() {
    Assert.assertEquals(2, obj.mySqrt(4));
  }

  @Test
  public void testSqrtOf8() {
    Assert.assertEquals(2, obj.mySqrt(8));
  }

  @Test
  public void testSqrtOf12() {
    Assert.assertEquals(3, obj.mySqrt(12));
  }

  @Test
  public void testSqrtOf16() {
    Assert.assertEquals(4, obj.mySqrt(16));
  }

  @Test
  public void testSqrtOf27() {
    Assert.assertEquals(5, obj.mySqrt(27));
  }

  @Test
  public void testSqrtOf3() {
    Assert.assertEquals(1, obj.mySqrt(3));
  }

  @Test
  public void testSqrtOf1() {
    Assert.assertEquals(1, obj.mySqrt(1));
  }

  @Test
  public void testSqrtOfLargeNumber() {
    Assert.assertEquals(46339, obj.mySqrt(2147395599));
  }
}
