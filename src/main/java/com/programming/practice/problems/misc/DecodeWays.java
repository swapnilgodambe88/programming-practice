package com.programming.practice.problems.misc;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * <pre>
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * </pre>
 *
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using
 * the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped
 * into:
 *
 * <pre>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * </pre>
 *
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is
 * different from "06".
 *
 * <p>Given a string s containing only digits, return the number of ways to decode it.
 *
 * <p>The answer is guaranteed to fit in a 32-bit integer.
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * Example 3:
 *
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 *
 * Example 4:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/decode-ways/">Decode Ways</a>
 */
public final class DecodeWays {

  /**
   * Returns the number of decoding ways for a given string.
   *
   * @param s The string representation of the number.
   * @return The number of decoding ways to decode the number.
   */
  public int numDecodings(String s) {
    // DP array to store the subproblem results.
    // DP[i] represents the decoding ways for character between [0, i -1] index
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;

    // Ways to decode a string of size 1 is 1. Unless the string is '0'.
    // '0' doesn't have a single digit decode.
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i < dp.length; i++) {
      // Check if successful single digit decode is possible.
      if (s.charAt(i - 1) != '0') {
        dp[i] = dp[i - 1];
      }

      // Check if successful two digit decode is possible.
      int twoDigit = Integer.valueOf(s.substring(i - 2, i));
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length()];
  }
}
