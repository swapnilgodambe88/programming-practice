package com.programming.practice.problems.misc;

/**
 * Given a non-negative integer num, return the number of steps to reduce it to zero. If the current
 * number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 *
 * <p>Example 1:
 *
 * <p>Input: num = 14 Output: 6 Explanation: Step 1) 14 is even; divide by 2 and obtain 7. Step 2) 7
 * is odd; subtract 1 and obtain 6. Step 3) 6 is even; divide by 2 and obtain 3. Step 4) 3 is odd;
 * subtract 1 and obtain 2. Step 5) 2 is even; divide by 2 and obtain 1. Step 6) 1 is odd; subtract
 * 1 and obtain 0.
 *
 * @see <a href = "https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">Number
 *     of Steps to Reduce a Number to Zero</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class StepsToReduceNumberToZero {

  public int numberOfSteps(final int number) {
    int numberOfSteps = 0;
    int tempNumber = number;

    while (tempNumber > 0) {
      if (tempNumber % 2 == 0) {
        tempNumber /= 2;
      } else {
        tempNumber -= 1;
      }

      numberOfSteps++;
    }

    return numberOfSteps;
  }
}
