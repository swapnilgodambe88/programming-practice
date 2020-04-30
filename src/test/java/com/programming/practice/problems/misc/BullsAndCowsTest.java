package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BullsAndCows}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BullsAndCowsTest {

  private final BullsAndCows obj = new BullsAndCows();

  @Test
  public void testScenario1() {
    final String secret = "1807";
    final String guess = "7810";

    Assert.assertEquals("1A3B", obj.getHint(secret, guess));
  }

  @Test
  public void testScenario2() {
    final String secret = "1807";
    final String guess = "1807";

    Assert.assertEquals("4A0B", obj.getHint(secret, guess));
  }

  @Test
  public void testScenario3() {
    final String secret = "1887";
    final String guess = "1888";

    Assert.assertEquals("3A0B", obj.getHint(secret, guess));
  }

  @Test
  public void testScenario4() {
    final String secret = "5678";
    final String guess = "1234";

    Assert.assertEquals("0A0B", obj.getHint(secret, guess));
  }

  @Test
  public void testScenario5() {
    final String secret = "1234";
    final String guess = "4321";

    Assert.assertEquals("0A4B", obj.getHint(secret, guess));
  }
}
