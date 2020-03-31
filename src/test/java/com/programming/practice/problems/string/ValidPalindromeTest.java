package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link ValidPalindrome}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ValidPalindromeTest {

  private final ValidPalindrome obj = new ValidPalindrome();

  @Test
  public void testScenario1() {
    Assert.assertTrue(obj.isPalindrome("A man, a plan, a canal: Panama"));
  }

  @Test
  public void testScenario2() {
    Assert.assertFalse(obj.isPalindrome("race a car"));
  }

  @Test
  public void testEmptyString() {
    Assert.assertTrue(obj.isPalindrome(""));
  }

  @Test
  public void testStringOfLength1() {
    Assert.assertTrue(obj.isPalindrome("a"));
  }

  @Test
  public void testStringWithOnlySpaces() {
    Assert.assertTrue(obj.isPalindrome("    "));
  }

  @Test
  public void testStringWithOnlyNonAlphaNumericCharacters() {
    Assert.assertTrue(obj.isPalindrome("!@#$%^&*()"));
  }
}
