package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FirstUniqueCharacterInString}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FirstUniqueCharacterInStringTest {

  private final FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();

  @Test
  public void testScenario1() {
    final String s = "leetcode";
    Assert.assertEquals(0, obj.firstUniqChar(s));
  }

  @Test
  public void testNoUniqueCharacter() {
    final String s = "leetleet";
    Assert.assertEquals(-1, obj.firstUniqChar(s));
  }

  @Test
  public void testScenario2() {
    final String s = "loveleetcode";
    Assert.assertEquals(2, obj.firstUniqChar(s));
  }
}
