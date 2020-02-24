package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestSubstringWithoutRepeatingCharacters}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class LongestSubstringWithoutRepeatingCharactersTest {

  private final LongestSubstringWithoutRepeatingCharacters obj =
      new LongestSubstringWithoutRepeatingCharacters();

  @Test
  public void testEmptyString() {
    final String inputString = "";

    Assert.assertEquals(0, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testRandomString1() {
    final String inputString = "abcabcbb";

    Assert.assertEquals(3, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testRandomString2() {
    final String inputString = "pwwkew";

    Assert.assertEquals(3, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testRandomString3() {
    final String inputString = "aab";

    Assert.assertEquals(2, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testSameCharacterString() {
    final String inputString = "bbbbbbb";

    Assert.assertEquals(1, obj.lengthOfLongestSubstring(inputString));
  }
}
