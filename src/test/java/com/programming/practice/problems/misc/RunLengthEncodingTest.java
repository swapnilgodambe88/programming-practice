package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RunLengthEncoding}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RunLengthEncodingTest {

  @Test
  public void testClass() {
    final RunLengthEncoding obj = new RunLengthEncoding("hello");

    final String expectedToString =
        "inputString: hello | characters : [h, e, l, o] | counts: [1, 1, 2, 1]";

    final List<Character> expectedCharacters = Arrays.asList('h', 'e', 'l', 'o');
    final List<Integer> expectedCounts = Arrays.asList(1, 1, 2, 1);

    Assert.assertEquals(expectedCharacters, obj.characters);
    Assert.assertEquals(expectedCounts, obj.counts);
    Assert.assertEquals(expectedToString, obj.toString());
  }
}
