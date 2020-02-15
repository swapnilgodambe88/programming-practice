package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link IsIntegerPalindrome}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class IsIntegerPalindromeTest {

  @Test
  public void testZero() {
    final IsIntegerPalindrome obj = new IsIntegerPalindrome();

    Assert.assertTrue(obj.isPalindrome(0));
  }

  @Test
  public void testNegativeNumber() {
    final IsIntegerPalindrome obj = new IsIntegerPalindrome();

    Assert.assertFalse(obj.isPalindrome(-121));
  }

  @Test
  public void testPalindromeIntegerOddDigits() {
    final IsIntegerPalindrome obj = new IsIntegerPalindrome();

    Assert.assertTrue(obj.isPalindrome(12121));
  }

  @Test
  public void testPalindromeIntegerEvenDigits() {
    final IsIntegerPalindrome obj = new IsIntegerPalindrome();

    Assert.assertTrue(obj.isPalindrome(1221));
  }

  @Test
  public void testAllDigitsSame() {
    final IsIntegerPalindrome obj = new IsIntegerPalindrome();

    Assert.assertTrue(obj.isPalindrome(99999999));
  }

  @Test
  public void testIntegerNotPalindrome() {
    final IsIntegerPalindrome obj = new IsIntegerPalindrome();

    Assert.assertFalse(obj.isPalindrome(10));
  }
}
