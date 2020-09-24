package com.programming.practice.problems.string;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link WordBreak}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class WordBreakTest {

  private final WordBreak obj = new WordBreak();

  @Test
  public void testScenario1() {
    final String s = "leetcode";
    final List<String> wordDict = Arrays.asList("leet", "code");

    Assert.assertTrue(obj.wordBreak(s, wordDict));
  }

  @Test
  public void testScenario2() {
    final String s = "applepenapple";
    final List<String> wordDict = Arrays.asList("apple", "pen");

    Assert.assertTrue(obj.wordBreak(s, wordDict));
  }

  @Test
  public void testScenario3() {
    final String s = "catsandog";
    final List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

    Assert.assertFalse(obj.wordBreak(s, wordDict));
  }

  @Test
  public void testScenario4() {
    final String s =
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    final List<String> wordDict =
        Arrays.asList(
            "a",
            "aa",
            "aaa",
            "aaaa",
            "aaaaa",
            "aaaaaa",
            "aaaaaaa",
            "aaaaaaaa",
            "aaaaaaaaa",
            "aaaaaaaaaa");

    Assert.assertFalse(obj.wordBreak(s, wordDict));
  }
}
