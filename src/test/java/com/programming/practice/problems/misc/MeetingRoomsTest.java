package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MeetingRooms}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MeetingRoomsTest {

  private final MeetingRooms obj = new MeetingRooms();

  @Test
  public void testZeroIntervals() {
    final int[][] intervals = new int[][] {};

    Assert.assertTrue(obj.canAttendMeetings(intervals));
  }

  @Test
  public void testScenario1() {
    final int[][] intervals = new int[][] {{0, 30}, {5, 10}, {15, 20}};

    Assert.assertFalse(obj.canAttendMeetings(intervals));
  }

  @Test
  public void testScenario2() {
    final int[][] intervals = new int[][] {{7, 10}, {2, 4}};

    Assert.assertTrue(obj.canAttendMeetings(intervals));
  }

  @Test
  public void testScenario3() {
    final int[][] intervals = new int[][] {{6, 15}, {13, 20}, {6, 17}};

    Assert.assertFalse(obj.canAttendMeetings(intervals));
  }
}
