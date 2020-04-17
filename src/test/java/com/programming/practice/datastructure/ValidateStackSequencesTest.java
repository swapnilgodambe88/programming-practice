package com.programming.practice.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ValidateStackSequences}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ValidateStackSequencesTest {

  private final ValidateStackSequences obj = new ValidateStackSequences();

  @Test
  public void testScenario1() {
    final int[] pushed = new int[] {1, 2, 3, 4, 5};
    final int[] popped = new int[] {4, 5, 3, 2, 1};

    Assert.assertTrue(obj.validateStackSequences(pushed, popped));
  }

  @Test
  public void testScenario2() {
    final int[] pushed = new int[] {1, 2, 3, 4, 5};
    final int[] popped = new int[] {4, 3, 5, 1, 2};

    Assert.assertFalse(obj.validateStackSequences(pushed, popped));
  }

  @Test
  public void testScenario3() {
    final int[] pushed = new int[] {1, 2, 3, 4, 5};
    final int[] popped = new int[] {4, 5, 3, 2};

    Assert.assertFalse(obj.validateStackSequences(pushed, popped));
  }
}
