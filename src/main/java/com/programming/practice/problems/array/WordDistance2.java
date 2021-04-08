package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure that will be initialized with a string array, and then it should answer
 * queries of the shortest distance between two different strings from the array.
 *
 * <p>Implement the WordDistance class:
 *
 * <ul>
 *   <li>WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 *   <li>int shortest(String word1, String word2) returns the shortest distance between word1 and
 *       word2 in the array wordsDict.
 * </ul>
 *
 * <pre>
 * Example 1:
 *
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 *
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 * @see <a href = "https://leetcode.com/problems/shortest-word-distance-ii/">Shortest Word Distance
 *     2</a>
 */
public class WordDistance2 {

  /** A map to store the indices for every word on the dictionary. */
  private final Map<String, List<Integer>> indexMap;

  /**
   * Constructor for {@link WordDistance2}.
   *
   * @param wordsDict Array of strings representing the word dictionary.
   */
  public WordDistance2(final String[] wordsDict) {
    this.indexMap = new HashMap<>();

    for (int i = 0; i < wordsDict.length; ++i) {
      final String word = wordsDict[i];

      if (indexMap.containsKey(word)) {
        indexMap.get(word).add(i);
      } else {
        final List<Integer> list = new ArrayList<>();
        list.add(i);
        indexMap.put(word, list);
      }
    }
  }

  /**
   * Returns the shortest distance between the two words.
   *
   * @param word1 The word 1.
   * @param word2 The word 2.
   * @return The shortest distance between the two words
   */
  public int shortest(String word1, String word2) {
    // The indices are sorted and hence we can sequentially traverse both the lists

    final List<Integer> word1Indices = indexMap.get(word1);
    final List<Integer> word2Indices = indexMap.get(word2);

    int word1Idx = 0, word2Idx = 0, minDistance = Integer.MAX_VALUE;
    while (word1Idx < word1Indices.size() && word2Idx < word2Indices.size()) {
      minDistance =
          Math.min(minDistance, Math.abs(word1Indices.get(word1Idx) - word2Indices.get(word2Idx)));

      if (word1Indices.get(word1Idx) < word2Indices.get(word2Idx)) {
        word1Idx++;
      } else {
        word2Idx++;
      }
    }

    return minDistance;
  }
}
