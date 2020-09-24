package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link VerifyingAnAlienDictionary}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class VerifyingAnAlienDictionaryTest {

  private final VerifyingAnAlienDictionary obj = new VerifyingAnAlienDictionary();

  @Test
  public void testScenario1() {
    final String words[] = new String[] {"hello", "leetcode"};
    final String order = "hlabcdefgijkmnopqrstuvwxyz";

    Assert.assertTrue(obj.isAlienSorted(words, order));
  }

  @Test
  public void testScenario2() {
    final String words[] = new String[] {"word", "world", "row"};
    final String order = "worldabcefghijkmnpqstuvxyz";

    Assert.assertFalse(obj.isAlienSorted(words, order));
  }

  @Test
  public void testScenario3() {
    final String words[] = new String[] {"apple", "app"};
    final String order = "abcdefghijklmnopqrstuvwxyz";

    Assert.assertFalse(obj.isAlienSorted(words, order));
  }
}
