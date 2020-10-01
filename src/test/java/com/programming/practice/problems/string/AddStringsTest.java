package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link AddStrings}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class AddStringsTest {

  private final AddStrings obj = new AddStrings();

  @Test
  public void testScenario1() {
    Assert.assertEquals("10", obj.addStrings("8", "2"));
  }

  @Test
  public void testZeroAddition() {
    Assert.assertEquals("0", obj.addStrings("0", "0"));
  }
}
