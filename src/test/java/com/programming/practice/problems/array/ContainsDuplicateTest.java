package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ContainsDuplicate}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ContainsDuplicateTest {

  private final ContainsDuplicate obj = new ContainsDuplicate();

  @Test
  public void testContainsDuplicate() {
    final int[] nums = new int[] {1, 2, 3, 1};

    Assert.assertTrue(obj.containsDuplicate(nums));
  }

  @Test
  public void testDoesNotContainsDuplicate() {
    final int[] nums = new int[] {1, 2, 3, 4};

    Assert.assertFalse(obj.containsDuplicate(nums));
  }
}
