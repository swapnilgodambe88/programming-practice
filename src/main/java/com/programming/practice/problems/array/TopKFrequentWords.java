package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * <p>Your answer should be sorted by frequency from highest to lowest. If two words have the same
 * frequency, then the word with the lower alphabetical order comes first.
 *
 * <pre>
 * Example 1:
 *
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 *
 * Example 2:
 *
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/top-k-frequent-words/">Top K Frequent Words</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TopKFrequentWords {

  /**
   * Given a non-empty list of words, return the k most frequent elements.
   *
   * @param words The array of words.
   * @param k The number k.
   * @return The k most frequent elements
   */
  public List<String> topKFrequent(final String[] words, final int k) {

    final Map<String, Integer> frequencyMap = new HashMap<>();

    for (final String word : words) {
      final int frequency = frequencyMap.getOrDefault(word, 0);
      frequencyMap.put(word, frequency + 1);
    }

    final List<Map.Entry<String, Integer>> frequencyMapList =
        new ArrayList<>(frequencyMap.entrySet());

    final Comparator<Map.Entry<String, Integer>> frequencyComparator =
        (mapEntry1, mapEntry2) -> {
          if (mapEntry1.getValue() != mapEntry2.getValue()) {
            return mapEntry2.getValue() - mapEntry1.getValue();
          }

          return mapEntry1.getKey().compareTo(mapEntry2.getKey());
        };

    frequencyMapList.sort(frequencyComparator);

    final List<String> topKFrequentWords = new ArrayList<>();
    for (int i = 0; i < k; ++i) {
      topKFrequentWords.add(frequencyMapList.get(i).getKey());
    }

    return topKFrequentWords;
  }
}
