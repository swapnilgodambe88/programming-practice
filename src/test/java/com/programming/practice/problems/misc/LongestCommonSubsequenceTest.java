package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestCommonSubsequence}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LongestCommonSubsequenceTest {

  private final LongestCommonSubsequence obj = new LongestCommonSubsequence();

  @Test
  public void testScenario1() {
    final String text1 = "abcde";
    final String text2 = "ace";

    Assert.assertEquals(3, obj.longestCommonSubsequence(text1, text2));
  }

  @Test
  public void testScenario2() {
    final String text1 = "abc";
    final String text2 = "abc";

    Assert.assertEquals(3, obj.longestCommonSubsequence(text1, text2));
  }

  @Test
  public void testScenario3() {
    final String text1 = "abc";
    final String text2 = "def";

    Assert.assertEquals(0, obj.longestCommonSubsequence(text1, text2));
  }

  @Test
  public void testScenario4() {
    final String text1 = "bsbininm";
    final String text2 = "jmjkbkjkv";

    Assert.assertEquals(1, obj.longestCommonSubsequence(text1, text2));
  }

  @Test
  public void testText1Empty() {
    final String text1 = "";
    final String text2 = "def";

    Assert.assertEquals(0, obj.longestCommonSubsequence(text1, text2));
  }

  @Test
  public void testText2Empty() {
    final String text1 = "abc";
    final String text2 = "";

    Assert.assertEquals(0, obj.longestCommonSubsequence(text1, text2));
  }
}
