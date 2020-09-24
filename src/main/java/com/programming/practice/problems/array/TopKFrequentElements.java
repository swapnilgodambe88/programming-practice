package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [1], k = 1 Output: [1]
 *
 * @see <a href = "https://leetcode.com/problems/top-k-frequent-elements/">Top K Frequent
 *     Elements</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TopKFrequentElements {

  /**
   * Returns the k most frequent elements.
   *
   * @param nums The nums array.
   * @param k The integer k.
   * @return The k most frequent elements.
   */
  public int[] topKFrequent(final int[] nums, final int k) {
    final Map<Integer, Integer> map = new HashMap<>();

    for (final int number : nums) {
      final int count = map.getOrDefault(number, 0);
      map.put(number, count + 1);
    }

    final Comparator<Map.Entry<Integer, Integer>> frequencyComparator =
        (a, b) -> {
          return b.getValue() - a.getValue();
        };

    final List<Map.Entry<Integer, Integer>> mapEntries = new ArrayList<>(map.entrySet());
    Collections.sort(mapEntries, frequencyComparator);

    final int[] topKFrequentWords = new int[k];
    for (int i = 0; i < k; ++i) {
      topKFrequentWords[i] = mapEntries.get(i).getKey();
    }

    return topKFrequentWords;
  }
}
