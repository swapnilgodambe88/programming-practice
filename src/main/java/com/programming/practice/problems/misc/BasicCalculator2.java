package com.programming.practice.problems.misc;

import java.util.LinkedList;
import java.util.List;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * <p>The expression string contains only non-negative integers, +, -, *, / operators and empty
 * spaces . The integer division should truncate toward zero.
 *
 * <pre>
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 *
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 *
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/basic-calculator-ii/">Basic Calculator 2</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BasicCalculator2 {

  /**
   * Evaluates a simple expression string (Approach 2).
   *
   * <ul>
   *   <li>We use a variable lastNumber to track the value of the last evaluated expression.
   *   <li>If the operation is Addition (+) or Subtraction (-), add the lastNumber to the result
   *       instead of pushing it to the stack (or adding it to the result). The currentNumber would
   *       be updated to lastNumber for the next iteration.
   *   <li>If the operation is Multiplication (*) or Division (/), we must evaluate the expression
   *       lastNumber * currentNumber and update the lastNumber with the result of the expression.
   *       This would be added to the result after the entire string is scanned.
   * </ul>
   *
   * @param s The string to evaluate.
   * @return The evaluated expression string.
   */
  public static int calculate_approach2(final String s) {
    // To keep track of the result calculated as we traverse the string.
    int result = 0;

    // Keep track of the last operand constructed while traversing the string.
    int lastOperand = 0;

    // Keep track of constructing the current number as we traverse the string with multiple digits.
    int currentNumber = 0;

    // Keeps track of the last sign evaluated
    char lastSign = '+';

    for (int i = 0; i < s.length(); ++i) {
      final char character = s.charAt(i);

      if (Character.isDigit(character)) {
        currentNumber = (currentNumber * 10) + (character - '0');
      }

      // This else if is also applicable when evaluating the last operand (or last character). This
      // will save the
      // currentNumber to lastOperand before exiting the for loop
      // NOTE: This shouldn't be a else if but the last operand needs to go through
      // both the if conditions
      if (character == '+'
          || character == '-'
          || character == '*'
          || character == '/'
          || i == s.length() - 1) {
        switch (lastSign) {
          case '+':
          case '-':
            result += lastOperand;
            lastOperand = (lastSign == '+') ? currentNumber : -currentNumber;
            break;
          case '*':
            lastOperand = lastOperand * currentNumber;
            break;
          case '/':
            // NOTE: Math.floorDiv won't work if last operand is negative, since floorDiv gets the
            // result closest to positive integer
            lastOperand = lastOperand / currentNumber;
            break;
        }

        currentNumber = 0;
        lastSign = character;
      }
    }

    result += lastOperand;

    return result;
  }

  /**
   * Evaluates a simple expression string (Approach 1).
   *
   * @param s The string to evaluate.
   * @return The evaluated expression string.
   */
  public int calculate_approach1(final String s) {
    final List<Integer> numberList = new LinkedList<>();
    final List<Character> operatorList = new LinkedList<>();

    // CurrentNumber keeps track of the combining the digits and forming a number out of it.
    int currentNumber = 0;
    for (final char character : s.toCharArray()) {
      if (Character.isDigit(character)) {
        currentNumber = (currentNumber * 10) + (character - '0');
      } else if (character == '+' || character == '-' || character == '*' || character == '/') {
        numberList.add(currentNumber);
        currentNumber = 0;
        operatorList.add(character);
      }

      // By default all white spaces will be ignored.
    }

    // Add the end number to the numberList.
    numberList.add(currentNumber);

    // Evaluate the expression for multiplication and division
    for (int i = 0; i < operatorList.size(); ++i) {
      final char operator = operatorList.get(i);

      if (operator == '*' || operator == '/') {
        final int operand1 = numberList.get(i);
        final int operand2 = numberList.get(i + 1);

        final int result = evaluate(operand1, operand2, operator);
        numberList.set(i, result);
        numberList.remove(i + 1);
        operatorList.remove(i);
        --i;
      }
    }

    // Evaluate the expression for addition and subtraction
    for (int i = 0; i < operatorList.size(); ++i) {
      final char operator = operatorList.get(i);
      final int operand1 = numberList.get(i);
      final int operand2 = numberList.get(i + 1);

      final int result = evaluate(operand1, operand2, operator);
      numberList.set(i, result);
      numberList.remove(i + 1);
      operatorList.remove(i);
      --i;
    }

    return numberList.get(0);
  }

  /**
   * Evaluates the expression by applying the operator to both the operands.
   *
   * @param operand1 The operand 1.
   * @param operand2 The operand 2.
   * @param operator The operator.
   * @return The evaluated expression.
   */
  private int evaluate(final int operand1, final int operand2, final char operator) {
    if (operator == '+') {
      return operand1 + operand2;
    }

    if (operator == '-') {
      return operand1 - operand2;
    }

    if (operator == '*') {
      return operand1 * operand2;
    }

    return Math.floorDiv(operand1, operand2);
  }
}
