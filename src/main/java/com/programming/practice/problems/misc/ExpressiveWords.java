package com.programming.practice.problems.misc;

/**
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi"
 * -> "hiiii". In these strings like "heeellooo", we have groups of adjacent letters that are all
 * the same: "h", "eee", "ll", "ooo".
 *
 * <p>For some given string S, a query word is stretchy if it can be made to be equal to S by any
 * number of applications of the following extension operation: choose a group consisting of
 * characters c, and add some number of characters c to the group so that the size of the group is 3
 * or more.
 *
 * <p>For example, starting with "hello", we could do an extension on the group "o" to get
 * "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3. Also, we could
 * do another extension like "ll" -> "lllll" to get "helllllooo". If S = "helllllooo", then the
 * query word "hello" would be stretchy because of these two extension operations: query = "hello"
 * -> "hellooo" -> "helllllooo" = S.
 *
 * <p>Given a list of query words, return the number of words that are stretchy.
 *
 * <pre>
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/expressive-words/">Expressive Words</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ExpressiveWords {

  /**
   * Given a list of query words, returns the number of words that are stretchy.
   *
   * @param stretchyWord The stretchy word.
   * @param queryWords The list of query words.
   * @return The number of words in queryWords that are stretchy.
   */
  public int expressiveWords(final String stretchyWord, final String[] queryWords) {
    int count = 0;

    final RunLengthEncoding sRle = new RunLengthEncoding(stretchyWord);
    for (final String word : queryWords) {
      final RunLengthEncoding wordRle = new RunLengthEncoding(word);
      if (canWordBeStretched(sRle, wordRle)) {
        count++;
      }
    }

    return count;
  }

  /**
   * Determines if the query word can be stretched.
   *
   * @param sRLE The {@link RunLengthEncoding} for the stretchy word.
   * @param queryWordRLE The {@link RunLengthEncoding} for the query word.
   * @return True If the word can be stretched. False, otherwise.
   */
  private boolean canWordBeStretched(
      final RunLengthEncoding sRLE, final RunLengthEncoding queryWordRLE) {
    if (sRLE.characters.size() != queryWordRLE.characters.size()) {
      return false;
    }

    for (int i = 0; i < sRLE.characters.size(); ++i) {
      final boolean isCharacterDifferent = sRLE.characters.get(i) != queryWordRLE.characters.get(i);
      final boolean isCountLess = sRLE.counts.get(i) < queryWordRLE.counts.get(i);
      final boolean doesSNotHaveEnoughCount =
          sRLE.counts.get(i) > queryWordRLE.counts.get(i) && sRLE.counts.get(i) < 3;

      if (isCharacterDifferent || isCountLess || doesSNotHaveEnoughCount) {
        return false;
      }
    }

    // System.out.println("Returning true for: \n" + wordRle);
    return true;
  }
}
