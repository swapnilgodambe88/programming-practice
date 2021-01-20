package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued
 * number. Return the maximum valued number you could get.
 *
 * <pre>
 * Example 1:
 *
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 * Example 2:
 *
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/maximum-swap/">Maximum Swap</a>
 */
public final class MaximumSwap {

  /**
   * Returns the maximum valued number you can get.
   *
   * @param num The input number.
   * @return The maximum values number.
   */
  public int maximumSwap(final int num) {
    final List<Integer> digits = convertNumberToDigitArray(num);

    final int[] lastIndexOfDigitOccurrence = new int[10];

    for (int i = 0; i < digits.size(); ++i) {
      lastIndexOfDigitOccurrence[digits.get(i)] = i;
    }

    for (int i = 0; i < digits.size(); ++i) {
      for (int j = 9; j >= 0; --j) {
        if (digits.get(i) < j && i < lastIndexOfDigitOccurrence[j]) {
          final int temp = digits.get(i);
          digits.set(i, j);
          digits.set(lastIndexOfDigitOccurrence[j], temp);

          return convertDigitArrayToNumber(digits);
        }
      }
    }

    return num;
  }

  /**
   * Converts a list of digits back to a number e.g. {1, 7, 3, 4} -> 1734
   * @param digits A list representing the digits.
   * @return The integer representation of the number.
   */
  private int convertDigitArrayToNumber(final List<Integer> digits) {
    int sum = 0;

    for (int i = digits.size() - 1, j = 0; i >= 0 && i < digits.size(); --i, ++j) {
      sum += digits.get(i) * Math.pow(10, j);
    }
    return sum;
  }

  /**
   * Converts a number to a list of digits e.g. 1734 -> {1, 7, 3, 4}.
   * @param number The number to convert.
   * @return A list representing the digits on the number.
   */
  private List<Integer> convertNumberToDigitArray(final int number) {
    final List<Integer> digits = new ArrayList<>();

    int divident = number;
    while (divident != 0) {
      digits.add(divident % 10);
      divident = divident / 10;
    }

    Collections.reverse(digits);
    return digits;
  }
}
