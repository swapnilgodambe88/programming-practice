package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LengthOfLastWord}
 *
 * @author Swapnil Godambe.<br>
 *     * Copyright 2024.
 */
public final class LengthOfLastWordTest {

  private final LengthOfLastWord obj = new LengthOfLastWord();

  @Test
  public void testScenario1() {
    final String s = "luffy is still joyboy";
    Assert.assertEquals(6, obj.lengthOfLastWord(s));
  }

  @Test
  public void testScenario2() {
    final String s = "Hello World";
    Assert.assertEquals(5, obj.lengthOfLastWord(s));
  }

  @Test
  public void testStringWithTrailingSpaces() {
    final String s = "   fly me   to   the moon  ";
    Assert.assertEquals(4, obj.lengthOfLastWord(s));
  }

  @Test
  public void testEmptyStringInput() {
    final String s = "";
    Assert.assertEquals(0, obj.lengthOfLastWord(s));
  }
}
