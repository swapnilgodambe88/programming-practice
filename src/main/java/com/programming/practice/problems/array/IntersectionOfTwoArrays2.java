package com.programming.practice.problems.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * <p>Example 1:
 *
 * <p>Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2]
 *
 * <p>Example 2:
 *
 * <p>Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9]
 *
 * <p>Note:
 *
 * <p>Each element in the result should appear as many times as it shows in both arrays. The result
 * can be in any order.
 *
 * @see <a href = "https://leetcode.com/problems/intersection-of-two-arrays-ii/">Intersection of Two
 *     Arrays II</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class IntersectionOfTwoArrays2 {

  /**
   * Computes the intersection of two arrays.
   *
   * @param nums1 The array 1.
   * @param nums2 The array 2.
   * @return The intersection of two arrays.
   */
  public int[] intersect(final int[] nums1, final int[] nums2) {

    final Map<Integer, Integer> map = new HashMap<>();

    for (final int number : nums1) {
      map.putIfAbsent(number, 0);
      map.put(number, map.get(number) + 1);
    }

    final List<Integer> intersection = new LinkedList<>();
    for (final int number : nums2) {
      if (map.containsKey(number)) {
        intersection.add(number);
        final int count = map.get(number);

        if (count > 1) {
          map.put(number, count - 1);
        } else {
          map.remove(number);
        }
      }
    }

    return intersection.stream().mapToInt(Integer::intValue).toArray();
  }
}
