package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * <p>Example 1:
 *
 * <p>Input: 123 Output: 321
 *
 * <p>Example 2:
 *
 * <p>Input: -123 Output: -321
 *
 * <p>Example 3:
 *
 * <p>Input: 120 Output: 21
 *
 * @see <a href = "https://leetcode.com/problems/reverse-integer/">Reverse Integer</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class ReverseInteger {

  public int reverse(final int inputNumber) {

    // Edge condition added for -negative min integer
    // Bounds of 32 bit integer are: -2 ^ 31 to (2 ^ 31) - 1
    // Therefore absolute value of lowest 32 bit number i.e. -2 ^ 31 goes out of bound
    if (inputNumber == Integer.MIN_VALUE) {
      return 0;
    }

    List<Integer> digitList = new ArrayList<>();

    int absoluteNumber = Math.abs(inputNumber);

    while (absoluteNumber != 0) {
      digitList.add(absoluteNumber % 10);
      absoluteNumber = Math.floorDiv(absoluteNumber, 10);
    }

    int reverseNumber = 0;
    int powerIndex = digitList.size() - 1;

    for (int digit : digitList) {

      final int temp = (int) (Math.pow(10, powerIndex--) * digit);

      // This check is to ensure that the reverseNumber is not going out of bounds for a 32 bit
      // integer
      if (reverseNumber > Integer.MAX_VALUE - temp) {
        return 0;
      }
      reverseNumber += temp;
    }

    final boolean isPositive = inputNumber == Math.abs(inputNumber);

    return isPositive ? reverseNumber : reverseNumber * -1;
  }
}
