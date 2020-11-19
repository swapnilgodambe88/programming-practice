package com.programming.practice.problems.misc;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * <p>A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
 * is a subsequence that is common to both strings. If there is no common subsequence, return 0.
 *
 * <pre>
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 *
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 *
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/longest-common-subsequence/">Longest Common
 *     Subsequence</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LongestCommonSubsequence {

  /**
   * Returns the length of longest common subsequence.
   *
   * @param text1 The text 1 string.
   * @param text2 The text 2 string.
   * @return The length of the longest common subsequence.
   * @see <a href="https://www.youtube.com/watch?v=NnD96abizww">Longest Common Subsequence - Tushar
   *     Roy</a>
   */
  public int longestCommonSubsequence(final String text1, final String text2) {
    if (text1.length() == 0 || text2.length() == 0) {
      return 0;
    }

    // Create a DP with one extra column and one extra row such that top row and left column will be
    // all zeros. dp[i + 1][j + 1] corresponds to text1[i] & text2[j] characters being evaluated.
    final int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 0; i < text1.length(); ++i) {
      for (int j = 0; j < text2.length(); ++j) {

        // If both the characters are equal, then grab the value from diagonal-left cell of the dp
        // and add 1 to it
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          // If both the character are not same, then get the max of upper dp and left dp cell
          final int surroundingMax = Math.max(dp[i][j + 1], dp[i + 1][j]);
          dp[i + 1][j + 1] = surroundingMax;
        }
      }
    }
    return dp[text1.length()][text2.length()];
  }
}
