package com.programming.practice.problems.recurssion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
 * the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
 * does not map to any letters.
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @see <a href = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/">Letter
 *      Combinations of a Phone Number</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class LetterCombinationOfPhoneNumber {

  private final static Map<Integer, String> letterMapKeyedByDigit = new HashMap<>();
  
  static {
    letterMapKeyedByDigit.put(1, "");
    letterMapKeyedByDigit.put(2, "abc");
    letterMapKeyedByDigit.put(3, "def");
    letterMapKeyedByDigit.put(4, "ghi");
    letterMapKeyedByDigit.put(5, "jkl");
    letterMapKeyedByDigit.put(6, "mno");
    letterMapKeyedByDigit.put(7, "pqrs");
    letterMapKeyedByDigit.put(8, "tuv");
    letterMapKeyedByDigit.put(9, "wxyz");
  }
  
  /**
   * @param digits Digits representing phone number.
   * @return List of combination of letters.
   */
  public List<String> letterCombinations(String digits) {
    
  }
}
