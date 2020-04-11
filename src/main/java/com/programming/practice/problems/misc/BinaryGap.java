package com.programming.practice.problems.misc;

/**
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in
 * the binary representation of N.
 *
 * <p>If there aren't two consecutive 1's, return 0.
 *
 * <pre>
 * Example 1:
 *
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 *
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 *
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/binary-gap/">Binary Gap</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class BinaryGap {

  /**
   * Given a positive integer N, finds and returns the longest distance between two consecutive 1's
   * in the binary representation of N.
   *
   * @param N The number N.
   * @return The longest distance between two consecutive 1's in the binary representation of N.
   */
  public int binaryGap(final int N) {
    final int[] binaryEquivalent = convertNumberToBinary(N);

    int startIndex = Integer.MAX_VALUE, binaryGap = 0;

    for (int endIndex = 0; endIndex < binaryEquivalent.length; ++endIndex) {
      if (binaryEquivalent[endIndex] == 1) {
        binaryGap = Math.max(binaryGap, endIndex - startIndex);
        startIndex = endIndex;
      }
    }

    return binaryGap;
  }

  /**
   * @param N The number N.
   * @return The number of digits required to represent the binary equivalent of N.
   */
  private static int getNumberOfBinaryBits(final int N) {
    int numberOfBinaryBits = 0;
    while (N > Math.pow(2, numberOfBinaryBits) - 1) {
      numberOfBinaryBits++;
    }

    return numberOfBinaryBits;
  }

  /**
   * @param N The number N.
   * @return The binary representation of N.
   */
  private static int[] convertNumberToBinary(final int N) {
    final int numberOfBinaryBits = getNumberOfBinaryBits(N);
    System.out.println(numberOfBinaryBits);

    final int[] binaryEquivalent = new int[numberOfBinaryBits];

    int index = numberOfBinaryBits - 1, divident = N;
    while (divident > 0) {
      binaryEquivalent[index--] = divident % 2;
      divident = Math.floorDiv(divident, 2);
    }

    return binaryEquivalent;
  }
}
