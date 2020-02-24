package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link IntegerToRoman}.
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class IntegerToRomanTest {

  private final IntegerToRoman obj = new IntegerToRoman();

  @Test
  public void testRoman3() {
    Assert.assertEquals("III", obj.intToRoman(3));
  }

  @Test
  public void testRoman4() {
    Assert.assertEquals("IV", obj.intToRoman(4));
  }

  @Test
  public void testRoman9() {
    Assert.assertEquals("IX", obj.intToRoman(9));
  }

  @Test
  public void testRoman58() {
    Assert.assertEquals("LVIII", obj.intToRoman(58));
  }

  @Test
  public void testRoman1994() {
    Assert.assertEquals("MCMXCIV", obj.intToRoman(1994));
  }

  @Test
  public void testRoman20() {
    Assert.assertEquals("XX", obj.intToRoman(20));
  }
}
