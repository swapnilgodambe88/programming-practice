package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * <p>Note: The solution set must not contain duplicate subsets.
 *
 * <pre>
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/subsets/">Subsets</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class Subsets {

  /**
   * Given a set of distinct integers, nums, return all possible subsets (the power set).
   *
   * @param distinctNums
   * @return
   */
  public List<List<Integer>> subsets(final int[] distinctNums) {

    final List<List<Integer>> subsets = new ArrayList<>();
    final int possibleSubSets = (int) Math.pow(2, distinctNums.length);

    for (int i = 0; i < possibleSubSets; ++i) {
      final int[] reverseBinary = getReverseBinaryEquivalent(i, distinctNums.length);
      subsets.add(convertBinaryToSubset(distinctNums, reverseBinary));
    }

    return subsets;
  }

  /**
   * Converts the number to it's binary equivalent.
   *
   * @param number The number to convert.
   * @param binaryLength The expected length of the binary conversion.
   * @return The reverse binary equivalent of the number.
   */
  private static int[] getReverseBinaryEquivalent(final int number, final int binaryLength) {

    int divident = number;

    final int[] reverseBinary = new int[binaryLength];
    int index = 0;

    while (divident != 0) {
      reverseBinary[index++] = divident % 2;
      divident = Math.floorDiv(divident, 2);
    }

    return reverseBinary;
  }

  /**
   * Converts a binary number to a subset. Examples (for a number [1, 2, 3]):
   *
   * <pre>
   * 010 => [2]
   * 110 => [1, 2]
   * 011 => [2, 3]
   * 111 => [1, 2, 3]
   * </pre>
   *
   * @param distinctNums The array of distinct numbers.
   * @param binary The binary equivalent.
   * @return The equivalent subset.
   */
  private static List<Integer> convertBinaryToSubset(final int[] distinctNums, final int[] binary) {
    final List<Integer> subset = new ArrayList<>();

    for (int i = 0; i < binary.length; ++i) {
      if (binary[i] != 0) {
        subset.add(distinctNums[i]);
      }
    }

    return subset;
  }
}
