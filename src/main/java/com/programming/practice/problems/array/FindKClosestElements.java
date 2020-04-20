package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The
 * result should also be sorted in ascending order. If there is a tie, the smaller elements are
 * always preferred.
 *
 * <pre>
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 *
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/find-k-closest-elements/">Find K Closest
 *     Elements</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class FindKClosestElements {

  /**
   * Given a sorted array, two integers k and x, finds the k closest elements to x in the array. The
   * result would also be sorted in ascending order. If there is a tie, the smaller elements are
   * always preferred.
   *
   * @param arr The array.
   * @param k The k value.
   * @param x The x value.
   * @return The k closest elements in the array.
   */
  public List<Integer> findClosestElements(final int[] arr, final int k, final int x) {
    final List<Integer> kClosest = new ArrayList<>();
    Arrays.stream(arr).forEach(element -> kClosest.add(element));

    final Comparator<Integer> comparator =
        (a, b) -> {
          if (Math.abs(a - x) != Math.abs(b - x)) {
            return Math.abs(a - x) - Math.abs(b - x);
          }

          return a - b;
        };

    kClosest.sort(comparator);

    return kClosest.stream().limit(k).sorted().collect(Collectors.toList());
  }
}
