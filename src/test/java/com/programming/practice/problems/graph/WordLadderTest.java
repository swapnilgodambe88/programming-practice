package com.programming.practice.problems.graph;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link WordLadder}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class WordLadderTest {

  private final WordLadder obj = new WordLadder();

  @Test
  public void testScenario1() {
    final List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

    Assert.assertEquals(5, obj.ladderLength("hit", "cog", wordList));
  }

  @Test
  public void testScenario2() {
    final List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");

    Assert.assertEquals(0, obj.ladderLength("hit", "cog", wordList));
  }
}
