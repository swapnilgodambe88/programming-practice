/** */
package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * <p>Example:
 *
 * <p>Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ]
 *
 * @see <a href = "https://leetcode.com/problems/group-anagrams/">Group Anagrams</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class GroupAnagrams {

  /** A map to store string with same hashcode together. */
  private final Map<Double, List<String>> mapOfStringKeyedByHashCode = new LinkedHashMap<>();

  /**
   * Groups anagrams from the array of strings.
   *
   * @param strs The array of strings.
   * @return The grouped anagrams.
   */
  public List<List<String>> groupAnagrams(final String[] strs) {

    for (final String string : strs) {
      final double hashCode = generateHashCode(string);

      if (mapOfStringKeyedByHashCode.containsKey(hashCode)) {
        mapOfStringKeyedByHashCode.get(hashCode).add(string);
      } else {
        mapOfStringKeyedByHashCode.put(hashCode, new LinkedList<>(Arrays.asList(string)));
      }
    }

    System.out.println(mapOfStringKeyedByHashCode);

    return new LinkedList<>(mapOfStringKeyedByHashCode.values());
  }

  /**
   * @param inputStr The input string.
   * @return A hash code for the string such that hash code is independent of the position of the
   *     characters in the string.
   */
  private double generateHashCode(final String inputStr) {
    double hashCode = 0;
    int asciiValue = 0;

    for (final char character : inputStr.toCharArray()) {
      asciiValue = character;
      // Random function to generate a hash
      hashCode += Math.pow(asciiValue, 3) + Math.pow(asciiValue, 2) + 1;
    }

    return hashCode;
  }
}
