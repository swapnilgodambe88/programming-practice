package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ValidParentheses}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class ValidParenthesesTest {

  private final ValidParentheses obj = new ValidParentheses();

  @Test
  public void testEmptyString() {
    Assert.assertTrue(obj.isValid(""));
  }

  @Test
  public void testSingleOpeningParentheses() {
    Assert.assertFalse(obj.isValid("("));
  }

  @Test
  public void testSingleClosingParentheses() {
    Assert.assertFalse(obj.isValid(")"));
  }

  @Test
  public void testValidParentheses1() {
    Assert.assertTrue(obj.isValid("()"));
  }

  @Test
  public void testValidParentheses2() {
    Assert.assertTrue(obj.isValid("()[]{}"));
  }

  @Test
  public void testValidParentheses3() {
    Assert.assertTrue(obj.isValid("{[]}"));
  }

  @Test
  public void testInvalidValidParentheses1() {
    Assert.assertFalse(obj.isValid("(]"));
  }

  @Test
  public void testInvalidValidParentheses2() {
    Assert.assertFalse(obj.isValid("([)]"));
  }
}
