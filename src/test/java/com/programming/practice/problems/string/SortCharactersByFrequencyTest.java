package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/** Unit test for {@link SortCharactersByFrequency}. */
public class SortCharactersByFrequencyTest {
  private final SortCharactersByFrequency obj = new SortCharactersByFrequency();

  @Test
  public void testScenario1() {
    final String input = "tree";
    final String expectedOutput = "eetr";

    Assert.assertEquals(expectedOutput, obj.frequencySort(input));
  }

  @Test
  public void testScenario2() {
    final String input = "Aabb";
    final String expectedOutput = "bbAa";

    Assert.assertEquals(expectedOutput, obj.frequencySort(input));
  }

  @Test
  public void testEmptyString() {
    final String input = "";
    final String expectedOutput = "";

    Assert.assertEquals(expectedOutput, obj.frequencySort(input));
  }

  @Test
  public void testStringWithAllUniqueCharacters() {
    final String input = "abcdefghij";
    final String expectedOutput = "abcdefghij";

    Assert.assertEquals(expectedOutput, obj.frequencySort(input));
  }
}
