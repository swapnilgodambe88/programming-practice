package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted
 * order.
 *
 * <p>Return the intersection of these two interval lists.
 *
 * <p>(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <=
 * x <= b. The intersection of two closed intervals is a set of real numbers that is either empty,
 * or can be represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is
 * [2, 3].)
 *
 * <pre>
 * Example 1:
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/interval-list-intersections/">Interval List
 *     Intersections</a>
 */
public class IntervalListIntersection {

  /**
   * Return the intersection of these two interval lists.
   *
   * @param A The A list.
   * @param B The B list.
   * @return The intersection of the two interval lists.
   */
  public int[][] intervalIntersection(final int[][] A, final int[][] B) {

    final List<int[]> intersection = new ArrayList<>();
    int aIndex = 0;
    int bIndex = 0;

    while (aIndex < A.length && bIndex < B.length) {
      final int low = Math.max(A[aIndex][0], B[bIndex][0]);
      final int high = Math.min(A[aIndex][1], B[bIndex][1]);

      if (low <= high) {
        intersection.add(new int[] {low, high});
      }

      if (A[aIndex][1] < B[bIndex][1]) {
        aIndex++;
      } else {
        bIndex++;
      }
    }

    return intersection.toArray(new int[intersection.size()][]);
  }
}
