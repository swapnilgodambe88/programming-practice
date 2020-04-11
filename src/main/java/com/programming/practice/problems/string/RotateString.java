package com.programming.practice.problems.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * We are given two strings, A and B.
 *
 * <p>A shift on A consists of taking string A and moving the leftmost character to the rightmost
 * position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True
 * if and only if A can become B after some number of shifts on A.
 *
 * <pre>
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/rotate-string/">Rotate String</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class RotateString {

  /**
   * Determines if both the string are rotate equivalent (using string concat).
   *
   * @param string1 The first string.
   * @param string2 The second string.
   * @return True string1 can become string2 after some number of shifts. Otherwise, false.
   */
  public boolean rotateString2(final String string1, final String string2) {

    return string1.length() == string2.length() && (string1 + string1).contains(string2);
  }

  /**
   * Determines if both the string are rotate equivalent (using queue).
   *
   * @param string1 The first string.
   * @param string2 The second string.
   * @return True string1 can become string2 after some number of shifts. Otherwise, false.
   */
  public boolean rotateString1(final String string1, final String string2) {

    if (string1.length() != string2.length()) {
      return false;
    }

    if (string1.isEmpty()) {
      return true;
    }

    final Queue<Character> queue = new LinkedList<>();
    for (final char character : string1.toCharArray()) {
      queue.add(character);
    }

    for (int i = 0; i < string2.length(); ++i) {
      queue.add(queue.remove());

      if (isEqual(queue, string2)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Determines if queue contents and string contents are equal.
   *
   * @param queue The queue.
   * @param string The String.
   * @return True if both parameters are equivalent. False, otherwise.
   */
  private static boolean isEqual(final Queue<Character> queue, final String string) {

    final char[] stringArray = string.toCharArray();

    int index = 0;
    for (final char queueCharacter : queue) {
      if (queueCharacter != stringArray[index++]) {
        return false;
      }
    }

    return true;
  }
}
