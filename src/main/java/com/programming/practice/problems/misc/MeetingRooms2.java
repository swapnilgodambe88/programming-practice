package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), find the minimum number of conference rooms required.
 *
 * <p>Example 1:
 *
 * <p>Input: [[0, 30],[5, 10],[15, 20]] Output: 2
 *
 * <p>Example 2:
 *
 * <p>Input: [[7,10],[2,4]] Output: 1
 *
 * <p>NOTE: input types have been changed on April 15, 2019. Please reset to default code definition
 * to get new method signature.
 *
 * @see <a href = "https://leetcode.com/problems/meeting-rooms-ii/">Meeting Rooms II</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MeetingRooms2 {

  /**
   * Finds the minimum number of conference rooms required.
   *
   * @param intervals The intervals consisting of start and end times.
   * @return The minimum number of conference rooms required.
   */
  public int minMeetingRooms(final int[][] intervals) {

    if (intervals.length == 0) {
      return 0;
    }

    sortIntervalsInNonDecreasingOrderOfStartTime(intervals);

    final PriorityQueue<Integer> endTimePriorityQueue =
        getPriorityQueueForEndTimes(intervals.length);

    endTimePriorityQueue.add(intervals[0][1]);

    for (int i = 1; i < intervals.length; ++i) {
      final int[] currentInterval = intervals[i];

      final int endTimeOfEarliestRoomToGetFree = endTimePriorityQueue.peek();

      // If start of current interval is >= room with lowest end time, then we can reuse the room.
      // That means we can remove the room from the queue since it can be reused with the current
      // interval.
      if (currentInterval[0] >= endTimeOfEarliestRoomToGetFree) {
        endTimePriorityQueue.poll();
      }

      endTimePriorityQueue.add(currentInterval[1]);
    }

    return endTimePriorityQueue.size();
  }

  /**
   * Sorts the interval in-place in non-decreasing order of start time. If start time is same then
   * interval with lower end time comes first.
   *
   * @param intervals The intervals to sort.
   */
  private static void sortIntervalsInNonDecreasingOrderOfStartTime(final int[][] intervals) {
    final Comparator<int[]> roomComparator =
        (a, b) -> {
          if (a[0] != b[0]) {
            // The interval with smaller start should go first in ascending order.
            return a[0] - b[0];
          }

          // If both interval have same start, then interval with larger end should go first in
          // ascending order.
          return b[0] - a[0];
        };

    Collections.sort(Arrays.asList(intervals), roomComparator);
  }

  /**
   * Creates a Priority queue for the end times such that element with lower end time is removed
   * first from the queue.
   *
   * @param intervalLength The maximum length of the queue.
   * @return The priority queue for the end times.
   */
  private static PriorityQueue<Integer> getPriorityQueueForEndTimes(final int intervalLength) {
    final Comparator<Integer> endTimeComparator =
        (a, b) -> {
          return a - b;
        };

    return new PriorityQueue<>(intervalLength, endTimeComparator);
  }
}
