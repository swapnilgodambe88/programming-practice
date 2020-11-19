package com.programming.practice.problems.misc;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * <p>The expression string may contain open ( and closing parentheses ), the plus + or minus sign
 * -, non-negative integers and empty spaces .
 *
 * <pre>
 * Example 1:
 *
 * Input: "1 + 1"
 * Output: 2
 *
 * Example 2:
 *
 * Input: " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 *
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * </pre>
 *
 * <p>* @see <a href = "https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class BasicCalculator {

  /**
   * Evaluates a simple expression string.
   *
   * @param s The string to evaluate.
   * @return The result of the evaluated string.
   */
  public int calculate(final String s) {

    // Stack to keep track of expressions wrapped around opening closing brackets.
    final Stack<Integer> stack = new Stack<>();

    // To keep track of the result calculated as we traverse the string.
    int result = 0;

    // Keep track of the last operand constructed while traversing the string.
    int lastOperand = 0;

    // Keeps track of the last sign evaluated
    int lastSign = 1;

    for (int i = 0; i < s.length(); ++i) {
      final char character = s.charAt(i);

      if (Character.isDigit(character)) {
        lastOperand = 10 * lastOperand + (character - '0');
      } else if (character == '+' || character == '-') {
        // Evaluate the expression to the left
        result += lastSign * lastOperand;

        // Save off the latest sign.
        lastSign = (character == '+') ? 1 : -1;

        // Reset last operand
        lastOperand = 0;
      } else if (character == '(') {
        stack.push(result);
        stack.push(lastSign);

        // Reset the sign and the operand
        lastSign = 1;
        result = 0;
      } else if (character == ')') {
        // Evaluate the expression to the left
        result += lastSign * lastOperand;

        // ')' marks end of expression within a set of parenthesis
        // Its result is multiplied with sign on top of stack
        // as stack.pop() is the sign before the parenthesis
        result *= stack.pop();

        // Then add to the next operand on the top.
        // as stack.pop() is the result calculated before this parenthesis
        // (operand on stack) + (sign on stack * (result from parenthesis))
        result += stack.pop();

        // Reset the operand
        lastOperand = 0;
      }
    }
    result += lastSign * lastOperand;
    return result;
  }
}
