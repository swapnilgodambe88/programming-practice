package com.programming.practice.problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly
 * maxWidth characters and is fully (left and right) justified.
 *
 * <p>You should pack your words in a greedy approach; that is, pack as many words as you can in
 * each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * <p>Extra spaces between words should be distributed as evenly as possible. If the number of
 * spaces on a line do not divide evenly between words, the empty slots on the left will be assigned
 * more spaces than the slots on the right.
 *
 * <p>For the last line of text, it should be left justified and no extra space is inserted between
 * words.
 *
 * <p>Note:
 *
 * <p>A word is defined as a character sequence consisting of non-space characters only. Each word's
 * length is guaranteed to be greater than 0 and not exceed maxWidth. The input array words contains
 * at least one word.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/text-justification/">Text Justification</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class TextJustification {

  /** Represents a single line on the paragraph. */
  class Line {
    private final List<String> wordsInLine;
    private final int maxWidth;
    private final boolean needLeftJustification;

    /**
     * Constructor for {@link Line}.
     *
     * @param wordsInLine The words to accommodate in line.
     * @param maxWidth The maximum width of the line.
     * @param needLeftJustification Boolean represent if left justification is required.
     */
    public Line(
        final List<String> wordsInLine, final int maxWidth, final boolean needLeftJustification) {
      this.wordsInLine = wordsInLine;
      this.maxWidth = maxWidth;
      this.needLeftJustification = needLeftJustification;
    }

    /** @return The justified line. */
    public String getJustifiedLine() {
      final int inBetweenSpacesBetweenWords = wordsInLine.size() - 1;

      if (inBetweenSpacesBetweenWords == 0 || needLeftJustification) {
        return getLeftJustifiedString();
      }

      final int[] spaces = new int[inBetweenSpacesBetweenWords];
      Arrays.fill(spaces, 1);

      int letterCount = 0;
      for (final String word : wordsInLine) {
        letterCount += word.length();
      }

      int spaceCountToInsertUniformly = maxWidth - letterCount - inBetweenSpacesBetweenWords;

      int spaceIndex = 0;
      while (spaceCountToInsertUniformly > 0) {
        ++spaces[spaceIndex++];
        --spaceCountToInsertUniformly;

        if (spaceIndex == spaces.length) {
          spaceIndex = 0;
        }
      }

      return constructLine(spaces);
    }

    /** @return The left justified string. */
    private String getLeftJustifiedString() {
      final StringBuffer leftJustifiedSentence = new StringBuffer();

      int count = 0;
      for (final String word : wordsInLine) {
        leftJustifiedSentence.append(word);
        count += word.length();
        if (count < maxWidth - 1) {
          leftJustifiedSentence.append(" ");
          count += 1;
        }
      }

      while (count < maxWidth) {
        leftJustifiedSentence.append(" ");
        ++count;
      }

      return leftJustifiedSentence.toString();
    }

    /**
     * Constructs the line with the spaces in between.
     *
     * @param spaces The space size in between the words.
     * @return The constructed line.
     */
    private String constructLine(final int[] spaces) {
      final StringBuffer justifiedSentence = new StringBuffer();

      for (int i = 0; i < spaces.length; ++i) {
        justifiedSentence.append(wordsInLine.get(i));
        for (int j = 0; j < spaces[i]; ++j) {
          justifiedSentence.append(" ");
        }
      }

      justifiedSentence.append(wordsInLine.get(wordsInLine.size() - 1));

      return justifiedSentence.toString();
    }
  }

  /**
   * Given an array of words and a width maxWidth, formats the text such that each line has exactly
   * maxWidth characters and is fully (left and right) justified.
   *
   * @param words The list of words
   * @param maxWidth The maximum width of each sentence.
   * @return The justified version of the words.
   */
  public List<String> fullJustify(final String[] words, final int maxWidth) {
    final List<String> justifiedText = new ArrayList<>();

    final List<List<String>> wordsInEachList = getWordsInEachList(words, maxWidth);

    // for (final List<String> wordsOnSingleLine : wordsInEachList) {
    for (int i = 0; i < wordsInEachList.size(); ++i) {
      final List<String> wordsOnSingleLine = wordsInEachList.get(i);
      final Line line = new Line(wordsOnSingleLine, maxWidth, i == wordsInEachList.size() - 1);
      justifiedText.add(line.getJustifiedLine());
    }
    return justifiedText;
  }

  /**
   * Distributes the words in every line of the sentence
   *
   * @param words The words array
   * @param maxWidth The maximum width of the line.
   * @return The distributed words on every line of the text.
   */
  public static List<List<String>> getWordsInEachList(final String[] words, final int maxWidth) {
    final List<List<String>> wordsInEachList = new ArrayList<>();

    List<String> wordsInCurrentSentence = new ArrayList<>();

    int currentSentenceCount = 0;
    for (int i = 0; i < words.length; ++i) {
      currentSentenceCount += words[i].length();

      if (currentSentenceCount <= maxWidth) {
        // Word can be accommodated in the existing line
        wordsInCurrentSentence.add(words[i]);

        if (currentSentenceCount + 1 <= maxWidth) {
          // A space after word can be accommodated in the existing line
          currentSentenceCount += 1;
        }
      } else {
        // Word cannot be accomodated in the existing line. Push the previous words in the list and
        // start with new list
        wordsInEachList.add(wordsInCurrentSentence);
        wordsInCurrentSentence = new ArrayList<>();

        wordsInCurrentSentence.add(words[i]);
        currentSentenceCount = 0;
        currentSentenceCount += words[i].length();

        if (currentSentenceCount + 1 <= maxWidth) {
          // A space after word can be accommodated in the existing line
          currentSentenceCount += 1;
        }
      }
    }

    wordsInEachList.add(wordsInCurrentSentence);

    return wordsInEachList;
  }
}
