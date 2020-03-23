/** */
package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MergeIntervals}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MergeIntervalsTest {

  private final MergeIntervals obj = new MergeIntervals();

  @Test
  public void testEmptyInterval() {
    final int[][] intervals = new int[][] {};

    final int[][] expectedMergedIntervals = new int[][] {};

    Assert.assertArrayEquals(expectedMergedIntervals, obj.merge(intervals));
  }

  @Test
  public void testScenario1() {
    final int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

    final int[][] expectedMergedIntervals = new int[][] {{1, 6}, {8, 10}, {15, 18}};

    Assert.assertArrayEquals(expectedMergedIntervals, obj.merge(intervals));
  }

  @Test
  public void testScenario2() {
    final int[][] intervals = new int[][] {{1, 4}, {4, 5}};

    final int[][] expectedMergedIntervals = new int[][] {{1, 5}};

    Assert.assertArrayEquals(expectedMergedIntervals, obj.merge(intervals));
  }

  @Test
  public void testScenario3() {
    final int[][] intervals = new int[][] {{1, 4}, {0, 4}};

    final int[][] expectedMergedIntervals = new int[][] {{0, 4}};

    Assert.assertArrayEquals(expectedMergedIntervals, obj.merge(intervals));
  }
}
