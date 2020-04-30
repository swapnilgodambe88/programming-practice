package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem is an interactive problem new to the LeetCode platform.
 *
 * <p>We are given a word list of unique words, each word is 6 letters long, and one word in this
 * list is chosen as secret.
 *
 * <p>You may call master.guess(word) to guess a word. The guessed word should have type string and
 * must be from the original list with 6 lowercase letters.
 *
 * <p>This function returns an integer type, representing the number of exact matches (value and
 * position) of your guess to the secret word. Also, if your guess is not in the given wordlist, it
 * will return -1 instead.
 *
 * <p>For each test case, you have 10 guesses to guess the word. At the end of any number of calls,
 * if you have made 10 or less calls to master.guess and at least one of these guesses was the
 * secret, you pass the testcase.
 *
 * <p>Besides the example test case below, there will be 5 additional test cases, each with 100
 * words in the word list. The letters of each word in those testcases were chosen independently at
 * random from 'a' to 'z', such that every word in the given word lists is unique.
 *
 * <pre>
 * Example 1:
 * Input: secret = "acckzz", wordlist = ["acckzz","ccbazz","eiowzz","abcczz"]
 *
 * Explanation:
 *
 * master.guess("aaaaaa") returns -1, because "aaaaaa" is not in wordlist.
 * master.guess("acckzz") returns 6, because "acckzz" is secret and has all 6 matches.
 * master.guess("ccbazz") returns 3, because "ccbazz" has 3 matches.
 * master.guess("eiowzz") returns 2, because "eiowzz" has 2 matches.
 * master.guess("abcczz") returns 4, because "abcczz" has 4 matches.
 *
 * We made 5 calls to master.guess and one of them was the secret, so we pass the test case.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/guess-the-word/">Guess the Word</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class GuessTheWord {

  /** Master Interface. */
  interface Master {

    /**
     * This function returns an integer type, representing the number of exact matches (value and
     * position) of your guess to the secret word. Also, if your guess is not in the given wordlist,
     * it will return -1 instead.
     *
     * @param word The word to match.
     * @return The number of exact matches.
     */
    public int guess(final String word);
  }

  /**
   * Finds the secret word by making a call to the Master API.<br>
   * <b>NOTE:</b> The implementation of {@link Master} is responsible for keeping track of the
   * number of calls made to the {@link Master#guess(String)} function.
   *
   * @param wordlist The word list.
   * @param master The {@link Master} object.
   */
  public void findSecretWord(final String[] wordlist, final Master master) {

    List<String> possibleWords = new ArrayList<>();

    // Start with possible words containing all the words from the wordList.
    // Reduce the size of possible words to predict based on the guess output.
    for (final String word : wordlist) {
      possibleWords.add(word);
    }

    while (!possibleWords.isEmpty()) {

      final String guessWord = predicteBestGuess(possibleWords);
      final int matches = master.guess(guessWord);

      if (matches == 6) {
        return;
      }

      possibleWords = getPossibleWordsFromWordList(possibleWords, guessWord, matches);
    }
  }

  /**
   * Finds the possible words to match from the word list.<br>
   * It tries to find words from the wordList which has a matching number of matches as that of the
   * guessWord thus reducing the size of the wordList.
   *
   * @param wordList The word list.
   * @param guessWord The guess word.
   * @param matches The matches.
   * @return The possible word list.
   */
  private List<String> getPossibleWordsFromWordList(
      final List<String> wordList, final String guessWord, final int matches) {
    final List<String> possibleMatches = new ArrayList<>();

    for (final String word : wordList) {
      // Since the guessWord is already guessed we don't want to add that word to the
      // possibleMatches
      if (!word.equals(guessWord) && matchingLetterCount(word, guessWord) == matches) {
        possibleMatches.add(word);
      }
    }

    return possibleMatches;
  }

  /**
   * @param string1 The string 1.
   * @param string2 The string 2.
   * @return The matching letter count.
   */
  private int matchingLetterCount(final String string1, final String string2) {
    int count = 0;
    for (int i = 0; i < string1.length(); ++i) {
      if (string1.charAt(i) == string2.charAt(i)) {
        ++count;
      }
    }

    return count;
  }

  /**
   * Among the word list predicts the best guess that can be made by finding matches for a word with
   * all other words, and picking a word which has max match count amongst all the other words.<br>
   * <b>NOTE:</b> This function increases the probability of finding the best guess in less number
   * of attempts vs. taking the first guess from the possible word list as the next guess word.
   *
   * @param wordList The wordList from which the word needs to be picked as guess word.
   * @return The guess word to pick.
   */
  private String predicteBestGuess(final List<String> wordList) {
    String guessWord = wordList.get(0);
    int maxMatchCount = -1;

    for (int i = 0; i < wordList.size(); ++i) {
      for (int j = i + 1; j < wordList.size(); ++j) {

        final int matchCount = matchingLetterCount(wordList.get(i), wordList.get(j));
        if (matchCount > maxMatchCount) {
          maxMatchCount = matchCount;
          guessWord = wordList.get(i);
        }
      }
    }

    return guessWord;
  }
}
