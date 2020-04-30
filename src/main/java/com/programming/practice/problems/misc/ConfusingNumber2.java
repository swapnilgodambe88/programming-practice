package com.programming.practice.problems.misc;

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

  /**
   * Return the number of confusing numbers between 1 and N inclusive.
   *
   * @param N The number N.
   * @return The number of confusing numbers between 1 and N inclusive.
   */
  public int confusingNumberII(final int N) {
    int count = 0;
    final ConfusingNumber obj = new ConfusingNumber();

    for (int number = 6; number <= N; ++number) {
      if (obj.confusingNumber(number)) {
        count++;
      }
    }

    return count;
  }
}
