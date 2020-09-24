package com.programming.practice.problems.misc;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a
 * different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * <p>Given a sequence of words written in the alien language, and the order of the alphabet, return
 * true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * <pre>
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 *
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/verifying-an-alien-dictionary/">Verifying an alien
 *     dictionary</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class VerifyingAnAlienDictionary {

  /** variable to keep track of the precedence of the characters in alien dictionary. */
  private final int[] orderIndex = new int[26];

  /**
   * Tells if the words are sorted as per alien dictionary.
   *
   * @param words The words to check if they are sorted as per alien dictionary.
   * @param order The alien dictionary order of alphabets.
   * @return True If the words are sorted, otherwise false.
   */
  public boolean isAlienSorted(final String[] words, final String order) {

    populateOrderIndex(order);

    for (int i = 0; i < words.length - 1; i++) {
      if (!areTwoWordsSorted(words[i], words[i + 1])) {
        return false;
      }
    }

    return true;
  }

  /**
   * Populates the {@link orderIndex}.
   *
   * @param order The alien dictionary order of alphabets.
   */
  private void populateOrderIndex(final String order) {
    for (int i = 0; i < 26; ++i) {
      final char character = order.charAt(i);

      this.orderIndex[character - 'a'] = i;
    }
  }

  /**
   * Compares two words and indicates if the words are sorted.
   *
   * @param word1 The word 1.
   * @param word2 The word 2.
   * @return True If the two words are sorted, Otherwise returns false.
   */
  private boolean areTwoWordsSorted(final String word1, final String word2) {
    for (int i = 0; i < Math.min(word1.length(), word2.length()); ++i) {
      final int comparision = compare(word1.charAt(i), word2.charAt(i));
      if (comparision < 0) {
        return true;
      } else if (comparision > 0) {
        return false;
      }
    }

    if (word1.length() > word2.length()) {
      return false;
    }

    return true;
  }

  /**
   * Compares two characters and indicates if the characters are sorted.
   *
   * @param character1 The character 1.
   * @param character2 The character 2.
   * @return True If the characters are sorted, otherwise returns false.
   */
  private int compare(final char character1, final char character2) {
    return orderIndex[character1 - 'a'] - orderIndex[character2 - 'a'];
  }
}
