package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link AddBinary}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class AddBinaryTest {

  private final AddBinary obj = new AddBinary();

  @Test
  public void testScenario1() {
    Assert.assertEquals("100", obj.addBinary("11", "1"));
  }

  @Test
  public void testScenario2() {
    Assert.assertEquals("10101", obj.addBinary("1010", "1011"));
  }

  @Test
  public void testScenario3() {
    Assert.assertEquals("10000", obj.addBinary("1111", "1"));
  }
}
