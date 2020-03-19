/** */
package com.programming.practice.problems.misc;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * <p>Example:
 *
 * <p>Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * @see <a href = "https://leetcode.com/problems/permutations/">Permutations</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class Permutations {

  private final List<List<Integer>> permutations = new LinkedList<>();

  /**
   * @param nums The integer array.
   * @return A list of all possible permutations.
   */
  public List<List<Integer>> permute(final int[] nums) {

    for (int i = 0; i < nums.length; i++) {
      generate(i, nums, new LinkedList<>());
    }

    return permutations;
  }

  /**
   * Recursive function to generate the permutations.
   *
   * @param index The index of the nums.
   * @param nums The integer array.
   * @param permutationFormedSoFar The permutation formed so far.
   */
  private void generate(
      final int index, final int[] nums, final List<Integer> permutationFormedSoFar) {

    permutationFormedSoFar.add(nums[index]);

    if (permutationFormedSoFar.size() == nums.length) {
      permutations.add(permutationFormedSoFar);
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (i != index && !permutationFormedSoFar.contains(nums[i])) {
        generate(i, nums, new LinkedList<>(permutationFormedSoFar));
      }
    }
  }
}
