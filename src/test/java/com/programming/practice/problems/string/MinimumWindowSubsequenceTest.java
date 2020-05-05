package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumWindowSubsequence}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumWindowSubsequenceTest {

  private final MinimumWindowSubsequence obj = new MinimumWindowSubsequence();

  @Test
  public void testScenario1() {
    final String S = "abcdebdde";
    final String T = "bde";

    Assert.assertEquals("bcde", obj.minWindow(S, T));
  }

  @Test
  public void testScenario2() {
    final String S = "cnhczmccqouqadqtmjjzl";
    final String T = "mm";

    Assert.assertEquals("mccqouqadqtm", obj.minWindow(S, T));
  }
}
