package com.programming.practice.problems.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * <p>Example 1:
 *
 * <p>Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 *
 * <p>Example 2:
 *
 * <p>Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 *
 * <p>Example 3:
 *
 * <p>Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that
 * the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @see <a href =
 *     "https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest
 *     Substring Without Repeating Characters</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(final String inputString) {

    int maxLength = 0;

    // startIndex and endIndex will keep track of the length of the sliding window
    // NOTE: Sliding window size = endIndex - startIndex + 1
    int startIndex = 0;
    int endIndex = 0;

    final char[] inputCharArray = inputString.toCharArray();

    // Map to hold unique characters inside of sliding window
    final Set<Character> set = new HashSet<>();

    while (endIndex < inputString.length() && startIndex < inputString.length()) {

      // Increase the sliding window
      if (!set.contains(inputCharArray[endIndex])) {
        set.add(inputCharArray[endIndex++]);

        maxLength = Math.max(maxLength, endIndex - startIndex);
      } else {
        set.remove(inputCharArray[startIndex++]);
      }
    }

    return maxLength;
  }
}
