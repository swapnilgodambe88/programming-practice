package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RomanToInteger}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class RomanToIntegerTest {

  private final RomanToInteger obj = new RomanToInteger();

  @Test
  public void testRoman3() {
    Assert.assertEquals(3, obj.romanToInt("III"));
  }

  @Test
  public void testRoman4() {
    Assert.assertEquals(4, obj.romanToInt("IV"));
  }

  @Test
  public void testRoman9() {
    Assert.assertEquals(9, obj.romanToInt("IX"));
  }

  @Test
  public void testRoman58() {
    Assert.assertEquals(58, obj.romanToInt("LVIII"));
  }

  @Test
  public void testRoman1994() {
    Assert.assertEquals(1994, obj.romanToInt("MCMXCIV"));
  }
}
