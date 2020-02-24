package com.programming.practice.problems.string;

/**
 * Implement strStr().
 *
 * <p>Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 *
 * <p>Example 1:
 *
 * <p>Input: haystack = "hello", needle = "ll" Output: 2
 *
 * <p>Example 2:
 *
 * <p>Input: haystack = "aaaaa", needle = "bba" Output: -1
 *
 * @see <a href = "https://leetcode.com/problems/implement-strstr/">Implement strStr()</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ImplementStrStr {

  /**
   * Searches if the needle is present in the haystack with starting position as startIndex.
   *
   * @param startIndex The startIndex from where search needs to be started.
   * @param haystackArray The haystack array.
   * @param needleArray The needle array.
   * @return True If needle found in haystack at startIndex. Otherwise false.
   */
  private boolean foundNeedle(
      final int startIndex, final char[] haystackArray, final char[] needleArray) {

    int j = 0;
    // i keeps track of haystackarray & j keeps track of needlearray
    for (int i = startIndex; i < haystackArray.length && j < needleArray.length; ++i, ++j) {
      if (haystackArray[i] != needleArray[j]) {
        return false;
      }
    }

    // for needle to be present j should completely traverse the needleArray
    return j == needleArray.length;
  }

  /**
   * @param haystack The haystack string.
   * @param needle The needle string to find.
   * @return The index of the first occurrence of the needle in haystack. -1 if needle not found.
   */
  public int strStr(final String haystack, final String needle) {

    // Edgecase to remain consistent with C's strstr() and Java's indexOf() function
    if (needle.length() == 0) {
      return 0;
    }

    final char[] haystackArray = haystack.toCharArray();
    final char[] needleArray = needle.toCharArray();

    for (int i = 0; i < haystack.length(); ++i) {
      if (haystackArray[i] == needleArray[0] && foundNeedle(i, haystackArray, needleArray)) {
        return i;
      }
    }

    return -1;
  }
}
