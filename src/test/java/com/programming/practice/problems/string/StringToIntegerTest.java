package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StringToInteger}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class StringToIntegerTest {

  @Test
  public void testValidIntegerString() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(42, obj.myAtoi("42"));
  }

  @Test
  public void testValidIntegerStringWithLeadingSpaces() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(456, obj.myAtoi("     456"));
  }

  @Test
  public void testValidIntegerStringWithTrailingSpaces() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(456, obj.myAtoi("     456     "));
  }

  @Test
  public void testValidNegativeIntegerStringWithLeadingSpaces() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(-34456, obj.myAtoi("     -34456"));
  }

  @Test
  public void testValidNegativeIntegerStringWithTrailingSpaces() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(-34456, obj.myAtoi("     -34456     "));
  }

  @Test
  public void testIntegerStringWithTrailingWords() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(4193, obj.myAtoi("4193 with words"));
  }

  @Test
  public void testIntegerStringWithLeadingWords() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(0, obj.myAtoi("words and 987"));
  }

  @Test
  public void testPositiveNumberExceding32bit1() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(Integer.MAX_VALUE, obj.myAtoi("123456789123456789123"));
  }

  @Test
  public void testPositiveNumberExceding32bit2() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(Integer.MAX_VALUE, obj.myAtoi("123456789123456789123"));
  }

  @Test
  public void testNegativeNumberExceding32bit() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(Integer.MIN_VALUE, obj.myAtoi("-6147483648"));
  }

  @Test
  public void testPositiveNegativeSignAtBeginning() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(0, obj.myAtoi("+-2"));
  }

  @Test
  public void testPositiveNegativeSignInTheMiddle() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(12345, obj.myAtoi("12345-2"));
  }

  @Test
  public void testSpaceInMiddle() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(0, obj.myAtoi("     +0 123"));
  }

  @Test
  public void testIntegerMinValue() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(Integer.MIN_VALUE, obj.myAtoi(Integer.toString(Integer.MIN_VALUE)));
  }

  @Test
  public void testIntegerMinValuePlus1() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(Integer.MIN_VALUE + 1, obj.myAtoi(Integer.toString(Integer.MIN_VALUE + 1)));
  }

  @Test
  public void testIntegerMaxValueMinus1() {
    final StringToInteger obj = new StringToInteger();

    Assert.assertEquals(Integer.MAX_VALUE - 1, obj.myAtoi(Integer.toString(Integer.MAX_VALUE - 1)));
  }
}
