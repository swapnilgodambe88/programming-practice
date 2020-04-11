package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino. (A
 * domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * <p>We may rotate the i-th domino, so that A[i] and B[i] swap values.
 *
 * <p>Return the minimum number of rotations so that all the values in A are the same, or all the
 * values in B are the same.
 *
 * <p>If it cannot be done, return -1.
 *
 * <p>Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 *
 * <p>Output: 2
 *
 * <p>Explanation: The first figure represents the dominoes as given by A and B: before we do any
 * rotations. If we rotate the second and fourth dominoes, we can make every value in the top row
 * equal to 2, as indicated by the second figure.
 *
 * @see <a href = "https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/">Minimum
 *     Domino Rotations For Equal Row</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class MinimumDominoRotationsForEqualRow {

  /**
   * Returns the minimum number of rotations so that all the values in A are the same, or all the
   * values in B are the same.
   *
   * @param A Array representing the top of dominoes.
   * @param B Array representing the bottom of dominoes.
   * @return The minimum number of rotations so that all the values in A are the same, or all the
   *     values in B are the same.
   */
  public int minDominoRotations(final int[] A, final int[] B) {
    final int numberForRotation = getNumberForRotation(A, B);

    if (numberForRotation == -1) {
      return -1;
    }

    final int aCount = getCount(A, numberForRotation);
    final int bCount = getCount(B, numberForRotation);

    final int maxOfAorB = Math.max(aCount, bCount);

    // This condition is introduced when no rotations are required and either of the domino has all
    // same numbers
    if (maxOfAorB == A.length) {
      return 0;
    }

    return A.length - maxOfAorB;
  }

  /**
   * Evaluates both the dominoes and returns the number that can be formed on either of the
   * dominoes. Returns -1 if same number cannot be formed on either of the dominoes.
   *
   * @param A Array representing the top of dominoes.
   * @param B Array representing the bottom of dominoes.
   * @return The number that can be formed on either of the dominoes. Returns -1 if same number
   *     cannot be formed on either of the dominoes.
   */
  private static int getNumberForRotation(final int[] A, final int[] B) {
    final Map<Integer, Set<Integer>> map = new HashMap<>();

    for (int index = 0; index < A.length; ++index) {
      int number = A[index];
      if (!map.containsKey(number)) {
        map.put(number, new HashSet<>());
      }
      map.get(number).add(index);

      number = B[index];
      if (!map.containsKey(number)) {
        map.put(number, new HashSet<>());
      }
      map.get(number).add(index);
    }

    for (final Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
      if (entry.getValue().size() == A.length) {
        return entry.getKey();
      }
    }

    return -1;
  }

  /**
   * Gets a count of the element on the array.
   *
   * @param array The array to evaluate.
   * @param element The element to count.
   * @return The count of element on the array.
   */
  private static int getCount(final int[] array, final int element) {
    int count = 0;
    for (final int number : array) {
      if (number == element) {
        count++;
      }
    }

    return count;
  }
}
