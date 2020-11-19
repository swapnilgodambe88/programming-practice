package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MostCommonWord}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MostCommonWordTest {

  private final MostCommonWord obj = new MostCommonWord();

  @Test
  public void testScenario1() {
    final String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    final String[] banned = new String[] {"hit"};

    Assert.assertEquals("ball", obj.mostCommonWord(paragraph, banned));
  }

  @Test
  public void testScenario2() {
    final String paragraph = "a, a, a, a, b,b,b,c, c";
    final String[] banned = new String[] {"a"};

    Assert.assertEquals("b", obj.mostCommonWord(paragraph, banned));
  }
}
