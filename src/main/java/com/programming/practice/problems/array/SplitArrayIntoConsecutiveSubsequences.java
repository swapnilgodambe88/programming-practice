package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

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

  /** Class representing a sequence. */
  class Sequence {
    private final Stack<Integer> sequence;

    /**
     * Public constructor for {@link Sequence}.
     *
     * @param startInteger The start integer for the sequence
     */
    public Sequence(final int startInteger) {
      this.sequence = new Stack<>();
      this.sequence.push(startInteger);
    }

    /**
     * Adds an integer to the sequence.
     *
     * @param integer The integer to add.
     */
    public void add(final int integer) {
      assert integer == getEndInteger() + 1;
      this.sequence.push(integer);
    }

    /** @return The end integer of the sequence. */
    public int getEndInteger() {
      return sequence.peek();
    }

    /** @return The total count of integers on the sequence. */
    public int getCount() {
      return sequence.size();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
      return this.sequence.toString();
    }
  }

  /**
   * Given an array nums sorted in ascending order, returns true if and only if you can split it
   * into 1 or more subsequences such that each subsequence consists of consecutive integers and has
   * length at least 3.
   *
   * @param nums The nums array.
   * @return True If the array can be split. False, otherwise.
   * @note time limit exceeded leetcode.
   */
  public boolean isPossible(final int[] nums) {

    final List<Sequence> list = new ArrayList<>();
    for (final int number : nums) {
      final Sequence possibleSequence = getBestSequenceToInsertNumber(list, number);

      if (possibleSequence != null) {
        possibleSequence.add(number);
      } else {
        list.add(new Sequence(number));
      }
    }

    return evaluateEachSequence(list);
  }

  private Sequence getBestSequenceToInsertNumber(
      final List<Sequence> sequenceList, final int number) {

    final Comparator<Sequence> comparator =
        (a, b) -> {
          return a.sequence.size() - b.sequence.size();
        };

    final PriorityQueue<Sequence> possibleList = new PriorityQueue<>(comparator);
    for (final Sequence sequence : sequenceList) {
      if (sequence.getEndInteger() == number - 1) {
        possibleList.add(sequence);
      }
    }

    return possibleList.poll();
  }

  private boolean evaluateEachSequence(final List<Sequence> list) {
    for (final Sequence sequence : list) {
      if (sequence.getCount() < 3) {
        return false;
      }
    }

    return true;
  }
}
