package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a number N, return true if and only if it is a confusing number, which satisfies the
 * following condition:
 *
 * <p>We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180
 * degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees,
 * they become invalid. A confusing number is a number that when rotated 180 degrees becomes a
 * different number with each digit valid.
 *
 * <pre>
 * Example 1:
 * Input: 6
 * Output: true
 * Explanation:
 * We get 9 after rotating 6, 9 is a valid number and 9!=6.
 *
 * Example 2:
 * Input: 89
 * Output: true
 * Explanation:
 * We get 68 after rotating 89, 86 is a valid number and 86!=89.
 *
 * Example 3:
 * Input: 11
 * Output: false
 * Explanation:
 * We get 11 after rotating 11, 11 is a valid number but the value remains the same, thus 11 is not a confusing number.
 *
 * Example 4:
 * Input: 25
 * Output: false
 * Explanation:
 * We get an invalid number after rotating 25.
 *
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/confusing-number/">Confusing Number</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ConfusingNumber {

  private final Map<Integer, Integer> mirrorMap;

  /** Constructor for {@link ConfusingNumber2}. */
  public ConfusingNumber() {
    this.mirrorMap = new HashMap<>();

    mirrorMap.put(0, 0);
    mirrorMap.put(1, 1);
    mirrorMap.put(6, 9);
    mirrorMap.put(8, 8);
    mirrorMap.put(9, 6);
  }

  /**
   * Determines if the number is confusing or not.
   *
   * @param number The number to evaluate if it is confusing.
   * @return True If the number is confusing. Otherwise, false.
   */
  public boolean confusingNumber(final int number) {
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
