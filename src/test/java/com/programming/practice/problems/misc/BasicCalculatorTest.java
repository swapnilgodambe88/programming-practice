package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BasicCalculator}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class BasicCalculatorTest {
  private final BasicCalculator obj = new BasicCalculator();

  @Test
  public void testScenario1() {
    final String s = "1 + 1";
    Assert.assertEquals(2, obj.calculate(s));
  }

  @Test
  public void testScenario2() {
    final String s = " 2-1 + 2 ";
    Assert.assertEquals(3, obj.calculate(s));
  }

  @Test
  public void testScenario3() {
    final String s = "(1+(4+5+2)-3)+(6+8)";
    Assert.assertEquals(23, obj.calculate(s));
  }
}
