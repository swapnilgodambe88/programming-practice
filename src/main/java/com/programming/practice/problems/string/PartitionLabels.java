package com.programming.practice.problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many
 * parts as possible so that each letter appears in at most one part, and return a list of integers
 * representing the size of these parts.
 *
 * <pre>
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 *
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/partition-labels/">Partition Labels</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PartitionLabels {

  /**
   * Partitions the string into as many parts as possible so that each letter appears in at most one
   * part, and return a list of integers representing the size of these parts.
   *
   * @param inputString The input string.
   * @return A list representing the partitions.
   */
  public List<Integer> partitionLabels(final String inputString) {
    final int[] lastOccurrence = new int[26];

    for (int i = 0; i < inputString.length(); ++i) {
      lastOccurrence[inputString.charAt(i) - 'a'] = i;
    }

    final List<Integer> partition = new ArrayList<>();
    int startIndex = 0, endIndex = 0;

    for (int current = 0; current < inputString.length(); ++current) {
      final char currentCharacter = inputString.charAt(current);
      endIndex = Math.max(endIndex, lastOccurrence[currentCharacter - 'a']);

      if (current == endIndex) {
        partition.add(endIndex - startIndex + 1);
        startIndex = current + 1;
      }
    }

    return partition;
  }
}
