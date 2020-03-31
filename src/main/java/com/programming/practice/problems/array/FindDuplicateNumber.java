package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate
 * number, find the duplicate one.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,3,4,2,2] Output: 2
 *
 * <p>Example 2:
 *
 * <p>Input: [3,1,3,4,2] Output: 3
 *
 * @see <a href = "https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate
 *     Number</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class FindDuplicateNumber {

  /**
   * Given an array nums containing n + 1 integers where each integer is between 1 and n
   * (inclusive), prove that at least one duplicate number must exist. Assume that there is only one
   * duplicate number, find the duplicate one.
   *
   * @param nums The array.
   * @return The duplicate number
   */
  public int findDuplicate(final int[] nums) {

    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == nums[i + 1]) {
        return nums[i];
      }
    }

    throw new RuntimeException("Solution doesn't exists");
  }

  /**
   * Given an array nums containing n + 1 integers where each integer is between 1 and n
   * (inclusive), prove that at least one duplicate number must exist. Assume that there is only one
   * duplicate number, find the duplicate one.
   *
   * @param nums The array.
   * @return The duplicate number
   */
  public int findDuplicateUsingSet(final int[] nums) {

    final Set<Integer> set = new HashSet<>();
    for (final int number : nums) {
      if (set.contains(number)) {
        return number;
      }

      set.add(number);
    }

    throw new RuntimeException("Solution doesn't exists");
  }

  /**
   * Given an array nums containing n + 1 integers where each integer is between 1 and n
   * (inclusive), prove that at least one duplicate number must exist. Assume that there is only one
   * duplicate number, find the duplicate one.
   *
   * @param nums The array.
   * @return The duplicate number
   */
  public int findDuplicateUsing2Pointer(final int[] nums) {

    // Find the intersection point of the two runners.
    int tortoise = nums[0];
    int hare = nums[0];
    do {
      tortoise = nums[tortoise];
      hare = nums[nums[hare]];
    } while (tortoise != hare);

    // Find the "entrance" to the cycle.
    int ptr1 = nums[0];
    int ptr2 = tortoise;
    while (ptr1 != ptr2) {
      ptr1 = nums[ptr1];
      ptr2 = nums[ptr2];
    }

    return ptr1;
  }
}
