package com.programming.practice.problems.array;

import com.programming.practice.algorithms.BubbleSort;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of
 * each number, also in sorted non-decreasing order.
 *
 * <p>Example 1:
 *
 * <p>Input: [-4,-1,0,3,10] Output: [0,1,9,16,100]
 *
 * <p>Example 2:
 *
 * <p>Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 *
 * <p>Note:
 *
 * <ul>
 *   <li>1 <= A.length <= 10000
 *   <li>-10000 <= A[i] <= 10000
 *   <li>A is sorted in non-decreasing order.
 * </ul>
 *
 * @see <a href = "https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted
 *     Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SquareOfSortedArray {

  /**
   * Returns square of each number in sorted non-decreasing order (using sorting).
   *
   * @param nums The sorted array in non-decreasing order.
   * @return The squares of each number in nums in non-decreasing order.
   */
  public int[] sortedSquares_usingSorting(final int[] nums) {

    final int[] squares = new int[nums.length];

    for (int i = 0; i < nums.length; ++i) {
      squares[i] = (int) Math.pow(nums[i], 2);
    }

    BubbleSort.sortAscending(squares);
    return squares;
  }

  /**
   * Returns square of each number in sorted non-decreasing order (using two pointers).
   *
   * @param nums The sorted array in non-decreasing order.
   * @return The squares of each number in nums in non-decreasing order.
   */
  public int[] sortedSquares_usingTwoPointers(final int[] nums) {
    final int[] squares = new int[nums.length];

    // negative pointer will point to the largest negative number in sorted array.
    int negativePointer = -1;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] < 0) {
        ++negativePointer;
      } else {
        break;
      }
    }

    // positive pointer will point to the smallest non-negative number in sorted array.
    int nonNegativePointer = negativePointer + 1;

    int count = 0;
    while (count < nums.length) {

      final int negativeSquare =
          negativePointer < 0 ? Integer.MAX_VALUE : (int) Math.pow(nums[negativePointer], 2);

      final int nonNegativeSquare =
          nonNegativePointer >= nums.length
              ? Integer.MAX_VALUE
              : (int) Math.pow(nums[nonNegativePointer], 2);

      if (negativeSquare < nonNegativeSquare) {
        squares[count++] = negativeSquare;
        negativePointer--;
      } else {
        squares[count++] = nonNegativeSquare;
        nonNegativePointer++;
      }
    }

    return squares;
  }
}
