package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestSubstringWithoutRepeatingCharacters}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class LongestSubstringWithoutRepeatingCharactersTest {

  @Test
  public void testEmptyString() {
    final String inputString = "";

    final LongestSubstringWithoutRepeatingCharacters obj =
        new LongestSubstringWithoutRepeatingCharacters();

    Assert.assertEquals(0, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testRandomString1() {
    final String inputString = "abcabcbb";

    final LongestSubstringWithoutRepeatingCharacters obj =
        new LongestSubstringWithoutRepeatingCharacters();

    Assert.assertEquals(3, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testRandomString2() {
    final String inputString = "pwwkew";

    final LongestSubstringWithoutRepeatingCharacters obj =
        new LongestSubstringWithoutRepeatingCharacters();

    Assert.assertEquals(3, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testRandomString3() {
    final String inputString = "aab";

    final LongestSubstringWithoutRepeatingCharacters obj =
        new LongestSubstringWithoutRepeatingCharacters();

    Assert.assertEquals(2, obj.lengthOfLongestSubstring(inputString));
  }

  @Test
  public void testSameCharacterString() {
    final String inputString = "bbbbbbb";

    final LongestSubstringWithoutRepeatingCharacters obj =
        new LongestSubstringWithoutRepeatingCharacters();

    Assert.assertEquals(1, obj.lengthOfLongestSubstring(inputString));
  }
}
