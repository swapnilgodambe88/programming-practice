package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DecodeWays}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class DecodeWaysTest {
  private final DecodeWays obj = new DecodeWays();

  @Test
  public void testScenario1() {
    Assert.assertEquals(2, obj.numDecodings("12"));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals(3, obj.numDecodings("226"));
  }

  @Test
  public void testZero() {
    Assert.assertEquals(0, obj.numDecodings("0"));
  }

  @Test
  public void testScenario3() {
    // "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
    Assert.assertEquals(0, obj.numDecodings("06"));
  }
}
