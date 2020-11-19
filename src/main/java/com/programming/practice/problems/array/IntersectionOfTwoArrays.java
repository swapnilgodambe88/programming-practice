package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * <pre>
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/intersection-of-two-arrays/">Intersection of Two
 *     Arrays</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class IntersectionOfTwoArrays {

  /**
   * Computes the intersection of two arrays.
   *
   * @param nums1 The nums1 array.
   * @param nums2 The nums2 array.
   * @return The intersection of two arrays.
   */
  public int[] intersection(final int[] nums1, final int[] nums2) {
    final Set<Integer> set1 = new HashSet<>();
    for (final int number : nums1) {
      set1.add(number);
    }

    final Set<Integer> set2 = new HashSet<>();
    for (final int number : nums2) {
      set2.add(number);
    }

    final List<Integer> intersection = new ArrayList<>();
    if (set1.size() > set2.size()) {
      for (final int number : set1) {
        if (set2.contains(number)) {
          intersection.add(number);
        }
      }
    } else {
      for (final int number : set2) {
        if (set1.contains(number)) {
          intersection.add(number);
        }
      }
    }

    return intersection.stream().mapToInt(Integer::intValue).toArray();
  }
}
