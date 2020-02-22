package com.programming.practice.problems.misc;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 *
 * <p>Return the quotient after dividing dividend by divisor.
 *
 * <p>The integer division should truncate toward zero.
 *
 * <p>Example 1:
 *
 * <p>Input: dividend = 10, divisor = 3 Output: 3
 *
 * <p>Example 2:
 *
 * <p>Input: dividend = 7, divisor = -3 Output: -2
 *
 * @see <a href = "https://leetcode.com/problems/divide-two-integers/">Divide Two Integers</a>
 * @author Swapnil Godambe. Copyright 2020.
 * @note Failing few test cases around boundary integers on leetcode.
 */
final class DivideTwoIntegers {

  /**
   * Divide the two integers.
   *
   * @param dividend The dividend.
   * @param divisor The divisor.
   * @return The division of the two integers truncated to zero.
   */
  public int divide(final int dividend, final int divisor) {

    // Edge cases
    if (divisor == Integer.MIN_VALUE) {
      // There is no positive number > absolute value of Integer.MIN_VALUE
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    } else if (divisor == 1) {
      return dividend;
    }

    int result = 0;

    int absDividend = Math.abs(dividend);
    final int absDivisor = Math.abs(divisor);

    while (absDividend > 0 && absDividend >= absDivisor) {
      result++;
      absDividend -= absDivisor;
    }

    return result * (dividend > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);
  }
}
