package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link IntervalListIntersection}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class IntervalListIntersectionTest {

  private final IntervalListIntersection obj = new IntervalListIntersection();

  @Test
  public void testScenario1() {
    final int[][] A = new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    final int[][] B = new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    final int[][] expectedIntersection =
        new int[][] {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}};
    Assert.assertArrayEquals(expectedIntersection, obj.intervalIntersection(A, B));
  }

  @Test
  public void testEmptyA() {
    final int[][] A = new int[][] {};
    final int[][] B = new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    final int[][] expectedIntersection = new int[][] {};
    Assert.assertArrayEquals(expectedIntersection, obj.intervalIntersection(A, B));
  }

  @Test
  public void testEmptyB() {
    final int[][] A = new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    final int[][] B = new int[][] {};

    final int[][] expectedIntersection = new int[][] {};
    Assert.assertArrayEquals(expectedIntersection, obj.intervalIntersection(A, B));
  }
}
