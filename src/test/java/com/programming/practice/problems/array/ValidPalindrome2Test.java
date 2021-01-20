package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ValidPalindrome2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ValidPalindrome2Test {

  private final ValidPalindrome2 obj = new ValidPalindrome2();

  @Test
  public void testScenario1() {
    Assert.assertTrue(obj.validPalindrome("aba"));
  }

  @Test
  public void testScenario2() {
    Assert.assertTrue(obj.validPalindrome("abca"));
  }

  @Test
  public void testScenario3() {
    Assert.assertTrue(
        obj.validPalindrome(
            "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
  }

  @Test
  public void testScenario4() {
    Assert.assertTrue(obj.validPalindrome("abca"));
  }

  @Test
  public void testScenario5() {
    Assert.assertFalse(obj.validPalindrome("abtca"));
  }
}
