package com.programming.practice.problems.string;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the
 * string.
 *
 * <p>A word is a maximal substring consisting of non-space characters only.
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/length-of-last-word/description/">Length of Last
 *     Word</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class LengthOfLastWord {

  /**
   * Given a string s consisting of words and spaces, return the length of the last word in the
   * string.
   *
   * @param s The String S.
   * @return The length of the last word.
   */
  public int lengthOfLastWord(final String s) {
    if (s.isEmpty()) {
      return 0;
    }

    final String[] splitString = s.trim().split("\\s");
    final int arrayLength = splitString.length;
    return splitString[arrayLength - 1].length();
  }
}
