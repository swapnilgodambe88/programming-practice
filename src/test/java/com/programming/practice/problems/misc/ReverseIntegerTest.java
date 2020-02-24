package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReverseInteger}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReverseIntegerTest {

  private final ReverseInteger obj = new ReverseInteger();

  @Test
  public void testRandom1() {
    Assert.assertEquals(321, obj.reverse(123));
  }

  @Test
  public void testRandom2() {
    Assert.assertEquals(-321, obj.reverse(-123));
  }

  @Test
  public void testRandom3() {
    Assert.assertEquals(21, obj.reverse(120));
  }

  @Test
  public void testReverseNumberIsGreaterThan32bit1() {
    Assert.assertEquals(0, obj.reverse(1534236469));
  }

  @Test
  public void testReverseNumberIsGreaterThan32bit2() {
    Assert.assertEquals(0, obj.reverse(-2147483648));
  }
}
