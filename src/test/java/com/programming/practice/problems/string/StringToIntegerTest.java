package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StringToInteger}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class StringToIntegerTest {

  private final StringToInteger obj = new StringToInteger();

  @Test
  public void testValidIntegerString() {
    Assert.assertEquals(42, obj.myAtoi("42"));
  }

  @Test
  public void testValidIntegerStringWithLeadingSpaces() {
    Assert.assertEquals(456, obj.myAtoi("     456"));
  }

  @Test
  public void testValidIntegerStringWithTrailingSpaces() {
    Assert.assertEquals(456, obj.myAtoi("     456     "));
  }

  @Test
  public void testValidNegativeIntegerStringWithLeadingSpaces() {
    Assert.assertEquals(-34456, obj.myAtoi("     -34456"));
  }

  @Test
  public void testValidNegativeIntegerStringWithTrailingSpaces() {
    Assert.assertEquals(-34456, obj.myAtoi("     -34456     "));
  }

  @Test
  public void testIntegerStringWithTrailingWords() {
    Assert.assertEquals(4193, obj.myAtoi("4193 with words"));
  }

  @Test
  public void testIntegerStringWithLeadingWords() {
    Assert.assertEquals(0, obj.myAtoi("words and 987"));
  }

  @Test
  public void testPositiveNumberExceding32bit1() {
    Assert.assertEquals(Integer.MAX_VALUE, obj.myAtoi("123456789123456789123"));
  }

  @Test
  public void testPositiveNumberExceding32bit2() {
    Assert.assertEquals(Integer.MAX_VALUE, obj.myAtoi("123456789123456789123"));
  }

  @Test
  public void testNegativeNumberExceding32bit() {
    Assert.assertEquals(Integer.MIN_VALUE, obj.myAtoi("-6147483648"));
  }

  @Test
  public void testPositiveNegativeSignAtBeginning() {
    Assert.assertEquals(0, obj.myAtoi("+-2"));
  }

  @Test
  public void testPositiveNegativeSignInTheMiddle() {
    Assert.assertEquals(12345, obj.myAtoi("12345-2"));
  }

  @Test
  public void testSpaceInMiddle() {
    Assert.assertEquals(0, obj.myAtoi("     +0 123"));
  }

  @Test
  public void testIntegerMinValue() {
    Assert.assertEquals(Integer.MIN_VALUE, obj.myAtoi(Integer.toString(Integer.MIN_VALUE)));
  }

  @Test
  public void testIntegerMinValuePlus1() {
    Assert.assertEquals(Integer.MIN_VALUE + 1, obj.myAtoi(Integer.toString(Integer.MIN_VALUE + 1)));
  }

  @Test
  public void testIntegerMaxValueMinus1() {
    Assert.assertEquals(Integer.MAX_VALUE - 1, obj.myAtoi(Integer.toString(Integer.MAX_VALUE - 1)));
  }
}
