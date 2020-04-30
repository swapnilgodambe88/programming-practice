package com.programming.practice.problems.string;

import java.util.HashSet;
import java.util.Set;

/**
 * From any string, we can form a subsequence of that string by deleting some number of characters
 * (possibly no deletions).
 *
 * <p>Given two strings source and target, return the minimum number of subsequences of source such
 * that their concatenation equals target. If the task is impossible, return -1.
 *
 * <pre>
 * Example 1:
 *
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
 * Example 2:
 *
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.
 * Example 3:
 *
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/shortest-way-to-form-string/">Shortest Way to Form
 *     String</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ShortestWayToFormString {

  /**
   * Given two strings source and target, returns the minimum number of subsequences of source such
   * that their concatenation equals target. If the task is impossible, returns -1.
   *
   * @param source The source string.
   * @param target The target string.
   * @return The minimum number of subsequences of source such that their concatenation equals
   *     target. If the task is impossible, return -1.
   */
  public int shortestWay(final String source, final String target) {
    if (!isShortestWayPossible(source, target)) {
      return -1;
    }

    int targetIdx = 0, count = 0;

    while (targetIdx < target.length()) {
      for (int sourceIdx = 0; sourceIdx < source.length(); sourceIdx++) {
        if (targetIdx < target.length() && source.charAt(sourceIdx) == target.charAt(targetIdx))
          targetIdx++;
      }
      count++;
    }
    return count;
  }

  /**
   * Determines if the shortest way is possible or not.
   *
   * @param source The source string.
   * @param target The target string.
   * @return True If the shortest way is possible. Otherwise, false.
   */
  private boolean isShortestWayPossible(final String source, final String target) {
    final Set<Character> set = new HashSet<>();

    for (final char character : source.toCharArray()) {
      set.add(character);
    }

    for (final char character : target.toCharArray()) {
      if (!set.contains(character)) {
        return false;
      }
    }

    return true;
  }
}
