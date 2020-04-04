package com.programming.practice.problems.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't
 * exist, return -1.
 *
 * <p>Examples:
 *
 * <p>s = "leetcode" return 0.
 *
 * <p>s = "loveleetcode", return 2.
 *
 * @see <a href = "https://leetcode.com/problems/first-unique-character-in-a-string/">First Unique
 *     Character in a String</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FirstUniqueCharacterInString {

  /**
   * Finds the first non-repeating character.
   *
   * @param s The string to find non-repeating character.
   * @return The index of such non-repeating character. If it doesn't exists, return -1.
   */
  public int firstUniqChar(final String s) {

    // Map to keep track of character and it's count
    final Map<Character, Integer> map = new LinkedHashMap<>();
    for (final char character : s.toCharArray()) {
      final int count = map.getOrDefault(character, 0);
      map.put(character, count + 1);
    }

    for (int index = 0; index < s.length(); ++index) {

      if (map.get(s.charAt(index)).intValue() == 1) {
        return index;
      }
    }

    return -1;
  }
}
