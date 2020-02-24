package com.programming.practice.problems.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement atoi which converts a string to an integer.
 *
 * <p>The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 *
 * <p>The string can contain additional characters after those that form the integral number, which
 * are ignored and have no effect on the behavior of this function.
 *
 * <p>If the first sequence of non-whitespace characters in str is not a valid integral number, or
 * if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * <p>If no valid conversion could be performed, a zero value is returned.
 *
 * <p>Note:
 *
 * <p>Only the space character ' ' is considered as whitespace character. Assume we are dealing with
 * an environment which could only store integers within the 32-bit signed integer range: [−231, 231
 * − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or
 * INT_MIN (−231) is returned. Example 1:
 *
 * <p>Input: "42" Output: 42
 *
 * <p>Example 2:
 *
 * <p>Input: " -42" Output: -42 Explanation: The first non-whitespace character is '-', which is the
 * minus sign. Then take as many numerical digits as possible, which gets 42.
 *
 * <p>Example 3:
 *
 * <p>Input: "4193 with words" Output: 4193 Explanation: Conversion stops at digit '3' as the next
 * character is not a numerical digit.
 *
 * <p>Example 4:
 *
 * <p>Input: "words and 987" Output: 0 Explanation: The first non-whitespace character is 'w', which
 * is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * <p>Example 5:
 *
 * <p>Input: "-91283472332" Output: -2147483648 Explanation: The number "-91283472332" is out of the
 * range of a 32-bit signed integer. Thefore INT_MIN (−231) is returned.
 *
 * @see <a href = "https://leetcode.com/problems/string-to-integer-atoi/">String to Integer
 *     (atoi)</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class StringToInteger {

  /**
   * Trims all leading white spaces from the input string, and returns a new string.
   *
   * @param inputString The input String.
   * @return String with trimmed white spaces in the beginning.
   */
  private String trimLeadingWhiteSpaces(final String inputString) {
    StringBuilder stringBuilder = new StringBuilder();

    boolean encounteredNonWhiteCharacter = false;
    for (final char character : inputString.toCharArray()) {
      if (character != ' ' || encounteredNonWhiteCharacter == true) {
        stringBuilder.append(character);
        encounteredNonWhiteCharacter = true;
      }
    }

    return stringBuilder.toString();
  }

  /**
   * Converts inputString to integer.
   *
   * @param inputString The input string.
   * @return Converted string to integer.
   */
  public int myAtoi(final String inputString) {

    final String processedInputString = trimLeadingWhiteSpaces(inputString);
    final String numberString = "0123456789";

    boolean isSignPositive = true;
    final List<Integer> digitArray = new ArrayList<>();

    for (final char character : processedInputString.toCharArray()) {
      if (character == '-' || character == '+') {
        if (processedInputString.indexOf(character) == 0) {
          isSignPositive = (character == '+') ? true : false;
          continue;
        } else {
          // Sign encountered at index != 0
          break;
        }
      }

      if (numberString.indexOf(character) == -1) {
        break;
      }

      digitArray.add(Character.getNumericValue(character));
    }

    int stringToInteger = 0;
    int index = digitArray.size() - 1;

    for (final int digit : digitArray) {

      // NOTE: Using double to overcome integer overflow error
      final double temp = Math.pow(10, index--) * digit;

      // This check is to ensure that the stringToInteger is not going out of bounds for a 32 bit
      // integer
      if (isSignPositive && stringToInteger > Integer.MAX_VALUE - temp) {
        return Integer.MAX_VALUE;
      } else if (!isSignPositive && stringToInteger * -1 < Integer.MIN_VALUE + temp) {
        return Integer.MIN_VALUE;
      }

      if (isSignPositive) {
        stringToInteger += temp;
      } else {
        stringToInteger -= temp;
      }
    }

    return stringToInteger;
  }
}
