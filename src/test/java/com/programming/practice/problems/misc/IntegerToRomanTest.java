package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link IntegerToRoman}.
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class IntegerToRomanTest {

  @Test
  public void testRoman3() {
    final IntegerToRoman obj = new IntegerToRoman();

    Assert.assertEquals("III", obj.intToRoman(3));
  }

  @Test
  public void testRoman4() {
    final IntegerToRoman obj = new IntegerToRoman();

    Assert.assertEquals("IV", obj.intToRoman(4));
  }

  @Test
  public void testRoman9() {
    final IntegerToRoman obj = new IntegerToRoman();

    Assert.assertEquals("IX", obj.intToRoman(9));
  }

  @Test
  public void testRoman58() {
    final IntegerToRoman obj = new IntegerToRoman();

    Assert.assertEquals("LVIII", obj.intToRoman(58));
  }

  @Test
  public void testRoman1994() {
    final IntegerToRoman obj = new IntegerToRoman();

    Assert.assertEquals("MCMXCIV", obj.intToRoman(1994));
  }

  @Test
  public void testRoman20() {
    final IntegerToRoman obj = new IntegerToRoman();

    Assert.assertEquals("XX", obj.intToRoman(20));
  }
}
