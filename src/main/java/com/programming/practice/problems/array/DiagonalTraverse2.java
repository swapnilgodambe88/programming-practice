package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown
 * in the below images.
 *
 * <pre>
 * Example 1:
 *
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 *
 *  Example 2:
 *
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 *  Example 3:
 *
 * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * Output: [1,4,2,5,3,8,6,9,7,10,11]
 *
 * Example 4:
 *
 * Input: nums = [[1,2,3,4,5,6]]
 * Output: [1,2,3,4,5,6]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 * @see <a href = "https://leetcode.com/problems/diagonal-traverse-ii/">Diagonal Traverse 2</a>
 */
public final class DiagonalTraverse2 {

  /**
   * Given a list of lists of integers, return all elements of nums in diagonal order.
   *
   * @param nums The list of list of nums.
   * @return The diagonal traversal order of nums.
   */
  public int[] findDiagonalOrder(List<List<Integer>> nums) {

    final List<Integer> result = new ArrayList<>();
    final int maxHorizontalLength = getMaxHorizontalLength(nums);

    int x = 0, y = 0, startX = 0;
    while (startX < nums.size()) {
      if (isLocationValid(nums, x, y)) {
        result.add(nums.get(x).get(y));
      }

      x--;
      y++;

      if (x < 0 || y > maxHorizontalLength) {
        startX++;
        x = startX;
        y = 0;
      }
    }

    // Traverse the elements on the last row to the right
    int startY = 1;
    x = nums.size() - 1;
    y = startY;
    while (startY < maxHorizontalLength) {
      if (isLocationValid(nums, x, y)) {
        result.add(nums.get(x).get(y));
      }

      x--;
      y++;

      if (x < 0) {
        startY++;
        x = nums.size() - 1;
        y = startY;
      }
    }

    return convertListToArray(result);
  }

  /**
   * Gets the maximum horizontal length.
   *
   * @param nums The list of list of nums.
   * @return The maximum horizontal length.
   */
  private static int getMaxHorizontalLength(final List<List<Integer>> nums) {
    int maxHorizontalLength = Integer.MIN_VALUE;

    for (int x = 0; x < nums.size(); ++x) {
      maxHorizontalLength = Math.max(maxHorizontalLength, nums.get(x).size());
    }

    return maxHorizontalLength;
  }

  /**
   * Checks if the position is valid.
   *
   * @param nums The list of list of nums.
   * @param x The x coordinate.
   * @param y The y coordinate.
   * @return True If the position is valid. Otherwise return false.
   */
  private static boolean isLocationValid(final List<List<Integer>> nums, final int x, final int y) {
    if (x >= 0 && x < nums.size() && y < nums.get(x).size()) {
      return true;
    }

    return false;
  }

  /**
   * Converts a list to an array.
   *
   * @param integerList The integer list.
   * @return The converted list to array.
   */
  private static int[] convertListToArray(final List<Integer> integerList) {
    final int[] arr = new int[integerList.size()];

    for (int i = 0; i < integerList.size(); ++i) {
      arr[i] = integerList.get(i);
    }

    return arr;
  }
}
