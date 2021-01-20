package com.programming.practice.problems.array;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a
 * palindrome.
 *
 * <pre>
 * Example 1:
 *
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/valid-palindrome-ii/">Valid Palindrome II</a>
 */
public final class ValidPalindrome2 {

  /**
   * Given a non-empty string s, you may delete at most one character. Judge whether you can make it
   * a palindrome.
   *
   * @param s The string to check for palindrome.
   * @return True If we can make s a palindrome.
   */
  public boolean validPalindrome(final String s) {
    int startIndex = 0;
    int endIndex = s.length() - 1;

    while (startIndex < endIndex) {
      if (s.charAt(startIndex) != s.charAt(endIndex)) {
        return isPalindrome(s, startIndex + 1, endIndex)
            || isPalindrome(s, startIndex, endIndex - 1);
      }
      ++startIndex;
      --endIndex;
    }

    return true;
  }

  /**
   * Validates if string s is palindrome or not between start and end index.
   *
   * @param s The string to validate for palindrome.
   * @param startIndex The start index.
   * @param endIndex The end index.
   * @return True If string is palindrome. False, otherwise.
   */
  private boolean isPalindrome(final String s, int startIndex, int endIndex) {
    while (startIndex < endIndex) {
      if (s.charAt(startIndex) != s.charAt(endIndex)) {
        return false;
      }

      ++startIndex;
      --endIndex;
    }

    return true;
  }
}
