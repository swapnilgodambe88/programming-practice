package com.programming.practice.problems.string;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *
 * <p>Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *
 * <ul>
 *   <li>If the group's length is 1, append the character to s.
 *   <li>Otherwise, append the character followed by the group's length.
 * </ul>
 *
 * The compressed string s should not be returned separately, but instead be stored in the input
 * character array chars. Note that group lengths that are 10 or longer will be split into multiple
 * characters in chars.
 *
 * <p>After you are done modifying the input array, return the new length of the array.
 *
 * <pre>
 * Example 1:
 *
 * Input: chars = ["a","a","b","b","c","c","c"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
 * Example 2:
 *
 * Input: chars = ["a"]
 * Output: Return 1, and the first character of the input array should be: ["a"]
 * Explanation: The only group is "a", which remains uncompressed since it's a single character.
 * Example 3:
 *
 * Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 * Example 4:
 *
 * Input: chars = ["a","a","a","b","b","a","a"]
 * Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
 * Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/string-compression/">String Compression</a>
 */
public class StringCompress {

  /**
   * Performs string compression and returns the size of the compressed string
   *
   * @param chars The array of characters representing the string to compress.
   * @return The size of the compressed string.
   */
  public int compress(final char[] chars) {

    int writeIndex = 0;
    int indexOfFirstRepeatingChar = 0;
    for (int readIndex = 0; readIndex < chars.length; ++readIndex) {
      // If readIndex is the last character OR character at readIndex + 1 is not same as character
      // at readIndex
      if (readIndex == chars.length - 1 || chars[readIndex + 1] != chars[readIndex]) {
        chars[writeIndex++] = chars[indexOfFirstRepeatingChar];

        final int count = readIndex - indexOfFirstRepeatingChar + 1;
        if (count > 1) {
          for (final char c : String.valueOf(count).toCharArray()) {
            chars[writeIndex++] = c;
          }
        }

        indexOfFirstRepeatingChar = readIndex + 1;
      }
    }

    return writeIndex;
  }
}
