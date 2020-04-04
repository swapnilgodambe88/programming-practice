package com.programming.practice.problems.string;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * </pre>
 *
 * Note: You may assume the string contains only lowercase alphabets.
 *
 * <p>Follow up: What if the inputs contain unicode characters? How would you adapt your solution to
 * such case?
 *
 * @see <a href = "https://leetcode.com/problems/valid-anagram/">Valid Anagram</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ValidAnagram {

  /**
   * Determines if the both the strings are anagrams.
   *
   * @param s The string s.
   * @param t The string t.
   * @return True If s is an anagram of t. Otherwise, false.
   */
  public boolean isAnagram(final String s, final String t) {
    return getHash(s) == getHash(t);
  }

  /**
   * A utility function that produces hash based on the characters in the string (and not it's
   * position).
   *
   * @param input The input string.
   * @return The hash code.
   */
  private double getHash(final String input) {

    double hashValue = 0;
    for (final char character : input.toCharArray()) {
      final int asciValueOfCharacter = character;

      // Random hash function.
      hashValue += Math.pow(asciValueOfCharacter, 3) + Math.pow(asciValueOfCharacter, 2) + 1;
    }

    return hashValue;
  }
}
