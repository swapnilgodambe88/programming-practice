package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * <p>Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 *
 * <p>The order of output does not matter.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams
 *     in a String</a>
 */
public final class FindAllAnagramsInAString {

  /**
   * Given a string s and a non-empty string p, finds all the start indices of p's anagrams in s.
   *
   * @param s The string.
   * @param p The string p.
   * @return List of indices of p's anagrams in s.
   */
  public List<Integer> findAnagrams(String s, String p) {
    final double pHashCode = generateHashCode(p);

    final List<Integer> anagrams = new ArrayList<>();
    for (int i = 0; i <= s.length() - p.length(); ++i) {
      final String subString = s.substring(i, i + p.length());
      final double subStringHashCode = generateHashCode(subString);

      if (subStringHashCode == pHashCode) {
        anagrams.add(i);
      }
    }

    return anagrams;
  }

  /**
   * Generates a hash code for the input string.
   *
   * @param inputStr The inputStr string.
   * @return A hash code for the string such that hash code is independent of the position of the
   *     characters in the string.
   */
  private double generateHashCode(final String inputStr) {
    double hashCode = 0;
    int asciiValue = 0;

    for (final char character : inputStr.toCharArray()) {
      asciiValue = character;

      hashCode += Math.pow(asciiValue, 3) + Math.pow(asciiValue, 2) + asciiValue + 91;
    }

    return hashCode;
  }
}
