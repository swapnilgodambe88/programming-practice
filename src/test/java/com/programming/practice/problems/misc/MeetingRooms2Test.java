package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MeetingRooms2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MeetingRooms2Test {

  private final MeetingRooms2 obj = new MeetingRooms2();

  @Test
  public void testZeroIntervals() {
    final int[][] intervals = new int[][] {};

    Assert.assertEquals(0, obj.minMeetingRooms(intervals));
  }

  @Test
  public void testScenario1() {
    final int[][] intervals = new int[][] {{0, 30}, {5, 10}, {15, 20}};

    Assert.assertEquals(2, obj.minMeetingRooms(intervals));
  }

  @Test
  public void testScenario2() {
    final int[][] intervals = new int[][] {{7, 10}, {2, 4}};

    Assert.assertEquals(1, obj.minMeetingRooms(intervals));
  }

  @Test
  public void testScenario3() {
    final int[][] intervals = new int[][] {{6, 15}, {13, 20}, {6, 17}};

    Assert.assertEquals(3, obj.minMeetingRooms(intervals));
  }
}
