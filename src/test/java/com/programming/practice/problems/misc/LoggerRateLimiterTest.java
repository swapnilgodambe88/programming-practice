package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LoggerRateLimiter}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LoggerRateLimiterTest {

  private final LoggerRateLimiter obj = new LoggerRateLimiter();

  @Test
  public void testShouldPrintMessage() {

    Assert.assertTrue(obj.shouldPrintMessage(1, "foo"));
    Assert.assertTrue(obj.shouldPrintMessage(2, "bar"));
    Assert.assertFalse(obj.shouldPrintMessage(3, "foo"));
    Assert.assertFalse(obj.shouldPrintMessage(8, "bar"));
    Assert.assertFalse(obj.shouldPrintMessage(10, "foo"));
    Assert.assertTrue(obj.shouldPrintMessage(11, "foo"));
  }
}
