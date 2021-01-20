package com.programming.practice.problems.string;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * <pre>
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/add-binary/">Add Binary</a>
 */
public final class AddBinary {

  /**
   * Adds the two binary strings and returns the result.
   *
   * @param a The binary string a.
   * @param b The binary string b.
   * @return The sum of two binary strings.
   */
  public String addBinary(final String a, final String b) {
    final StringBuffer reverseResult = new StringBuffer();

    int aIndex = a.length() - 1;
    int bIndex = b.length() - 1;

    int carryOver = 0;
    while (aIndex >= 0 && bIndex >= 0) {
      final int aInteger = Integer.parseInt(String.valueOf(a.charAt(aIndex--)));
      final int bInteger = Integer.parseInt(String.valueOf(b.charAt(bIndex--)));

      if (carryOver + aInteger + bInteger == 3) {
        carryOver = 1;
        reverseResult.append("1");
      } else if (carryOver + aInteger + bInteger == 2) {
        carryOver = 1;
        reverseResult.append("0");
      } else if (carryOver + aInteger + bInteger == 1) {
        carryOver = 0;
        reverseResult.append("1");
      } else {
        carryOver = 0;
        reverseResult.append("0");
      }
    }

    // Iterate over the remaining bits on 'a' string
    while (aIndex >= 0) {
      final int aInteger = Integer.parseInt(String.valueOf(a.charAt(aIndex--)));

      if (carryOver + aInteger == 2) {
        carryOver = 1;
        reverseResult.append("0");
      } else if (carryOver + aInteger == 1) {
        carryOver = 0;
        reverseResult.append("1");
      } else {
        carryOver = 0;
        reverseResult.append("0");
      }
    }

    // Iterate over the remaining bits on 'b' string
    while (bIndex >= 0) {
      final int bInteger = Integer.parseInt(String.valueOf(b.charAt(bIndex--)));

      if (carryOver + bInteger == 2) {
        carryOver = 1;
        reverseResult.append("0");
      } else if (carryOver + bInteger == 1) {
        carryOver = 0;
        reverseResult.append("1");
      } else {
        carryOver = 0;
        reverseResult.append("0");
      }
    }

    // Add carryOver if any
    if (carryOver == 1) {
      reverseResult.append("1");
    }

    // Reverse the string and return.
    return reverseResult.reverse().toString();
  }
}
