package com.programming.practice.problems.misc;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i,
 * ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains
 * the most water.
 *
 * <p>Input: [1,8,6,2,5,4,8,3,7]
 *
 * <p>Output: 49
 *
 * @see <a href = "https://leetcode.com/problems/container-with-most-water/">Container With Most
 *     Water</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class ContainerWithMostWater {

  /**
   * @param heightArray The height array.
   * @return The max area possible.
   */
  public int maxArea(final int[] heightArray) {
    int maxArea = 0;

    int startIndex = 0, endIndex = heightArray.length - 1;

    int width = heightArray.length - 1;
    while (startIndex < endIndex) {

      final int height = Math.min(heightArray[startIndex], heightArray[endIndex]);

      if (maxArea < width * height) {
        maxArea = (int) (width * height);
      }

      if (heightArray[startIndex] < heightArray[endIndex]) {
        startIndex++;
      } else {
        endIndex--;
      }

      width--;
    }

    return maxArea;
  }
}
