package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link GenerateParentheses}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class GenerateParenthesesTest {

  private final GenerateParentheses obj = new GenerateParentheses();

  @Test
  public void testNEqualZero() {
    final List<String> expectedCombination = new ArrayList<>();
    Assert.assertEquals(expectedCombination, obj.generateParenthesis(0));
  }

  @Test
  public void testNEqualOne() {
    final List<String> expectedCombination = new ArrayList<>();
    expectedCombination.add("()");

    Assert.assertEquals(expectedCombination, obj.generateParenthesis(1));
  }

  @Test
  public void testNEqualTwo() {
    final List<String> expectedCombination = new ArrayList<>();
    expectedCombination.add("(())");
    expectedCombination.add("()()");

    Assert.assertEquals(expectedCombination, obj.generateParenthesis(2));
  }

  @Test
  public void testNEqualThree() {
    final List<String> expectedCombination = new ArrayList<>();
    expectedCombination.add("((()))");
    expectedCombination.add("(()())");
    expectedCombination.add("(())()");
    expectedCombination.add("()(())");
    expectedCombination.add("()()()");

    Assert.assertEquals(expectedCombination, obj.generateParenthesis(3));
  }
}
