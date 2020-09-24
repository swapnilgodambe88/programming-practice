package com.programming.practice.problems.array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * <pre>
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/trapping-rain-water/">Trapping Rain Water</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TrappingRainWater {

  /**
   * Given n non-negative integers representing an elevation map where the width of each bar is 1,
   * computes how much water it is able to trap after raining.
   *
   * @param height The height array.
   * @return The water trap after raining.
   */
  public int trap(final int[] height) {

    int leftMax = Integer.MIN_VALUE;
    final int[] leftMaxArray = new int[height.length];
    for (int i = 0; i < height.length; ++i) {
      leftMax = Math.max(leftMax, height[i]);
      leftMaxArray[i] = leftMax;
    }

    int rightMax = Integer.MIN_VALUE;
    final int[] rightMaxArray = new int[height.length];
    for (int i = height.length - 1; i >= 0; --i) {
      rightMax = Math.max(rightMax, height[i]);
      rightMaxArray[i] = rightMax;
    }

    int waterTrap = 0;
    for (int i = 0; i < height.length; ++i) {
      waterTrap += Math.min(leftMaxArray[i], rightMaxArray[i]) - height[i];
    }

    return waterTrap;
  }
}
