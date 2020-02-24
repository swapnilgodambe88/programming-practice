package com.programming.practice.problems.misc;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * <p>If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 *
 * <p>The replacement must be in-place and use only constant extra memory.
 *
 * <p>Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
 * in the right-hand column.
 *
 * <p>1,2,3 → 1,3,2 | 3,2,1 → 1,2,3 | 1,1,5 → 1,5,1
 *
 * @see <a href = "https://leetcode.com/problems/next-permutation/">Next Permutation</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class NextPermutation {

  /**
   * Rearranges the nums in place for the next greater permutation of the numbers.
   *
   * @param nums The number represent as digits in integer array.
   */
  public void nextPermutation(final int[] nums) {

    int nonIncreasingDigitIndex = -1;
    // Start from second-last, and search for first decreasing digit
    for (int i = nums.length - 1; i > 0; --i) {
      if (nums[i - 1] < nums[i]) {
        nonIncreasingDigitIndex = i - 1;
        break;
      }
    }

    // If swapDigitIndex not found i.e. entire digits are in decreasing order then perform reverse
    if (nonIncreasingDigitIndex == -1) {
      reverseNumberFromIndex(0, nums);
      return;
    }

    final int nonIncreasingDigit = nums[nonIncreasingDigitIndex];
    int swapDigitIndex = -1;
    // Start from nonIncreasingDigitIndex + 1 to find digit just greater than nonIncreasingDigit
    for (int i = nonIncreasingDigitIndex + 1; i < nums.length; ++i) {
      if (nums[i] > nonIncreasingDigit) {
        swapDigitIndex = i;
      } else {
        break;
      }
    }

    // Swap the two integers
    nums[nonIncreasingDigitIndex] = nums[swapDigitIndex];
    nums[swapDigitIndex] = nonIncreasingDigit;

    // Reverse digits from end to nonIncreasingDigitIndex + 1
    reverseNumberFromIndex(nonIncreasingDigitIndex + 1, nums);
  }

  /**
   * Reverse the number array from startIndex position.
   *
   * @param startIndex The start index from where reverse should begin.
   * @param nums The number array.
   */
  private static void reverseNumberFromIndex(final int startIndex, final int[] nums) {
    for (int start = startIndex, end = nums.length - 1; start < end; ++start, --end) {
      final int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
    }
  }
}
