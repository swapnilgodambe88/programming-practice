package com.programming.practice.problems.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CourseSchedule}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CourseScheduleTest {

  private final CourseSchedule obj = new CourseSchedule();

  @Test
  public void testNotPossibleToFinishCourse1() {

    final int[][] prerequisites = new int[][] {{1, 0}, {1, 2}, {0, 1}};
    Assert.assertFalse(obj.canFinish(3, prerequisites));
  }

  @Test
  public void testNotPossibleToFinishCourse2() {

    final int[][] prerequisites = new int[][] {{1, 0}, {0, 1}};
    Assert.assertFalse(obj.canFinish(2, prerequisites));
  }

  @Test
  public void testPossibleToFinishCourse1() {

    final int[][] prerequisites = new int[][] {{1, 0}};
    Assert.assertTrue(obj.canFinish(2, prerequisites));
  }

  @Test
  public void testPossibleToFinishCourse2() {

    final int[][] prerequisites = new int[][] {{0, 1}, {0, 2}, {1, 2}};
    Assert.assertTrue(obj.canFinish(3, prerequisites));
  }
}
