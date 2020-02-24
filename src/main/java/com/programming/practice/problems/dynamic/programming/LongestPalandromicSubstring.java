package com.programming.practice.problems.dynamic.programming;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 *
 * <p>Example 1:
 *
 * <p>Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 *
 * <p>Example 2:
 *
 * <p>Input: "cbbd" Output: "bb"
 *
 * @see <a href = "https://leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic
 *     Substring</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LongestPalandromicSubstring {

  /**
   * Helper function to determine if given input string is palindrome or not.
   *
   * @param inputString The input string to evaluate.
   * @return True if inputString is palindrome, otherwise return false.
   */
  private boolean isPalindrom(final String inputString) {

    final char[] inputCharArray = inputString.toCharArray();

    int startIndex = 0, endIndex = inputString.length() - 1;

    while (startIndex <= endIndex) {
      if (inputCharArray[startIndex] != inputCharArray[endIndex]) {
        return false;
      }

      startIndex++;
      endIndex--;
    }
    return true;
  }

  public String longestPalindrome(final String inputString) {
    String answer = "";

    final char[] inputCharArray = inputString.toCharArray();

    for (int i = 0; i < inputString.length(); i++) {

      String tempString = "";
      for (int j = i; j < inputString.length(); j++) {
        tempString += inputCharArray[j];

        if (isPalindrom(tempString) && tempString.length() > answer.length()) {
          answer = tempString;
        }
      }
    }
    return answer;
  }

  public String longestPalindromeUsingDynamicProgramming(final String inputString) {

    // isPalindromeArray (i, j) is true if String from index i to index j is palindrome. Otherwise
    // false
    boolean[][] isPalindromeArray = new boolean[inputString.length()][inputString.length()];

    String answer = "";

    for (int end = 0; end < inputString.length(); end++) {
      for (int start = 0; start <= end; start++) {

        final int lengthOfCurrentString = end - start + 1;

        // #1 Single character is always a palindrome
        // #2 Word of length 2 is always a palindrome if both characters are same
        // #3 String(i, j) is palindrome if char[i] == char[j] & String (i + 1, j - 1) is palindrome

        if (end == start
            || // #1
            (lengthOfCurrentString == 2 && inputString.charAt(end) == inputString.charAt(start))
            || // #2
            inputString.charAt(end) == inputString.charAt(start)
                && isPalindromeArray[start + 1][end - 1]) // #3
        {
          isPalindromeArray[start][end] = true;
        } else {
          isPalindromeArray[start][end] = false;
        }

        if (isPalindromeArray[start][end] && lengthOfCurrentString > answer.length()) {
          answer = inputString.substring(start, end + 1);
        }
      }
    }

    return answer;
  }
}
