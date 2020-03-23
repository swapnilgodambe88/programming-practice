package com.programming.practice.problems.array;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of
 * the same color are adjacent, with the colors in the order red, white and blue.
 *
 * <p>Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * <p>Note: You are not suppose to use the library's sort function for this problem.
 *
 * <p>Example:
 *
 * <p>Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 *
 * @see <a href = "https://leetcode.com/problems/sort-colors/">Sort Colors</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SortColors {

  /**
   * Sorts the colors in place so that objects of the same color are adjacent, with the colors in
   * the order of red (0), white (1) and blue (2).
   *
   * @param colors The integer array representing the colors to be sorted in place.
   */
  public void sortColors(final int[] colors) {

    int redCount = 0, whiteCount = 0, blueCount = 0;

    for (final int color : colors) {
      switch (color) {
        case 0:
          ++redCount;
          break;
        case 1:
          ++whiteCount;
          break;
        default:
          ++blueCount;
      }
    }

    int index = 0;
    // Stamp the red color
    while (index < redCount) {
      colors[index++] = 0;
    }

    // Stamp the white color
    while (index < redCount + whiteCount) {
      colors[index++] = 1;
    }

    // Stamp the blue color
    while (index < redCount + whiteCount + blueCount) {
      colors[index++] = 2;
    }
  }
}
