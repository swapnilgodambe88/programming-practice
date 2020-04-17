package com.programming.practice.datastructure;

import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could
 * have been the result of a sequence of push and pop operations on an initially empty stack.
 *
 * <pre>
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/validate-stack-sequences/">Validate Stack
 *     Sequences</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ValidateStackSequences {

  /**
   * Given two sequences pushed and popped with distinct values, return true if and only if this
   * could have been the result of a sequence of push and pop operations on an initially empty
   * stack.
   *
   * @param pushed The sequence of push operations.
   * @param popped The sequence of pop operations
   * @return True If and only if this could have been the result of a sequence of push and pop
   *     operations on an initially empty stack.
   */
  public boolean validateStackSequences(final int[] pushed, final int[] popped) {

    final Stack<Integer> stack = new Stack<>();
    int pushIndex = 0, popIndex = 0;

    while (pushIndex < pushed.length && popIndex < popped.length) {

      // Pop is only possible is stack top matches the pop sequence
      if (!stack.isEmpty() && stack.peek().intValue() == popped[popIndex]) {
        stack.pop();
        popIndex++;
      } else {
        stack.push(pushed[pushIndex++]);
      }
    }

    // If elements are still present on push means stack is invalid
    if (pushIndex < pushed.length) {
      return false;
    }

    while (!stack.isEmpty()) {
      final int poppedValue = stack.pop();

      // No elements on popped are present or if pop sequence doesn't match stack's popped element
      // means stack is invalid
      if (popIndex >= popped.length || poppedValue != popped[popIndex]) {
        return false;
      }
      popIndex++;
    }

    return true;
  }
}
