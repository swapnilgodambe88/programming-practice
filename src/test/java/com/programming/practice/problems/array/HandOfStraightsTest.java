package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link HandOfStraights}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class HandOfStraightsTest {

  private final HandOfStraights obj = new HandOfStraights();

  @Test
  public void testScenario1() {
    final int[] hand = new int[] {1, 2, 3, 6, 2, 3, 4, 7, 8};
    final int W = 3;

    Assert.assertTrue(obj.isNStraightHand(hand, W));
  }

  @Test
  public void testScenario2() {
    final int[] hand = new int[] {1, 2, 3, 4, 5};
    final int W = 4;

    Assert.assertFalse(obj.isNStraightHand(hand, W));
  }

  @Test
  public void testScenario3() {
    final int[] hand = new int[] {1, 2, 4, 7, 9};
    final int W = 4;

    Assert.assertFalse(obj.isNStraightHand(hand, W));
  }
}
