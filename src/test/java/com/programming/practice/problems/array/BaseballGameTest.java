package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BaseballGame}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class BaseballGameTest {
  private final BaseballGame obj = new BaseballGame();

  @Test
  public void testScenario1() {
    final String[] ops = new String[] {"5", "2", "C", "D", "+"};
    Assert.assertEquals(30, obj.calPoints(ops));
  }

  @Test
  public void testScenario2() {
    final String[] ops = new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"};
    Assert.assertEquals(27, obj.calPoints(ops));
  }

  @Test
  public void testScenario3() {
    final String[] ops = new String[] {"1"};
    Assert.assertEquals(1, obj.calPoints(ops));
  }
}
