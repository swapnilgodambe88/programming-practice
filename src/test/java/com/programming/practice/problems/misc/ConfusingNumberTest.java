package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ConfusingNumber}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConfusingNumberTest {

  private final ConfusingNumber obj = new ConfusingNumber();

  @Test
  public void testNumber6() {
    Assert.assertTrue(obj.confusingNumber(6));
  }

  @Test
  public void testNumber89() {
    Assert.assertTrue(obj.confusingNumber(89));
  }

  @Test
  public void testNumber25() {
    Assert.assertFalse(obj.confusingNumber(25));
  }

  @Test
  public void testNumber88() {
    Assert.assertFalse(obj.confusingNumber(88));
  }

  @Test
  public void testNumber811() {
    Assert.assertTrue(obj.confusingNumber(881));
  }
}
