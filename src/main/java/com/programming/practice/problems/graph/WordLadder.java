package com.programming.practice.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of
 * shortest transformation sequence from beginWord to endWord, such that:
 *
 * <ul>
 *   <li>Only one letter can be changed at a time.
 *   <li>Each transformed word must exist in the word list.
 * </ul>
 *
 * Note:
 *
 * <ul>
 *   <li>Return 0 if there is no such transformation sequence.
 *   <li>All words have the same length.
 *   <li>All words contain only lowercase alphabetic characters.
 *   <li>You may assume no duplicates in the word list.
 *   <li>You may assume beginWord and endWord are non-empty and are not the same.
 * </ul>
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/word-ladder/">Word Ladder</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class WordLadder {

  /**
   * Finds the length of shortest transformation sequence from beginWord to endWord.
   *
   * @param beginWord The begin word.
   * @param endWord The end word.
   * @param wordList The word list.
   * @return The length of the shortest transformation sequence.
   */
  public int ladderLength(
      final String beginWord, final String endWord, final List<String> wordList) {

    final Map<String, List<String>> graph = createGraph(wordList, beginWord);

    final Queue<String> queue = new LinkedList<>();
    final Set<String> visited = new HashSet<>();

    queue.add(beginWord);

    int ladderLength = 1;
    while (!queue.isEmpty()) {
      ++ladderLength;

      // Evaluate all elements inside queue in a single iteration of queue while loop.
      int count = queue.size();
      while (count > 0) {
        final String poppedWord = queue.remove();

        visited.add(poppedWord);
        final List<String> neighbors = graph.get(poppedWord);

        for (final String neighbor : neighbors) {
          if (!visited.contains(neighbor)) {
            if (neighbor.equals(endWord)) {
              return ladderLength;
            }

            queue.add(neighbor);
          }
        }

        --count;
      }
    }

    // If there is no return from within the while loop means there is not transformation possible
    return 0;
  }

  /**
   * Creates a graph from the list of wordlist and also adds the begin word to the list. The
   * neighbors of the word would be other words from the wordList which differ by a single letter.
   *
   * @param wordList The word list.
   * @param beginWord The begin word.
   * @return A Map representing the graph.
   */
  private Map<String, List<String>> createGraph(
      final List<String> wordList, final String beginWord) {
    final Map<String, List<String>> graph = new HashMap<>();

    // Add the begin word to the list
    final List<String> wordListWithBeginWord = new ArrayList<>(wordList);
    wordListWithBeginWord.add(beginWord);

    // Each word in the list will be a vertex on the graph.
    wordListWithBeginWord.forEach(
        word -> {
          graph.put(word, new ArrayList<>());
        });

    wordListWithBeginWord.forEach(
        neighbor -> {
          for (final String word : graph.keySet()) {

            // NOTE: A word cannot be a neighbor of itself.
            if (!neighbor.equals(word) && doesWordsDifferByOneLetter(word, neighbor)) {
              graph.get(word).add(neighbor);
            }
          }
        });

    return graph;
  }

  /**
   * Performs a check if two words differ by a single letter.
   *
   * @param word1 The word 1.
   * @param word2 The word 2.
   * @return True If word1 and word2 differ by a single letter. Otherwise false.
   */
  private boolean doesWordsDifferByOneLetter(final String word1, final String word2) {
    int diffCount = 0;

    for (int i = 0; i < word1.length(); ++i) {
      if (word1.charAt(i) != word2.charAt(i)) {
        ++diffCount;
      }

      if (diffCount > 1) {
        return false;
      }
    }

    return true;
  }
}
