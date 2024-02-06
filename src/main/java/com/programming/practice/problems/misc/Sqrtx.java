package com.programming.practice.problems.misc;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * <p>You must not use any built-in exponent function or operator.
 *
 * <p>For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * <pre>
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/sqrtx/description/">Sqrt(x)</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class Sqrtx {

  /**
   * Given a non-negative integer x, return the square root of x rounded down to the nearest
   * integer. The returned integer should be non-negative as well.
   *
   * @param x The Input x.
   * @return The square root of x rounded down to the nearest integer.
   */
  public int mySqrt(final int x) {
    // We use long to guard against overflow error which can happen during Math.ceilDiv(lb + ub, 2)
    // calculation
    long sqrt = x, lb = 0, ub = x;

    while (lb <= ub) {
      sqrt = Math.ceilDiv(lb + ub, 2);
      if (sqrt * sqrt == x || (sqrt * sqrt < x && (sqrt + 1) * (sqrt + 1) > x)) {
        return (int) sqrt;
      } else if (sqrt * sqrt < x) {
        lb = sqrt;
      } else {
        ub = sqrt;
      }
    }

    return -1;
  }
}
