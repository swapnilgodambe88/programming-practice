package com.programming.practice.problems.string;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and
 * num2.
 *
 * @see <a href = "https://leetcode.com/problems/add-strings/">Add Strings</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class AddStrings {

  /**
   * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and
   * num2.
   *
   * @param num1 The number 1.
   * @param num2 The number 2.
   * @return The string representing the addition of two digits.
   */
  public String addStrings(final String num1, final String num2) {

    final int length = Math.max(num1.length(), num2.length());

    final int[] number1 = convertStringToIntegerArray(num1, length);
    final int[] number2 = convertStringToIntegerArray(num2, length);

    final int[] addition = new int[length];
    int carry = 0;
    for (int i = length - 1; i >= 0; --i) {
      final int sum = number1[i] + number2[i] + carry;

      addition[i] = sum % 10;
      carry = Math.floorDiv(sum, 10);
    }

    final StringBuffer additionString = new StringBuffer();
    if (carry > 0) {
      additionString.append(carry);
    }

    for (final int digit : addition) {
      additionString.append(digit);
    }

    return additionString.toString();
  }

  /**
   * Converts a string representing number to integer array.
   *
   * @param inputString The input string representing a number.
   * @param arrayLength The array length of the integer array.
   * @return The integer array representation of the numeric string.
   */
  private int[] convertStringToIntegerArray(final String inputString, final int arrayLength) {
    final int[] numberArray = new int[arrayLength];

    for (int i = arrayLength - 1, j = inputString.length() - 1; i >= 0 && j >= 0; --i, --j) {
      numberArray[i] = inputString.charAt(j) - '0';
    }

    return numberArray;
  }
}
