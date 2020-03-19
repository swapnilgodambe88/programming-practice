/** */
package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link JumpGame}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class JumpGameTest {

  private final JumpGame obj = new JumpGame();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {2, 3, 1, 1, 4};

    Assert.assertTrue(obj.canJump_recursive(nums));
    Assert.assertTrue(obj.canJump_nonRecursive(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {3, 2, 1, 0, 4};

    Assert.assertFalse(obj.canJump_recursive(nums));
    Assert.assertFalse(obj.canJump_nonRecursive(nums));
  }
}
