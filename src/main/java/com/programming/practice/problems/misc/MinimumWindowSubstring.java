package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 *
 * <p>Example:
 *
 * <p>Input: S = "ADOBECODEBANC", T = "ABC" Output: "BANC"
 *
 * @see <a href = "https://leetcode.com/problems/minimum-window-substring/">Minimum Window
 *     Substring</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumWindowSubstring {

  /**
   * Finds the minimum window substring that contains all characters in pattern.
   *
   * @param str The input String.
   * @param pattern The pattern to match.
   * @return The minimum window substring.
   */
  public String minWindow(final String str, final String pattern) {
    if (str.length() == 0 || pattern.length() == 0) {
      return "";
    }

    final Map<Character, Integer> patternMap = getPatternMap(pattern);
    final int uniqueCharCountInPattern = patternMap.size();

    // formed is used to keep track of how many unique characters in t
    // are present in the current window in its desired frequency.
    // e.g. if t is "AABC" then the window must have two A's, one B and one C.
    // Thus formed would be = 3 when all these conditions are met.
    int formed = 0;

    // ans list of the form (window length, left, right)
    final int[] ans = new int[] {-1, 0, 0};
    final Map<Character, Integer> windowMap = new HashMap<>();

    int start = 0;
    // Loop to expand the sliding window
    for (int end = 0; end < str.length(); ++end) {
      final char character = str.charAt(end);

      final int count1 = windowMap.getOrDefault(character, 0);
      windowMap.put(character, count1 + 1);

      if (patternMap.containsKey(character)
          && windowMap.get(character).intValue() == patternMap.get(character).intValue()) {
        formed++;
      }

      // Try and contract the window till the point where it ceases to be 'desirable'.
      while (start <= end && formed == uniqueCharCountInPattern) {

        final int windowSize = end - start + 1;
        if (ans[0] == -1 || windowSize < ans[0]) {
          ans[0] = windowSize;
          ans[1] = start;
          ans[2] = end;
        }

        final char shrinkCharacter = str.charAt(start++);
        final int count2 = windowMap.get(shrinkCharacter);
        windowMap.put(shrinkCharacter, count2 - 1);

        if (patternMap.containsKey(shrinkCharacter)
            && windowMap.get(shrinkCharacter).intValue()
                < patternMap.get(shrinkCharacter).intValue()) {
          formed--;
        }
      }
    }

    return ans[0] == -1 ? "" : str.substring(ans[1], ans[2] + 1);
  }

  /**
   * Generates a map from the pattern string with key as unique characters and value as count of
   * those characters in the pattern.
   *
   * @param pattern The pattern string.
   * @return The pattern map.
   */
  private static Map<Character, Integer> getPatternMap(final String pattern) {

    final Map<Character, Integer> patternMap = new HashMap<>();

    for (final char character : pattern.toCharArray()) {
      final int count = patternMap.getOrDefault(character, 0);
      patternMap.put(character, count + 1);
    }

    return patternMap;
  }
}
