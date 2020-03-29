package com.programming.practice.problems.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * <p>The digits are stored such that the most significant digit is at the head of the list, and
 * each element in the array contain a single digit.
 *
 * <p>You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer 123.
 *
 * <p>Example 2:
 *
 * <p>Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the integer 4321.
 *
 * @see <a href = "https://leetcode.com/problems/plus-one/">Plus One</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PlusOne {

  /**
   * Adds one to the integer array.
   *
   * @param digits The array of digits.
   * @return The array of digits after adding one.
   */
  public int[] plusOne(final int[] digits) {
    final List<Integer> resultInReverse = new LinkedList<>();
    int carryOver = 1;

    for (int i = digits.length - 1; i >= 0; --i) {
      int sum = digits[i] + carryOver;

      if (sum >= 10) {
        carryOver = Math.floorDiv(sum, 10);
        sum = sum % 10;
      } else {
        carryOver = 0;
      }

      resultInReverse.add(sum);
    }

    if (carryOver > 0) {
      resultInReverse.add(carryOver);
    }

    Collections.reverse(resultInReverse);

    return resultInReverse.stream().mapToInt(Integer::intValue).toArray();
  }
}
