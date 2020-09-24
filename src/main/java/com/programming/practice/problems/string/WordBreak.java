package com.programming.practice.problems.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * <p>Note:
 *
 * <ul>
 *   <li>The same word in the dictionary may be reused multiple times in the segmentation.
 *   <li>You may assume the dictionary does not contain duplicate words.
 * </ul>
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/word-break/>Word Break</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class WordBreak {

  /**
   * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
   * determine if s can be segmented into a space-separated sequence of one or more dictionary
   * words.
   *
   * @param s The string to evaluate.
   * @param wordDict The word dictionary.
   * @return True If s can be segmented into a space-separated sequence of one or more dictionary
   *     words. Otherwise, false.
   */
  public boolean wordBreak(final String s, final List<String> wordDict) {

    final Set<String> wordDictSet = new HashSet<>(wordDict);

    // A queue to keep track of the word to evaluate the words in dictionary
    final Queue<Integer> queue = new LinkedList<>();

    // visited is introduced so that the same start index doesn't get evaluated again
    final int[] visited = new int[s.length()];

    queue.add(0);
    while (!queue.isEmpty()) {
      final int start = queue.remove();

      if (visited[start] == 0) {
        for (int end = start + 1; end <= s.length(); ++end) {
          final String wordFormedSoFar = s.substring(start, end);
          if (wordDictSet.contains(wordFormedSoFar)) {
            queue.add(end);

            if (end == s.length()) {
              return true;
            }
          }
        }
        visited[start] = 1;
      }
    }

    return false;
  }
}
