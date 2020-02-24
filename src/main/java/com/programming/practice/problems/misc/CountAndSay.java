package com.programming.practice.problems.misc;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * <ol>
 *   <li>1
 *   <li>11
 *   <li>21
 *   <li>1211
 *   <li>111221
 * </ol>
 *
 * Example 1:
 *
 * <p>Input: 1 Output: "1"
 *
 * @see <a href = "https://leetcode.com/problems/count-and-say/">Count and Say</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class CountAndSay {

  /**
   * @param n The sequence that needs to be returned.
   * @return The count and say sequence.
   */
  public String countAndSay(final int n) {

    String sequence = "1";
    for (int i = 2; i <= n; ++i) {
      sequence = readSequence(sequence);
    }
    return sequence;
  }

  /**
   * Reads the sequence and returns the say version.
   *
   * @param sequence The sequence in string.
   * @return The say version of the sequence.
   */
  private String readSequence(final String sequence) {
    final StringBuilder newSequence = new StringBuilder();

    final char[] sequenceArray = sequence.toCharArray();

    int count = 1, i = 0;
    for (; i < sequenceArray.length - 1; ++i) {
      if (sequenceArray[i] == sequenceArray[i + 1]) {
        count++;
      } else {
        newSequence.append(Integer.toString(count)).append(sequenceArray[i]);
        count = 1;
      }
    }

    // Append last character
    newSequence.append(count).append(sequenceArray[i]);
    return newSequence.toString();
  }
}
