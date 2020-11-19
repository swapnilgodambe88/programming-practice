package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the
 * list of banned words. It is guaranteed there is at least one word that isn't banned, and that the
 * answer is unique.
 *
 * <p>Words in the list of banned words are given in lowercase, and free of punctuation. Words in
 * the paragraph are not case sensitive. The answer is in lowercase.
 *
 * <pre>
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/most-common-word/">Most Common Word</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MostCommonWord {

  /**
   * Given a paragraph and a list of banned words, return the most frequent word that is not in the
   * list of banned words.
   *
   * @param paragraph The paragraph.
   * @param banned The list of banned words.
   * @return The most frequent word that is not in the list of banned words.
   */
  public String mostCommonWord(final String paragraph, final String[] banned) {

    final String formattedParagraph = replacePunctuationsAndConvertToLowerCase(paragraph);

    final String[] paragraphWords = formattedParagraph.split("\\s");

    final Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
    final Map<String, Integer> frequencyMap = new HashMap<>();

    for (final String word : paragraphWords) {
      // The trim functionality is added to ignore spaces as words in the frequency map
      if (!bannedWords.contains(word) && word.trim().length() != 0) {
        final int count = frequencyMap.getOrDefault(word, 0);
        frequencyMap.put(word, count + 1);
      }
    }

    final List<Map.Entry<String, Integer>> mapEntryList = new ArrayList<>(frequencyMap.entrySet());

    final Comparator<Map.Entry<String, Integer>> frequencyComparator =
        (a, b) -> {
          if (a.getValue() != b.getValue()) {
            return b.getValue() - a.getValue();
          }

          return b.getKey().compareTo(a.getKey());
        };

    Collections.sort(mapEntryList, frequencyComparator);
    return mapEntryList.get(0).getKey();
  }

  /**
   * Replaces the punctuation with white space and converts the paragraph to lower case.
   *
   * @param paragraph The paragraph to process.
   * @return The processed paragraph.
   */
  private String replacePunctuationsAndConvertToLowerCase(final String paragraph) {
    final StringBuffer stringBuffer = new StringBuffer();

    for (final char character : paragraph.toCharArray()) {
      if (Character.isLetter(character)) {
        stringBuffer.append(Character.toLowerCase(character));
      } else {
        // NOTE: The reason for adding space for punctuation is to difference between two words
        // without any space between then. e.g. bob,billy
        stringBuffer.append(' ');
      }
    }

    return stringBuffer.toString();
  }
}
