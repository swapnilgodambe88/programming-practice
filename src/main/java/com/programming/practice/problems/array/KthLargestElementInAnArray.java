package com.programming.practice.problems.array;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the
 * sorted order, not the kth distinct element.
 *
 * <pre>
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest
 *     Element in an Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class KthLargestElementInAnArray {

  /**
   * Finds the kth largest element in an unsorted array.
   *
   * @param nums The nums array.
   * @param k The k number.
   * @return Kth largest element in nums.
   */
  public int findKthLargest(final int[] nums, final int k) {

    for (int i = 0; i < k; ++i) {
      for (int j = 0; j < nums.length - i - 1; ++j) {
        if (nums[j + 1] < nums[j]) {
          final int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }

    return nums[nums.length - k];
  }
}
