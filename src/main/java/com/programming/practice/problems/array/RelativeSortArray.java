package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are
 * also in arr1.
 *
 * <p>Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in
 * arr2. Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * <p>Example 1:
 *
 * <p>Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6] Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 * @see <a href = "https://leetcode.com/problems/relative-sort-array/">Relative Sort Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class RelativeSortArray {

  /**
   * Sorts the elements of arr1 such that the relative ordering of items in arr1 are the same as in
   * arr2. Elements that don't appear in arr2 should be placed at the end of arr1 in ascending
   * order.
   *
   * @param arr1 The array 1.
   * @param arr2 The array 2.
   * @return The custom sorted array.
   */
  public int[] relativeSortArray(final int[] arr1, final int[] arr2) {

    // Map to keep track of elements of arr2 and their counts in arr1
    final Map<Integer, Integer> arr2ElementsWithCountMap = new LinkedHashMap<>();

    for (final int number : arr2) {
      arr2ElementsWithCountMap.put(number, 0);
    }

    final int[] result = new int[arr1.length];
    int index = 0;

    for (final int number : arr1) {
      if (arr2ElementsWithCountMap.containsKey(number)) {
        final int count = arr2ElementsWithCountMap.get(number);
        arr2ElementsWithCountMap.put(number, count + 1);
      } else {
        result[index++] = number;
      }
    }

    // Sort logic only works since the problem has condition that elements >=0.
    // NOTE: Different logic will be required if problem allows negative numbers.
    // Sorting will place all the non-existent arr2 elements at the end of the result list with 0's
    // in the beginning.
    Arrays.sort(result);
    index = 0;

    // Add arr2 value with count in result
    for (final Map.Entry<Integer, Integer> entry : arr2ElementsWithCountMap.entrySet()) {
      int count = entry.getValue();
      while (count > 0) {
        result[index++] = entry.getKey();
        --count;
      }
    }

    return result;
  }
}
