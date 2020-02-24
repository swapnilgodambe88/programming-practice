package com.programming.practice.problems.array;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position
 * of a given target value.
 *
 * <p>Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * <p>If the target is not found in the array, return [-1, -1].
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 *
 * <p>Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 *
 * @see <a href =
 *     "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find
 *     First and Last Position of Element in Sorted Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FirstLastPositionInSortedArray {

  /**
   * Find's the starting and ending position of a given target value.
   *
   * @param nums The number sorted array.
   * @param target The target to find.
   * @return The starting and ending position of the given target value.
   */
  public int[] searchRange(final int[] nums, final int target) {
    final int searchIndex = binarySearch(nums, target);

    if (searchIndex == -1) {
      return new int[] {-1, -1};
    }

    int leftBound = searchIndex, rightBound = searchIndex;

    // Find left bound
    while (leftBound >= 0 && nums[leftBound] == target) {
      --leftBound;
    }

    // Find right bound
    while (rightBound < nums.length && nums[rightBound] == target) {
      ++rightBound;
    }

    return new int[] {leftBound + 1, rightBound - 1};
  }

  /**
   * Performs binary search for the target.
   *
   * @param nums The number sorted array.
   * @param target The target to find.
   * @return The first search index encounted for the target
   */
  private int binarySearch(final int[] nums, final int target) {

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      final int mid = Math.floorDiv(left + right, 2);

      if (target == nums[mid]) {
        return mid;
      } else if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
