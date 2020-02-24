package com.programming.practice.problems.misc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * <p>Input: 3 Output: "III"
 *
 * <p>Example 2:
 *
 * <p>Input: 4 Output: "IV"
 *
 * <p>Example 3:
 *
 * <p>Input: 9 Output: "IX"
 *
 * <p>Example 4:
 *
 * <p>Input: 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3.
 *
 * <p>Example 5:
 *
 * <p>Input: 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * @see <a href = "https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class IntegerToRoman {

  // NOTE: Using LinkedHashMap to retain the order of insertion in map
  private static final Map<Integer, String> romanMap = new LinkedHashMap<>();

  // Maintaining a mapping of integer to Roman
  static {
    romanMap.put(1000, "M");
    romanMap.put(900, "CM");
    romanMap.put(500, "D");
    romanMap.put(400, "CD");
    romanMap.put(100, "C");
    romanMap.put(90, "XC");
    romanMap.put(50, "L");
    romanMap.put(40, "XL");
    romanMap.put(10, "X");
    romanMap.put(9, "IX");
    romanMap.put(5, "V");
    romanMap.put(4, "IV");
    romanMap.put(1, "I");
    romanMap.put(0, "INVALID");
  }

  /**
   * @param number The number to evaluate.
   * @return The max possible roman number giving a positive quotient after division.
   */
  private static int getMaxDivisibleRomanInteger(final int number) {
    for (final int integer : romanMap.keySet()) {
      if (Math.floorDiv(number, integer) > 0) {
        return integer;
      }
    }

    return 0;
  }

  /**
   * @param number The number to convert to Roman.
   * @return The converted Roman equivalent of integer.
   */
  public String intToRoman(final int number) {

    int dupNumber = number;

    final StringBuilder romanString = new StringBuilder();

    while (dupNumber > 0) {
      final int maxDivisibleRomanNumber = getMaxDivisibleRomanInteger(dupNumber);

      romanString.append(romanMap.get(maxDivisibleRomanNumber));

      dupNumber -= maxDivisibleRomanNumber;
    }

    return romanString.toString();
  }
}
