package com.programming.practice.datastructure;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.<br>
 * pop() -- Removes the element on top of the stack.<br>
 * top() -- Get the top element.<br>
 * getMin() -- Retrieve the minimum element in the stack.<br>
 *
 * <pre>
Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/min-stack/">Min Stack</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class MinStack {

  /**
   * A stack to maintain the order of elements inserted and also the minimum at every insert.
   */
  private final Stack<int[]> stack;

  /**
   * Public constructor for {@link MinStack}.
   */
  public MinStack() {
    this.stack = new Stack<>();
  }

  /**
   * Pushes the element on the top of the stack.
   *
   * @param x The element that needs to be pushed onto stack.
   */
  public void push(final int x) {
    if (stack.isEmpty() || x <= getMin()) {
      stack.push(new int[] {x, x});
    } else {
      final int minSoFar = getMin();
      stack.push(new int[] {x, minSoFar});
    }
  }

  /**
   * Removes the element from the top of stack.
   *
   * @throws UnsupportedOperationException If pop operation is performed on an empty stack.
   */
  public void pop() {
    stack.pop();
  }

  /**
   * @return The element at the top of the stack without removing it.
   */
  public int top() {
    return stack.peek()[0];
  }

  /**
   * @return The minimum element on the stack in O(1) runtime complexity.
   */
  public int getMin() {
    return stack.peek()[1];
  }
}
