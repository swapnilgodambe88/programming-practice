/** */
package com.programming.practice.datastructure;

import java.util.Stack;

/**
 * @see <a href = "https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue
 *     using Stacks</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.<br>
 * @company eBay
 */
public final class ImplementQueueUsingStack {

  private final Stack<Integer> stack;

  /** Initialize your data structure here. */
  public ImplementQueueUsingStack() {
    this.stack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(final int x) {
    final Stack<Integer> tempStack = new Stack<>();

    while (!stack.isEmpty()) {
      tempStack.push(stack.pop());
    }

    stack.push(x);

    while (!tempStack.isEmpty()) {
      stack.push(tempStack.pop());
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return stack.pop();
  }

  /** Get the front element. */
  public int peek() {
    return stack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.isEmpty();
  }
}
