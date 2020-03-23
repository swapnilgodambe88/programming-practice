package com.programming.practice.problems.misc;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * (si < ei), determine if a person could attend all meetings.
 *
 * <p>Example 1:
 *
 * <p>Input: [[0,30],[5,10],[15,20]] Output: false
 *
 * <p>Example 2:
 *
 * <p>Input: [[7,10],[2,4]] Output: true
 *
 * <p>NOTE: input types have been changed on April 15, 2019. Please reset to default code definition
 * to get new method signature.
 *
 * @see <a href = "https://leetcode.com/problems/meeting-rooms/">Meeting Rooms</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MeetingRooms {

  /**
   * Determines if a person can attend all the meetings.
   *
   * @param intervals The intervals consisting of start and end times.
   * @return True If person can attend all the meeting. False, otherwise.
   */
  public boolean canAttendMeetings(final int[][] intervals) {
    if (intervals.length == 0) {
      return true;
    }

    final MeetingRooms2 obj = new MeetingRooms2();
    return obj.minMeetingRooms(intervals) == 1;
  }
}
