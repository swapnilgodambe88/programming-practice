package com.programming.practice.problems.string;

import java.util.List;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The
 * frequency of a character is the number of times it appears in the string.
 *
 * <p>Return the sorted string. If there are multiple answers, return any of them.
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 *
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/sort-characters-by-frequency/">Sort Characters By
 *     Frequency</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class SortCharactersByFrequency {

  public String frequencySort(final String input) {
    final List<Character> inputList = input.chars().mapToObj(elem -> (char) elem).toList();

    return null;
  }
}
