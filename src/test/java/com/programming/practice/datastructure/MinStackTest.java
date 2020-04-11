package com.programming.practice.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinStack}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinStackTest {

  @Test
  public void testScenario1() {
    final MinStack minStack = new MinStack();

    minStack.push(-2);
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(-2, minStack.top());

    minStack.push(0);
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(0, minStack.top());

    minStack.push(-3);
    Assert.assertEquals(-3, minStack.getMin());
    Assert.assertEquals(-3, minStack.top());

    minStack.pop();
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(0, minStack.top());
  }

  @Test
  public void testScenario2() {
    final MinStack minStack = new MinStack();

    minStack.push(-2);
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(-2, minStack.top());

    minStack.push(0);
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(0, minStack.top());

    minStack.push(-1);
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(-1, minStack.top());

    minStack.pop();
    Assert.assertEquals(-2, minStack.getMin());
    Assert.assertEquals(0, minStack.top());
  }
}
