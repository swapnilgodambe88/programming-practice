/** */
package com.programming.practice.problems.misc;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * <p>Each element in the array represents your maximum jump length at that position.
 *
 * <p>Determine if you are able to reach the last index.
 *
 * <p>Example 1:
 *
 * <p>Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to
 * the last index.
 *
 * <p>Example 2:
 *
 * <p>Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter
 * what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * @see <a href = "https://leetcode.com/problems/jump-game/">Jump Game</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class JumpGame {

  private boolean isJumpPossible = false;

  /**
   * Recursive solution.
   *
   * @param nums The array of numbers.
   * @return True If we can jump to the last index. False otherwise.
   */
  public boolean canJump_recursive(final int[] nums) {

    jump(0, nums);
    return isJumpPossible;
  }

  /**
   * Recursive function for jump.
   *
   * @param currentIndex The current index of jump.
   * @param nums The array of numbers.
   */
  private void jump(final int currentIndex, final int[] nums) {

    if (currentIndex == nums.length - 1) {
      isJumpPossible = true;
      return;
    }

    if (currentIndex >= nums.length) {
      return;
    }
    for (int jumpIndex = 1; jumpIndex <= nums[currentIndex]; ++jumpIndex) {
      jump(currentIndex + jumpIndex, nums);
    }
  }

  /**
   * Non-recursive solution.
   *
   * @param nums The array of numbers.
   * @return True If we can jump to the last index. False otherwise.
   */
  public boolean canJump_nonRecursive(final int[] nums) {

    // The last index is always reachable with 0 jumps.
    int lastReachableIndex = nums.length - 1;

    // We go backwards, and evaluate each position if it can make a jump to lastReachableIndex
    for (int i = nums.length - 1; i >= 0; --i) {

      // If current index is i and if lastReachableIndex is within reachable jump distance then this
      // current index is reachable.
      if (i + nums[i] >= lastReachableIndex) {
        lastReachableIndex = i;
      }
    }

    return lastReachableIndex == 0;
  }
}
