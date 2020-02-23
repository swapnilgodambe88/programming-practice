package com.programming.practice.problems.array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * <p>You may assume no duplicates in the array.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,3,5,6], 5 Output: 2
 *
 * <p>Example 2:
 *
 * <p>Input: [1,3,5,6], 2 Output: 1
 *
 * <p>Example 3:
 *
 * <p>Input: [1,3,5,6], 7 Output: 4
 *
 * <p>Example 4:
 *
 * <p>Input: [1,3,5,6], 0 Output: 0
 *
 * @see <a href = "https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class SearchInsertPosition {

  /**
   * @param nums The number array.
   * @param target The target to insert/search in the array.
   * @return The index position where the target needs to be inserted or is found.
   */
  public int searchInsert(final int[] nums, final int target) {
    int left = 0, right = nums.length - 1;

    if (target < nums[0]) {
      return 0;
    } else if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    while (left <= right) {
      final int mid = Math.floorDiv(left + right, 2);

      if (target == nums[mid]) {
        return mid;
      }

      if (target < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println("Left index: " + left + " | right index: " + right);

    // Element not found. Left and right are swapped and differ by 1 position
    if (target > nums[right] && target < nums[left]) // target between right and left
    {
      return right + 1;
    } else if (target < nums[right]) // target to left of right
    {
      return right - 1;
    } else // target to right of left
    {
      return left + 1;
    }
  }
}
