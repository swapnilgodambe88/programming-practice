package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * <p>Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x
 * such that x is in one of the ranges but not in nums.
 *
 * <p>Each range [a,b] in the list should be output as:
 *
 * <p>"a->b" if a != b "a" if a == b
 *
 * <pre>
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * Example 3:
 *
 * Input: nums = []
 * Output: []
 *
 * Example 4:
 *
 * Input: nums = [-1]
 * Output: ["-1"]
 *
 * Example 5:
 *
 * Input: nums = [0]
 * Output: ["0"]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/summary-ranges/">Summary Ranges</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SummaryRanges {

  /**
   * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That
   * is, each element of nums is covered by exactly one of the ranges, and there is no integer x
   * such that x is in one of the ranges but not in nums.
   *
   * @param nums The sorted unique integer array nums.
   * @return The smallest sorted list of ranges that cover all the numbers in the array exactly.
   *     That is, each element of nums is covered by exactly one of the ranges, and there is no
   *     integer x such that x is in one of the ranges but not in nums.
   */
  public List<String> summaryRanges(final int[] nums) {
    final List<String> ranges = new ArrayList<>();

    if (nums.length == 0) {
      return ranges;
    }

    int startRange = nums[0];
    int endRange = nums[0];

    for (int i = 1; i < nums.length; ++i) {

      // Not a continuous range. Break the range in two parts
      if (nums[i] != endRange + 1) {
        if (startRange == endRange) {
          ranges.add(Integer.toString(endRange));
        } else {
          ranges.add(Integer.toString(startRange) + "->" + Integer.toString(endRange));
        }

        // Reset the range for next range summary
        startRange = nums[i];
        endRange = nums[i];
      } else {
        endRange++;
      }
    }

    // Adding the end range after traversing the nums array
    if (startRange == endRange) {
      ranges.add(Integer.toString(endRange));
    } else {
      ranges.add(Integer.toString(startRange) + "->" + Integer.toString(endRange));
    }

    return ranges;
  }
}
