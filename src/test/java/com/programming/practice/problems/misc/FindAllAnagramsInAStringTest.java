package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link FindAllAnagramsInAString}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class FindAllAnagramsInAStringTest {

  private final FindAllAnagramsInAString obj = new FindAllAnagramsInAString();

  @Test
  public void testScenario1() {
    final String s = "cbaebabacd";
    final String p = "abc";

    final List<Integer> expectedAnagrams = Arrays.asList(0, 6);
    Assert.assertEquals(expectedAnagrams, obj.findAnagrams(s, p));
  }

  @Test
  public void testScenario2() {
    final String s = "abab";
    final String p = "ab";

    final List<Integer> expectedAnagrams = Arrays.asList(0, 1, 2);
    Assert.assertEquals(expectedAnagrams, obj.findAnagrams(s, p));
  }
}
