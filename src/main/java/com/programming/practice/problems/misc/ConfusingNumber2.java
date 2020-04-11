package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180
 * degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees,
 * they become invalid.
 *
 * <p>A confusing number is a number that when rotated 180 degrees becomes a different number with
 * each digit valid.(Note that the rotated number can be greater than the original number.)
 *
 * <p>Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 *
 * <pre>
 * Example 1:
 *
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 *
 * Example 2:
 *
 * Input: 100
 * Output: 19
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/confusing-number-ii/">Confusing number 2</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class ConfusingNumber2 {

  private final Map<Integer, Integer> mirrorMap;

  /** Constructor for {@link ConfusingNumber2}. */
  public ConfusingNumber2() {
    this.mirrorMap = new HashMap<>();

    mirrorMap.put(0, 0);
    mirrorMap.put(1, 1);
    mirrorMap.put(6, 9);
    mirrorMap.put(8, 8);
    mirrorMap.put(9, 6);
  }

  /**
   * Return the number of confusing numbers between 1 and N inclusive.
   *
   * @param N The number N.
   * @return The number of confusing numbers between 1 and N inclusive.
   */
  public int confusingNumberII(final int N) {
    int count = 0;
    for (int number = 6; number <= N; ++number) {
      if (isNumberConfusing(number)) {
        count++;
      }
    }

    return count;
  }

  /**
   * @param number The number to evaluate if it is confusing.
   * @return True If the number is confusing. Otherwise, false.
   */
  private boolean isNumberConfusing(final int number) {
    final List<Integer> digits = convertNumberToListOfDigits(number);
    final List<Integer> mirrorNumber = new ArrayList<>();

    for (final int digit : digits) {
      if (mirrorMap.containsKey(digit)) {
        mirrorNumber.add(mirrorMap.get(digit));
      } else {
        return false;
      }
    }

    Collections.reverse(mirrorNumber);
    return !digits.equals(mirrorNumber);
  }

  /**
   * Converts a number to list of digits. e.g. 899 -> [8, 9, 9].
   *
   * @param number The number to convert.
   * @return The list of digits representing the number
   */
  private static List<Integer> convertNumberToListOfDigits(final int number) {
    final List<Integer> digits = new ArrayList<>();

    int divident = number;
    while (divident > 0) {
      digits.add(divident % 10);
      divident = Math.floorDiv(divident, 10);
    }

    Collections.reverse(digits);
    return digits;
  }
}
