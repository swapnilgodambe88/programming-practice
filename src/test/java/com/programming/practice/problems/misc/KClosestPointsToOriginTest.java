package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link KClosestPointsToOrigin}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class KClosestPointsToOriginTest {

  private final KClosestPointsToOrigin obj = new KClosestPointsToOrigin();

  @Test
  public void testScenario1() {
    final int[][] points = new int[][] {{1, 3}, {-2, 2}};

    final int[][] expectedClosestPoints = new int[][] {{-2, 2}};

    Assert.assertArrayEquals(expectedClosestPoints, obj.kClosest(points, 1));
  }

  @Test
  public void testScenario2() {
    final int[][] points = new int[][] {{3, 3}, {5, -1}, {-2, 4}};

    final int[][] expectedClosestPoints = new int[][] {{3, 3}, {-2, 4}};

    Assert.assertArrayEquals(expectedClosestPoints, obj.kClosest(points, 2));
  }
}
