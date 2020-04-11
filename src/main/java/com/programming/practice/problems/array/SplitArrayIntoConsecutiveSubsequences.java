package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums sorted in ascending order, return true if and only if you can split it into 1
 * or more subsequences such that each subsequence consists of consecutive integers and has length
 * at least 3.
 *
 * <pre>
 * Example 1:
 *
 * Input: [1,2,3,3,4,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3
 * 3, 4, 5
 *
 * Example 2:
 *
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * Explanation:
 * You can split them into two consecutive subsequences :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 * Example 3:
 *
 * Input: [1,2,3,4,4,5]
 * Output: False
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/split-array-into-consecutive-subsequences/">Split
 *     Array into Consecutive Subsequences</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SplitArrayIntoConsecutiveSubsequences {

  /**
   * Given an array nums sorted in ascending order, returns true if and only if you can split it
   * into 1 or more subsequences such that each subsequence consists of consecutive integers and has
   * length at least 3.
   *
   * @param nums The nums array.
   * @return True If the array can be split. False, otherwise.
   * @note failing some tests on leetcode.
   */
  public boolean isPossible(final int[] nums) {
    final Map<Integer, Integer> map = new HashMap<>();

    for (final int number : nums) {
      final int count = map.getOrDefault(number, 0);
      map.put(number, count + 1);
    }

    final int numberOfSubsequences = numberOfSubsequences(map);

    final List<List<Integer>> sequences = getList(numberOfSubsequences);

    for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int count = entry.getValue();
      final int digit = entry.getKey();

      while (count > 0) {
        sequences.get(count - 1).add(digit);
        --count;
      }
    }

    // System.out.println(sequences);

    return evaluateSequences(sequences);
  }

  /**
   * Returns the number of sequences possible.
   *
   * @param map The map of numbers with their frequencies.
   * @return The number of sequences possible.
   */
  private static int numberOfSubsequences(final Map<Integer, Integer> map) {
    int maxCount = 0;

    for (final int frequency : map.values()) {
      if (frequency > maxCount) {
        maxCount = frequency;
      }
    }

    return maxCount;
  }

  /**
   * Creates an empty List with the specified size.
   *
   * @param size The size of the list.
   * @return The list with required size.
   */
  private static List<List<Integer>> getList(final int size) {
    final List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i < size; ++i) {
      list.add(new ArrayList<>());
    }

    return list;
  }

  /**
   * Evaluates if the sequence is sequential and of size 3.
   *
   * @param sequences The sequence.
   * @return True If sequence is valid. False, otherwise.
   */
  private static boolean evaluateSequences(final List<List<Integer>> sequences) {
    for (final List<Integer> sequence : sequences) {
      if (sequence.size() < 3 || isSequenceSequential(sequence)) {
        return false;
      }
    }
    return true;
  }

  /*
   * Evaluates if the sequence is sequential.
   *
   * @param list The sequence.
   * @return True If the sequence is sequential. False, otherwise.
   */
  private static boolean isSequenceSequential(final List<Integer> list) {
    for (int i = 0; i < list.size() - 2; ++i) {
      if (list.get(i) != list.get(i + 1) - 1) {
        return false;
      }
    }

    return true;
  }
}
