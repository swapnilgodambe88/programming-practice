package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumRemoveToMakeValidParentheses}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumRemoveToMakeValidParenthesesTest {

  private final MinimumRemoveToMakeValidParentheses obj = new MinimumRemoveToMakeValidParentheses();

  @Test
  public void testScenario1() {
    final String inputString = "lee(t(c)o)de)";

    Assert.assertEquals("lee(t(c)o)de", obj.minRemoveToMakeValid(inputString));
  }

  @Test
  public void testScenario2() {
    final String inputString = "a)b(c)d";

    Assert.assertEquals("ab(c)d", obj.minRemoveToMakeValid(inputString));
  }

  @Test
  public void tcestScenario3() {
    final String inputString = "))((";

    Assert.assertEquals("", obj.minRemoveToMakeValid(inputString));
  }

  @Test
  public void testScenario4() {
    final String inputString = "(a(b(c)d)";

    Assert.assertEquals("a(b(c)d)", obj.minRemoveToMakeValid(inputString));
  }
}
