package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestCommonPrefix}.
 *
 * @see <a href = ""></a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class LongestCommonPrefixTest {

  private final LongestCommonPrefix obj = new LongestCommonPrefix();

  @Test
  public void testCommonPrefixExists() {
    Assert.assertEquals("fl", obj.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
  }

  @Test
  public void testCommonPrefixDoesntExists() {
    Assert.assertEquals("", obj.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
  }

  @Test
  public void testEmptyStringArray() {
    Assert.assertEquals("", obj.longestCommonPrefix(new String[] {}));
  }

  @Test
  public void testSingleWord() {
    Assert.assertEquals("pokemon", obj.longestCommonPrefix(new String[] {"pokemon"}));
  }

  @Test
  public void testSingleWordRepeated() {
    Assert.assertEquals(
        "pokemon",
        obj.longestCommonPrefix(new String[] {"pokemon", "pokemon", "pokemon", "pokemon"}));
  }

  @Test
  public void testPartOfWordMatches() {
    Assert.assertEquals("bat", obj.longestCommonPrefix(new String[] {"batball", "bat"}));
  }

  @Test
  public void testSingleCharacterWords() {
    Assert.assertEquals("", obj.longestCommonPrefix(new String[] {"a", "b"}));
  }
}
