package com.programming.practice.problems.array;

/**
 * Given an array nums of n integers where n > 1, return an array output such that output[i] is
 * equal to the product of all the elements of nums except nums[i].
 *
 * <p>Example:
 *
 * <p>Input: [1,2,3,4] Output: [24,12,8,6]
 *
 * @see <a href = "https://leetcode.com/problems/product-of-array-except-self/">Product of Array
 *     Except Self</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class ProductOfArrayExceptSelf {

  /**
   * Given an array nums of n integers where n > 1, return an array output such that output[i] is
   * equal to the product of all the elements of nums except nums[i].
   *
   * @param nums The nums array.
   * @return Product of array except self.
   */
  public int[] productExceptSelf(final int[] nums) {

    if (nums.length <= 1) {
      return nums;
    }

    final int[] result = new int[nums.length];

    final int[] leftProductExceptSelf = new int[nums.length];
    leftProductExceptSelf[0] = 1;
    int productSoFar = 1;

    for (int i = 1; i < nums.length; ++i) {
      productSoFar *= nums[i - 1];
      leftProductExceptSelf[i] = productSoFar;
    }

    final int[] rightProductExceptSelf = new int[nums.length];
    rightProductExceptSelf[nums.length - 1] = 1;
    productSoFar = 1;

    for (int i = nums.length - 2; i >= 0; --i) {
      productSoFar *= nums[i + 1];
      rightProductExceptSelf[i] = productSoFar;
    }

    for (int i = 0; i < nums.length; ++i) {
      result[i] = leftProductExceptSelf[i] * rightProductExceptSelf[i];
    }

    return result;
  }
}
