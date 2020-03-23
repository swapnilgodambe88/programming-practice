package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ReverseString}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReverseStringTest {

  private final ReverseString obj = new ReverseString();

  @Test
  public void testEmptyString() {
    final char[] inputCharArray = new char[] {};
    final char[] expectedReverseCharArray = new char[] {};

    obj.reverseString(inputCharArray);
    Assert.assertArrayEquals(expectedReverseCharArray, inputCharArray);
  }

  @Test
  public void testScenario1() {
    final char[] inputCharArray = new char[] {'h', 'e', 'l', 'l', 'o'};
    final char[] expectedReverseCharArray = new char[] {'o', 'l', 'l', 'e', 'h'};

    obj.reverseString(inputCharArray);
    Assert.assertArrayEquals(expectedReverseCharArray, inputCharArray);
  }

  @Test
  public void testScenario2() {
    final char[] inputCharArray = new char[] {'h', 'a', 'n', 'n', 'a', 'H'};
    final char[] expectedReverseCharArray = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};

    obj.reverseString(inputCharArray);
    Assert.assertArrayEquals(expectedReverseCharArray, inputCharArray);
  }
}
