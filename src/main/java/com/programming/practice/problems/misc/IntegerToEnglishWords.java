package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to
 * be less than 231 - 1.
 *
 * <pre>
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/integer-to-english-words/">Integer to English</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class IntegerToEnglishWords {

  private static Map<Integer, String> MAP = new HashMap<>();

  /** An enumeration representing denominations. */
  private enum Denomination {
    ONE_BILLION(1000000000),
    ONE_MILLION(1000000),
    ONE_THOUSAND(1000);

    /** The integer value of the denomination. */
    private final int number;

    /**
     * Public constructor for {@link Denomination}.
     *
     * @param number The integer value associated with the denomination.
     */
    Denomination(final int number) {
      this.number = number;
    }

    /** @return The integer value of the denomination. */
    public int getValue() {
      return number;
    }
  }

  static {
    MAP.put(1, "One");
    MAP.put(2, "Two");
    MAP.put(3, "Three");
    MAP.put(4, "Four");
    MAP.put(5, "Five");
    MAP.put(6, "Six");
    MAP.put(7, "Seven");
    MAP.put(8, "Eight");
    MAP.put(9, "Nine");
    MAP.put(10, "Ten");
    MAP.put(11, "Eleven");
    MAP.put(12, "Twelve");
    MAP.put(13, "Thirteen");
    MAP.put(14, "Fourteen");
    MAP.put(15, "Fifteen");
    MAP.put(16, "Sixteen");
    MAP.put(17, "Seventeen");
    MAP.put(18, "Eighteen");
    MAP.put(19, "Nineteen");
    MAP.put(20, "Twenty");
    MAP.put(30, "Thirty");
    MAP.put(40, "Forty");
    MAP.put(50, "Fifty");
    MAP.put(60, "Sixty");
    MAP.put(70, "Seventy");
    MAP.put(80, "Eighty");
    MAP.put(90, "Ninety");
  }

  /**
   * Converts a number to word.
   *
   * @param number The number to convert.
   * @return The string value of the conversion.
   */
  public String numberToWords(final int number) {

    if (number == 0) {
      return "Zero";
    }

    int tempNumber = number;
    final StringBuffer conversion = new StringBuffer();

    if (tempNumber >= Denomination.ONE_BILLION.getValue()) {
      final int billionNumber = Math.floorDiv(tempNumber, Denomination.ONE_BILLION.getValue());

      conversion.append(convertThreeDigitNumber(billionNumber));
      conversion.append(" Billion ");
      tempNumber = tempNumber % Denomination.ONE_BILLION.getValue();
    }

    if (tempNumber >= Denomination.ONE_MILLION.getValue()) {
      final int millionNumber = Math.floorDiv(tempNumber, Denomination.ONE_MILLION.getValue());

      conversion.append(convertThreeDigitNumber(millionNumber));
      conversion.append(" Million ");
      tempNumber = tempNumber % Denomination.ONE_MILLION.getValue();
    }

    if (tempNumber >= Denomination.ONE_THOUSAND.getValue()) {
      final int thousandNumber = Math.floorDiv(tempNumber, Denomination.ONE_THOUSAND.getValue());

      conversion.append(convertThreeDigitNumber(thousandNumber));
      conversion.append(" Thousand ");
      tempNumber = tempNumber % Denomination.ONE_THOUSAND.getValue();
    }

    if (tempNumber > 0) {
      conversion.append(convertThreeDigitNumber(tempNumber));
    }

    return conversion.toString().trim();
  }

  /**
   * Converts a three digit number to a word.
   *
   * @param number The number to convert.
   * @return The three digit conversion.
   */
  private static String convertThreeDigitNumber(final int number) {
    assert number <= 999 && number > 0;

    final int lastTwoDigits = number % 100;
    final int firstDigit = Math.floorDiv(number, 100);

    final StringBuffer conversion = new StringBuffer();

    if (firstDigit > 0) {
      conversion.append(MAP.get(firstDigit)).append(" Hundred ");
    }

    if (lastTwoDigits > 0) {
      conversion.append(convertTwoDigitNumber(lastTwoDigits));
    }

    return conversion.toString().trim();
  }

  /**
   * Converts a two digit number to word.
   *
   * @param number The number to convert.
   * @return The two digit number conversion.
   */
  private static String convertTwoDigitNumber(final int number) {
    assert number >= 0 && number < 100;

    final StringBuffer conversion = new StringBuffer();

    if (number <= 20) {
      return conversion.append(MAP.get(number)).toString();
    }

    final int lastDigit = number % 10;
    final int firstDigit = Math.floorDiv(number, 10);

    if (firstDigit > 0) {
      conversion.append(MAP.get(firstDigit * 10)).append(" ");
    }

    if (lastDigit > 0) {
      conversion.append(MAP.get(lastDigit));
    }

    return conversion.toString().trim();
  }
}
