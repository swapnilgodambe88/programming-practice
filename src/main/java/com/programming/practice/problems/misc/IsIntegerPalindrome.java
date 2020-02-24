package com.programming.practice.problems.misc;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same
 * backward as forward.
 *
 * <p>Example 1:
 *
 * <p>Input: 121 Output: true
 *
 * <p>Example 2:
 *
 * <p>Input: -121 Output: false
 *
 * <p>Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore
 * it is not a palindrome.
 *
 * <p>Example 3:
 *
 * <p>Input: 10 Output: false
 *
 * <p>Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * @see <a href = "https://leetcode.com/problems/palindrome-number/">Palindrome Number</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class IsIntegerPalindrome {

  public boolean isPalindrome(final int inputNumber) {

    if (inputNumber < 0) {
      return false;
    }

    final ReverseInteger obj = new ReverseInteger();
    return inputNumber == obj.reverse(inputNumber);
  }
}
