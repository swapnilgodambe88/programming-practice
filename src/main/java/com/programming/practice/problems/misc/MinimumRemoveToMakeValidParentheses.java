package com.programming.practice.problems.misc;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * <p>Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so
 * that the resulting parentheses string is valid and return any valid string.
 *
 * <ul>
 *   Formally, a parentheses string is valid if and only if:
 *   <li>It is the empty string, contains only lowercase characters, or
 *   <li>It can be written as AB (A concatenated with B), where A and B are valid strings, or
 *   <li>It can be written as (A), where A is a valid string.
 * </ul>
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 *
 * Example 2:
 *
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Example 3:
 *
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/">Minimum
 *     Remove to Make Valid Parentheses</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumRemoveToMakeValidParentheses {

  /**
   * Removes the minimum number of parentheses ( '(' or ')', in any positions ) so that the
   * resulting parentheses string is valid and return any valid string.
   *
   * @param inputString The input String.
   * @return The valid string after removing minimum number of parentheses.
   */
  public String minRemoveToMakeValid(final String inputString) {
    // A set to keep track of invalid index positions of parentheses.
    final Set<Integer> invalidPosition = new HashSet<>();
    final Stack<Integer> stack = new Stack<>();

    int counter = 0;
    for (final char character : inputString.toCharArray()) {
      if (character == '(') {
        stack.push(counter);
      } else if (character == ')') {
        if (stack.isEmpty()) {
          // if stack is empty means there is no matching '(' for the current ')'
          invalidPosition.add(counter);
        } else {
          stack.pop();
        }
      }

      ++counter;
    }

    // if stack contains '(' means they are invalid opening '(' without matching ')'
    while (!stack.isEmpty()) {
      invalidPosition.add(stack.pop());
    }

    final StringBuffer validString = new StringBuffer();
    for (int i = 0; i < inputString.length(); ++i) {
      if (!invalidPosition.contains(i)) {
        validString.append(inputString.charAt(i));
      }
    }

    return validString.toString();
  }
}
