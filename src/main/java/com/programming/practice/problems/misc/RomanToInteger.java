package com.programming.practice.problems.misc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * <p>Input: "III" Output: 3
 *
 * <p>Example 2:
 *
 * <p>Input: "IV" Output: 4
 *
 * <p>Example 3:
 *
 * <p>Input: "IX" Output: 9
 *
 * <p>Example 4:
 *
 * <p>Input: "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3.
 *
 * <p>Example 5:
 *
 * <p>Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @see <a href = "https://leetcode.com/problems/roman-to-integer/">Roman to Integer</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class RomanToInteger {

  // NOTE: Using LinkedHashMap to retain the order of insertion in map
  private static final Map<String, Integer> romanMap = new LinkedHashMap<>();

  static {
    romanMap.put("I", 1);
    romanMap.put("IV", 4);
    romanMap.put("V", 5);
    romanMap.put("IX", 9);
    romanMap.put("X", 10);
    romanMap.put("XL", 40);
    romanMap.put("L", 50);
    romanMap.put("XC", 90);
    romanMap.put("C", 100);
    romanMap.put("CD", 400);
    romanMap.put("D", 500);
    romanMap.put("CM", 900);
    romanMap.put("M", 1000);
  }

  /**
   * Converts roman string to integer.
   *
   * @param romanString The roman string.
   * @return The converted integer from roman string.
   */
  public int romanToInt(final String romanString) {

    int convertedInteger = 0;

    final char[] romanCharArray = romanString.toCharArray();
    int index = 0;

    while (index < romanString.length()) {
      final StringBuilder romanStringToEvaluate = new StringBuilder();
      romanStringToEvaluate.append(romanCharArray[index++]);

      if (index < romanString.length()) {
        final String temp =
            romanStringToEvaluate.toString() + String.valueOf(romanCharArray[index]);

        if (romanMap.containsKey(temp)) {
          romanStringToEvaluate.append(romanCharArray[index++]);
        }
      }

      convertedInteger += romanMap.get(romanStringToEvaluate.toString());
    }

    return convertedInteger;
  }
}
