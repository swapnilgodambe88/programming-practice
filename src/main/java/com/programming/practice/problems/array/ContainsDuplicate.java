package com.programming.practice.problems.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * <p>Your function should return true if any value appears at least twice in the array, and it
 * should return false if every element is distinct.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,2,3,1] Output: true Example 2:
 *
 * <p>Input: [1,2,3,4] Output: false
 *
 * <p>Example 3:
 *
 * <p>Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 *
 * @see <a href = "https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ContainsDuplicate {

  /**
   * Evaluates if the array contains any atleast one duplicate element in it or not.
   *
   * @param nums The array to evaluate.
   * @return True If the array contains atleast one duplicate elemement. Otherwise, false.
   */
  public boolean containsDuplicate(final int[] nums) {
    final Set<Integer> set = new HashSet<>();

    for (final int number : nums) {
      if (set.contains(number)) {
        return true;
      }

      set.add(number);
    }

    return false;
  }
}
