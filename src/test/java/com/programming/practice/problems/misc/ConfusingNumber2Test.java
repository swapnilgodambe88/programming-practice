package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ConfusingNumber2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConfusingNumber2Test {

  private final ConfusingNumber2 obj = new ConfusingNumber2();

  @Test
  public void testNumber20() {
    Assert.assertEquals(6, obj.confusingNumberII(20));
  }

  @Test
  public void testNumber100() {
    Assert.assertEquals(19, obj.confusingNumberII(100));
  }

  @Test
  public void testNumber10() {
    Assert.assertEquals(3, obj.confusingNumberII(10));
  }
}
