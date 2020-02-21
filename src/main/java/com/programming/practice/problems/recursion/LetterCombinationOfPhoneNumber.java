package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 *
 * <p>A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 *
 * <p>Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @see <a href = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter
 *     Combinations of a Phone Number</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class LetterCombinationOfPhoneNumber {

  /** A map of letters keyed by digit of the phone number */
  private static final Map<Character, String> letterMapKeyedByDigit = new HashMap<>();

  /** A combination list to store the result */
  private List<String> combinationList = new ArrayList<>();

  static {
    letterMapKeyedByDigit.put('1', "");
    letterMapKeyedByDigit.put('2', "abc");
    letterMapKeyedByDigit.put('3', "def");
    letterMapKeyedByDigit.put('4', "ghi");
    letterMapKeyedByDigit.put('5', "jkl");
    letterMapKeyedByDigit.put('6', "mno");
    letterMapKeyedByDigit.put('7', "pqrs");
    letterMapKeyedByDigit.put('8', "tuv");
    letterMapKeyedByDigit.put('9', "wxyz");
  }

  /**
   * @param digits Digits representing phone number.
   * @return List of combination of letters.
   */
  public List<String> letterCombinations(final String digitString) {
    if (digitString.equals("") || digitString.equals("1")) {
      return new ArrayList<>();
    }

    appendCharacterToCombinationString(0, "", digitString);
    return combinationList;
  }

  /**
   * Recursive function that would append the word to combinationList once complete.
   *
   * @param index The index under evaluation.
   * @param stringFormedSoFar The string formed so far.
   * @param digitString The digitString.
   */
  private void appendCharacterToCombinationString(
      final int index, final String stringFormedSoFar, final String digitString) {

    if (index >= digitString.length()) {
      final String combination = stringFormedSoFar.toString();
      combinationList.add(combination);
      return;
    }

    final char digit = digitString.charAt(index);
    final char[] digitLetters = letterMapKeyedByDigit.get(digit).toCharArray();

    for (final char letter : digitLetters) {
      this.appendCharacterToCombinationString(
          index + 1, stringFormedSoFar.concat(Character.toString(letter)), digitString);
    }
  }
}
