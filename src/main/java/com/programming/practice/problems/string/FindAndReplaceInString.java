package com.programming.practice.problems.string;

import java.util.Arrays;

/**
 * To some string S, we will perform some replacement operations that replace groups of letters with
 * new ones (not necessarily the same size).
 *
 * <p>Each replacement operation has 3 parameters: a starting index i, a source word x and a target
 * word y. The rule is that if x starts at position i in the original string S, then we will replace
 * that occurrence of x with y. If not, we do nothing.
 *
 * <p>For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y =
 * "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with
 * "ffff".
 *
 * <p>Using another example on S = "abcd", if we have both the replacement operation i = 0, x =
 * "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this
 * second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0]
 * = 'e'.
 *
 * <p>All these operations occur simultaneously. It's guaranteed that there won't be any overlap in
 * replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test
 * case.
 *
 * <pre>
 * Example 1:
 *
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 *
 * Example 2:
 *
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/find-and-replace-in-string/">Find And Replace in
 *     String</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FindAndReplaceInString {

  /**
   * Performs the string replacement on the input string.
   *
   * @param S The input string.
   * @param indexes The indices at which the replacement string is provided.
   * @param sources The source string array.
   * @param targets The target replacement string array.
   * @return The replacement string.
   */
  public String findReplaceString(
      final String S, final int[] indexes, final String[] sources, final String[] targets) {

    // We introduce a match array to signify if replacement needs to happen at ith index of String.
    final int[] match = new int[S.length()];
    Arrays.fill(match, -1);

    // Fill the matches array by evaluating the sources array and determining if replacement is
    // possible
    for (int i = 0; i < indexes.length; ++i) {
      final int indexToMatch = indexes[i];

      if (S.substring(indexToMatch, indexToMatch + sources[i].length()).equals(sources[i])) {
        match[indexToMatch] = i;
      }
    }

    final StringBuffer replacementString = new StringBuffer();
    int sIndex = 0;

    while (sIndex < S.length()) {
      if (match[sIndex] >= 0) {
        final int replacementIndex = match[sIndex];
        replacementString.append(targets[replacementIndex]);

        // If string is replaced, increment the sIndex pointer by length of sources string
        sIndex += sources[replacementIndex].length();
      } else {

        replacementString.append(S.charAt(sIndex++));
      }
    }

    return replacementString.toString();
  }
}
