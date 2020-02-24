package com.programming.practice.problems.array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * <p>(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * <p>You are given a target value to search. If found in the array return its index, otherwise
 * return -1.
 *
 * <p>You may assume no duplicate exists in the array.
 *
 * <p>Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 *
 * @see <a href = "https://leetcode.com/problems/search-in-rotated-sorted-array/">Search in Rotated
 *     Sorted Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SearchInRotatedSortedArray {

  /**
   * Perform search in rotated sorted array.
   *
   * @param nums The rotated sorted array.
   * @param target The target to search.
   * @return THe index of the target if found. Otherwise -1.
   *     <p>NOTE: Never use mid -1 / mid + 1 as index for comparision. This might give out of bound
   *     exceptions in certain scenarios.
   */
  public int search(final int[] nums, final int target) {

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = Math.floorDiv(left + right, 2);

      // NOTE: Using < or > with mid because we know target != nums[mid].
      // <= and >= can be used for left and right
      if (nums[mid] == target) {
        return mid;
        // Left side is linearly sorted
      } else if (nums[left] <= nums[mid]) {
        if (target < nums[mid] && target >= nums[left]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        // Right side is linearly sorted
      } else {
        if (target <= nums[right] && target > nums[mid]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}
