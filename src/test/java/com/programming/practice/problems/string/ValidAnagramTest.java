package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ValidAnagram}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ValidAnagramTest {

  private final ValidAnagram obj = new ValidAnagram();

  @Test
  public void testScenario1() {
    Assert.assertTrue(obj.isAnagram("anagram", "nagaram"));
  }

  @Test
  public void testScenario2() {
    Assert.assertFalse(obj.isAnagram("rat", "car"));
  }

  @Test
  public void testBothEmptyStrings() {
    Assert.assertTrue(obj.isAnagram("", ""));
  }

  @Test
  public void testOneEmptyOtherNonEmpty() {
    Assert.assertFalse(obj.isAnagram("", "rat"));
  }

  @Test
  public void testOneWithSpacesOtherWithoutSpaces() {
    Assert.assertFalse(obj.isAnagram("rat cat", "ratcat"));
  }
}
