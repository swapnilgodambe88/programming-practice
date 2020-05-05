package com.programming.practice.problems.string;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence
 * of W.
 *
 * <p>If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such minimum-length windows, return the one with the left-most starting
 * index.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/minimum-window-subsequence/">Minimum Window
 *     Subsequence</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class MinimumWindowSubsequence {

  /**
   * Finds the minimum window subsequence
   *
   * @param S The S string.
   * @param T The pattern string.
   * @return The minimum window subsequence.
   */
  public String minWindow(final String S, final String T) {
    final char startingTCharacter = T.charAt(0);
    String minimumWindow = "";

    for (int i = 0; i < S.length(); ++i) {
      if (S.charAt(i) == startingTCharacter) {
        final String subSequence = subSequence(S, T, i);
        if (minimumWindow.isEmpty()
            || (!subSequence.isEmpty() && subSequence.length() < minimumWindow.length())) {
          minimumWindow = subSequence;
        }
      }
    }

    return minimumWindow;
  }

  /**
   * Given a starting index of S, this function tries to find subsequence.
   *
   * @param S The S string.
   * @param T The pattern string.
   * @param sIndexStart The start index on string S.
   * @return The subsequence if exists. Otherwise returns empty string.
   */
  private static String subSequence(final String S, final String T, final int sIndexStart) {
    int tIndex = 0;
    int sIndexEnd = sIndexStart;

    while (sIndexEnd < S.length() && tIndex < T.length()) {
      if (S.charAt(sIndexEnd) == T.charAt(tIndex)) {
        tIndex++;
      }

      sIndexEnd++;
    }

    return tIndex == T.length() ? S.substring(sIndexStart, sIndexEnd) : "";
  }
}
