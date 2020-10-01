package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TopKFrequentWords}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TopKFrequentWordsTest {

  private final TopKFrequentWords obj = new TopKFrequentWords();

  @Test
  public void testScenario1() {
    final String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
    final int k = 2;
    final List<String> expectedTopKFrequentWords = Arrays.asList("i", "love");

    Assert.assertEquals(expectedTopKFrequentWords, obj.topKFrequent(words, k));
  }

  @Test
  public void testScenario2() {
    final String[] words =
        new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    final int k = 4;
    final List<String> expectedTopKFrequentWords = Arrays.asList("the", "is", "sunny", "day");

    Assert.assertEquals(expectedTopKFrequentWords, obj.topKFrequent(words, k));
  }
}
