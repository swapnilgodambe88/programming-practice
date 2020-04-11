package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ExpressiveWords}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ExpressiveWordsTest {

  private final ExpressiveWords obj = new ExpressiveWords();

  @Test
  public void testScenario1() {
    final String stretchyWord = "aaa";
    final String[] queryWords = new String[] {"aaaa"};

    Assert.assertEquals(0, obj.expressiveWords(stretchyWord, queryWords));
  }

  @Test
  public void testScenario2() {
    final String stretchyWord = "dddiiiinnssssssoooo";
    final String[] queryWords =
        new String[] {
          "dinnssoo",
          "ddinso",
          "ddiinnso",
          "ddiinnssoo",
          "ddiinso",
          "dinsoo",
          "ddiinsso",
          "dinssoo",
          "dinso"
        };

    Assert.assertEquals(3, obj.expressiveWords(stretchyWord, queryWords));
  }

  @Test
  public void testScenario3() {
    final String stretchyWord = "heeellooo";
    final String[] queryWords = new String[] {"hello", "hi", "helo"};

    Assert.assertEquals(1, obj.expressiveWords(stretchyWord, queryWords));
  }

  @Test
  public void testScenario4() {
    final String stretchyWord = "heeellooo";
    final String[] queryWords = new String[] {"axxxrrzzz"};

    Assert.assertEquals(0, obj.expressiveWords(stretchyWord, queryWords));
  }
}
