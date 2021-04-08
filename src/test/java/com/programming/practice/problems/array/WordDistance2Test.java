package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link WordDistance2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 */
public class WordDistance2Test {

  @Test
  public void testScenario1() {
    final String[] wordDict = new String[] {"practice", "makes", "perfect", "coding", "makes"};

    final WordDistance2 obj = new WordDistance2(wordDict);
    Assert.assertEquals(3, obj.shortest("coding", "practice"));
    Assert.assertEquals(1, obj.shortest("makes", "coding"));
  }
}
