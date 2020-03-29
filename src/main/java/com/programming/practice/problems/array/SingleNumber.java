package com.programming.practice.problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single
 * one.
 *
 * <p>Note:
 *
 * <p>Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 *
 * <p>Example 1:
 *
 * <p>Input: [2,2,1] Output: 1
 *
 * <p>Example 2:
 *
 * <p>Input: [4,1,2,1,2] Output: 4
 *
 * @see <a href = "https://leetcode.com/problems/single-number/">Single Number</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SingleNumber {

  /**
   * Finds the element which doesn't appear twice on the array (Bit manipulation).<br>
   *
   * <ul>
   *   <li>If we take XOR of zero and some but, it will return that bit: a XOR 0 = a
   *   <li>If we take XOR of same bit, it will return 0: a XOR a = 0
   *   <li>Combining the two: a XOR b XOR a = b (Gives the missing b)
   * </ul>
   *
   * @param nums The array that needs to be evaluated for the non-duplicate number.
   * @return The non-duplicate number.
   */
  public int singleNumberUsingBitManuplation(final int[] nums) {
    int uniqueNumber = 0;

    for (final int number : nums) {
      uniqueNumber ^= number;
    }

    return uniqueNumber;
  }

  /**
   * Finds the element which doesn't appear twice on the array (Using Set).
   *
   * @param nums The array that needs to be evaluated for the non-duplicate number.
   * @return The non-duplicate number.
   */
  public int singleNumberUsingSet(final int[] nums) {
    final Set<Integer> set = new HashSet<>();

    int numsSum = 0, setSum = 0;
    for (final int number : nums) {
      if (!set.contains(number)) {
        set.add(number);
        setSum += number;
      }

      numsSum += number;
    }

    return 2 * setSum - numsSum;
  }
}
