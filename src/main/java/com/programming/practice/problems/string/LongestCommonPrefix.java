package com.programming.practice.problems.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * <p>If there is no common prefix, return an empty string "".
 *
 * <p>Example 1:
 *
 * <p>Input: ["flower","flow","flight"] Output: "fl"
 *
 * <p>Example 2:
 *
 * <p>Input: ["dog","racecar","car"] Output: "" Explanation: There is no common prefix among the
 * input strings.
 *
 * @see <a href = "https://leetcode.com/problems/longest-common-prefix/">Longest Common Prefix</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class LongestCommonPrefix {

  /**
   * @param stringArray The string array of words.
   * @return The longest common prefix amongst the words
   */
  public String longestCommonPrefix(final String[] stringArray) {

    if (stringArray.length == 0) {
      return "";
    }

    String longestCommonPrefix = "";
    final String referenceStringToCompare = stringArray[0];

    int index = 0;
    for (final char character : referenceStringToCompare.toCharArray()) {
      for (final String word : stringArray) {

        // Check if there is a character mismatch OR word length is smaller than
        // referenceStringToCompare
        if (index < word.length() && character != word.charAt(index) || index >= word.length()) {
          return longestCommonPrefix;
        }
      }

      longestCommonPrefix += character;
      index++;
    }

    return longestCommonPrefix;
  }
}
