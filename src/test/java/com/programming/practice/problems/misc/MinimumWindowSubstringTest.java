package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumWindowSubstring}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumWindowSubstringTest {

  private final MinimumWindowSubstring obj = new MinimumWindowSubstring();

  @Test
  public void testEmptyString() {
    Assert.assertEquals("", obj.minWindow("", "ABC"));
  }

  @Test
  public void testEmptyPattern() {
    Assert.assertEquals("", obj.minWindow("ADOBECODEBANC", ""));
  }

  @Test
  public void testInputSameAsString() {
    Assert.assertEquals("ADOBECODEBANC", obj.minWindow("ADOBECODEBANC", "ADOBECODEBANC"));
  }

  @Test
  public void testScenario1() {
    Assert.assertEquals("BANC", obj.minWindow("ADOBECODEBANC", "ABC"));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals("ACB", obj.minWindow("ABAACBAB", "ABC"));
  }

  @Test
  public void testScenario3() {
    Assert.assertEquals("", obj.minWindow("a", "aa"));
  }
}
