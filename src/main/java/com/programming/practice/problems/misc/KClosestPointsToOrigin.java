package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0).
 *
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * <p>
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the
 * order that it is in.)
 *
 * <pre>
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/k-closest-points-to-origin/">K Closest Points to
 *      Origin</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 * @company eBay
 */
public final class KClosestPointsToOrigin {

  /** Class representing a Point on a plane. */
  class Point {
    int x;
    int y;
    double distanceToOriginSquare;

    public Point(final int x, final int y) {
      this.x = x;
      this.y = y;
      this.distanceToOriginSquare = Math.pow(this.x, 2) + Math.pow(this.y, 2);
    }
  }

  /**
   * Find the K closest points to the origin (0, 0).
   *
   * @param points The points.
   * @param K The value K.
   * @return The K closest points to the origin.
   */
  public int[][] kClosest(final int[][] points, final int K) {

    final List<Point> pointList = new ArrayList<>();

    for (final int[] point : points) {
      pointList.add(new Point(point[0], point[1]));
    }

    final Comparator<Point> pointComparator =
        (point1, point2) -> {
          return (int) (point1.distanceToOriginSquare - point2.distanceToOriginSquare);
        };

        Collections.sort(pointList, pointComparator);

        final int[][] result = new int[K][2];
        int count = 0;

        final Iterator<Point> iterator = pointList.iterator();
        while (count < K) {
          final Point point = iterator.next();
          result[count][0] = point.x;
          result[count][1] = point.y;
          ++count;
        }

        return result;
  }
}
