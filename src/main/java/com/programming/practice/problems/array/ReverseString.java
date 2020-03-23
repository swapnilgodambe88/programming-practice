package com.programming.practice.problems.array;

/**
 * Write a function that reverses a string. The input string is given as an array of characters
 * char[].
 *
 * <p>Do not allocate extra space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * <p>You may assume all the characters consist of printable ascii characters.
 *
 * <p>Example 1:
 *
 * <p>Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
 *
 * <p>Example 2:
 *
 * <p>Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 *
 * @see <a href = "https://leetcode.com/problems/reverse-string/">Reverse String</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReverseString {

  /**
   * Reverses string in place.
   *
   * @param inputCharArray The array of characters representing the string to be reversed.
   */
  public void reverseString(final char[] inputCharArray) {

    int start = 0, end = inputCharArray.length - 1;
    char temp;

    while (start <= end) {
      temp = inputCharArray[start];
      inputCharArray[start] = inputCharArray[end];
      inputCharArray[end] = temp;

      ++start;
      --end;
    }
  }
}
