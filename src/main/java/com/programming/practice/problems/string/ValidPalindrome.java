package com.programming.practice.problems.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 *
 * <p>Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * <pre>
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/valid-palindrome/">Valid Palindrome</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class ValidPalindrome {

  /**
   * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
   * ignoring cases.
   *
   * @param s The string to evaluate.
   * @return True If palindrome. Otherwise, false.
   */
  public boolean isPalindrome(final String s) {

    int start = 0, end = s.length() - 1;
    while (start <= end) {

      // Forward start to alpha numeric character
      while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
        ++start;
      }

      // Rewind end to alpha numeric character
      while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
        --end;
      }

      if (start <= end
          && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
        return false;
      }
      ++start;
      --end;
    }

    return true;
  }
}
