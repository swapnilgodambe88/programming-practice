package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link IsIntegerPalindrome}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class IsIntegerPalindromeTest {

  private final IsIntegerPalindrome obj = new IsIntegerPalindrome();

  @Test
  public void testZero() {
    Assert.assertTrue(obj.isPalindrome(0));
  }

  @Test
  public void testNegativeNumber() {
    Assert.assertFalse(obj.isPalindrome(-121));
  }

  @Test
  public void testPalindromeIntegerOddDigits() {
    Assert.assertTrue(obj.isPalindrome(12121));
  }

  @Test
  public void testPalindromeIntegerEvenDigits() {
    Assert.assertTrue(obj.isPalindrome(1221));
  }

  @Test
  public void testAllDigitsSame() {
    Assert.assertTrue(obj.isPalindrome(99999999));
  }

  @Test
  public void testIntegerNotPalindrome() {
    Assert.assertFalse(obj.isPalindrome(10));
  }
}
