package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestCommonPrefix}.
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class LongestCommonPrefixTest {

  @Test
  public void testCommonPrefixExists() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals("fl", obj.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
  }

  @Test
  public void testCommonPrefixDoesntExists() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals("", obj.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
  }

  @Test
  public void testEmptyStringArray() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals("", obj.longestCommonPrefix(new String[] {}));
  }

  @Test
  public void testSingleWord() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals("pokemon", obj.longestCommonPrefix(new String[] {"pokemon"}));
  }

  @Test
  public void testSingleWordRepeated() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals(
        "pokemon",
        obj.longestCommonPrefix(new String[] {"pokemon", "pokemon", "pokemon", "pokemon"}));
  }

  @Test
  public void testPartOfWordMatches() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals("bat", obj.longestCommonPrefix(new String[] {"batball", "bat"}));
  }

  @Test
  public void testSingleCharacterWords() {
    final LongestCommonPrefix obj = new LongestCommonPrefix();

    Assert.assertEquals("", obj.longestCommonPrefix(new String[] {"a", "b"}));
  }
}
