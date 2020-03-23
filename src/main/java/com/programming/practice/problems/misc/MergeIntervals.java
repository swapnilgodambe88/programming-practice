package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * <p>Example 1:
 *
 * <p>Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]] Explanation: Since
 * intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * <p>Example 2:
 *
 * <p>Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5] are considered
 * overlapping.
 *
 * @see <a href = "https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MergeIntervals {

  /**
   * Returns the merged intervals.
   *
   * @param intervals The 2D array representing intervals.
   * @return The merged intervals.
   */
  public int[][] merge(final int[][] intervals) {

    if (intervals.length == 0) {
      return new int[0][];
    }

    // Custom comparator to compare two intervals
    final Comparator<int[]> intervalComparator =
        (interval1, interval2) -> {
          if (interval1[0] != interval2[0]) {
            // The interval with smaller start should go first in ascending order.
            return interval1[0] - interval2[0];
          }

          // If both interval have same start, then interval with larger end should go first in
          // ascending order.
          return interval2[1] - interval1[1];
        };

    Collections.sort(Arrays.asList(intervals), intervalComparator);

    final List<Integer[]> mergedIntervalList = new LinkedList<>();

    int index = 0;
    mergedIntervalList.add(new Integer[] {intervals[0][0], intervals[0][1]});

    for (int i = 1; i < intervals.length; ++i) {
      final int[] currentUnmergedInterval = intervals[i];
      final Integer[] currentMergedInterval = mergedIntervalList.get(index);

      if (currentUnmergedInterval[0] >= currentMergedInterval[0]
          && currentUnmergedInterval[0] <= currentMergedInterval[1]) {
        currentMergedInterval[1] = Math.max(currentMergedInterval[1], currentUnmergedInterval[1]);
      } else {
        index++;
        mergedIntervalList.add(new Integer[] {intervals[i][0], intervals[i][1]});
      }
    }

    return convertListOfArrayTo2DArray(mergedIntervalList);
  }

  /**
   * Utility function to convert list of array into 2-D array.
   *
   * @param listOfArray The list of array to convert.
   * @return The converted 2D array.
   */
  private static int[][] convertListOfArrayTo2DArray(final List<Integer[]> listOfArray) {
    final int[][] convertedArray = new int[listOfArray.size()][2];

    for (int i = 0; i < listOfArray.size(); ++i) {
      convertedArray[i][0] = listOfArray.get(i)[0];
      convertedArray[i][1] = listOfArray.get(i)[1];
    }

    return convertedArray;
  }
}
