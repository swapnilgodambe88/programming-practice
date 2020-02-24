package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ImplementStrStr}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ImplementStrStrTest {

  private final ImplementStrStr obj = new ImplementStrStr();

  @Test
  public void testNeedlePresent() {
    final String haystack = "hello";
    final String needle = "ll";

    Assert.assertEquals(2, obj.strStr(haystack, needle));
  }

  @Test
  public void testNotNeedlePresent() {
    final String haystack = "hello";
    final String needle = "xyz";

    Assert.assertEquals(-1, obj.strStr(haystack, needle));
  }

  @Test
  public void testPartiallyNeedlePresent() {
    final String haystack = "hello";
    final String needle = "loy";

    Assert.assertEquals(-1, obj.strStr(haystack, needle));
  }

  @Test
  public void testEmptyHaystack() {
    final String haystack = "";
    final String needle = "loy";

    Assert.assertEquals(-1, obj.strStr(haystack, needle));
  }

  @Test
  public void testEmptyNeedle() {
    final String haystack = "Hello";
    final String needle = "";

    Assert.assertEquals(0, obj.strStr(haystack, needle));
  }
}
