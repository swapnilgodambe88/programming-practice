package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * <p>The same repeated number may be chosen from candidates unlimited number of times.
 *
 * <p>Note:
 *
 * <p>All numbers (including target) will be positive integers. The solution set must not contain
 * duplicate combinations. Example 1:
 *
 * <p>Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7], [2,2,3] ]
 *
 * <p>Example 2:
 *
 * <p>Input: candidates = [2,3,5], target = 8, A solution set is: [ [2,2,2,2], [2,3,3], [3,5] ]
 *
 * @see <a href = "https://leetcode.com/problems/combination-sum/">Combination Sum</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
class CombinationSum {

  /**
   * List of combination list to store all possible combinations which sums to target.<br>
   * NOTE: Using set instead of list to remove duplicate combinations
   */
  protected Set<List<Integer>> combinationSumList = new HashSet<>();

  /** The candidate array. This will be initialized inside {@link #combinationSumList}. */
  protected int[] candidates;

  /**
   * The target for the combination sum. This will be initialized inside {@link
   * #combinationSumList}.
   */
  protected int target;

  /**
   * Helper method to obtain a deep copy of provided list.
   *
   * @param list The list.
   * @return The deep copy of the list.
   */
  protected static final List<Integer> getDeepCopy(final List<Integer> list) {
    final List<Integer> copy = new ArrayList<>();

    for (final int element : list) {
      copy.add(element);
    }

    return copy;
  }

  /**
   * Recursion method to perform the combination sum logic.
   *
   * @param index The index under consideration.
   * @param combinationSoFar The combination list so far.
   * @param sumSoFar The sum so far.
   * @param allowDuplicates Boolean to indicate if the combination can use the same element
   *     repeatedly for sum.
   */
  protected final void recursion(
      final int index,
      final List<Integer> combinationSoFar,
      int sumSoFar,
      final boolean allowDuplicates) {

    // NOTE: Deep copy is required to that we don't end up with a reference of list which is altered
    // by all recursive calls.
    final List<Integer> combinationSoFarCopy = getDeepCopy(combinationSoFar);

    sumSoFar += candidates[index];
    combinationSoFarCopy.add(candidates[index]);

    if (sumSoFar > target) {
      return;
    } else if (sumSoFar == target) {
      combinationSumList.add(combinationSoFarCopy);
      return;
    }

    int i = allowDuplicates ? index : index + 1;
    for (; i < candidates.length; ++i) {
      recursion(i, combinationSoFarCopy, sumSoFar, allowDuplicates);
    }
  }

  /**
   * Find all unique combinations in candidates where the candidate numbers sum to target (Any
   * element in the combination can be used repeatedly to get to the sum).
   *
   * @param candidates The candidates array to evaluate.
   * @param target The target for the combination sum.
   * @return List of candidate numbers.
   */
  public final List<List<Integer>> combinationSum(final int[] candidates, final int target) {
    Arrays.sort(candidates);

    this.candidates = candidates;
    this.target = target;

    final boolean allowDuplicates = true;
    for (int i = 0; i < this.candidates.length; ++i) {
      recursion(i, new ArrayList<>(), 0, allowDuplicates);
    }

    return combinationSumList.stream().collect(Collectors.toList());
  }
}
