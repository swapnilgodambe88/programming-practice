package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RotateString}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RotateStringTest {

  private final RotateString obj = new RotateString();

  @Test
  public void testEmptyString() {
    final String string1 = "";
    final String string2 = "";

    Assert.assertTrue(obj.rotateString1(string1, string2));
    Assert.assertTrue(obj.rotateString2(string1, string2));
  }

  @Test
  public void testScenario1() {
    final String string1 = "abcde";
    final String string2 = "cdeab";

    Assert.assertTrue(obj.rotateString1(string1, string2));
    Assert.assertTrue(obj.rotateString2(string1, string2));
  }

  @Test
  public void testScenario2() {
    final String string1 = "abcdet";
    final String string2 = "cdeab";

    Assert.assertFalse(obj.rotateString1(string1, string2));
    Assert.assertFalse(obj.rotateString2(string1, string2));
  }
}
