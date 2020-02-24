package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all
 * unique combinations in candidates where the candidate numbers sums to target.
 *
 * <p>Each number in candidates may only be used once in the combination.
 *
 * <p>Note:
 *
 * <p>All numbers (including target) will be positive integers. The solution set must not contain
 * duplicate combinations.
 *
 * <p>Example 1:
 *
 * <p>Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1, 7], [1, 2, 5], [2,
 * 6], [1, 1, 6] ] Example 2:
 *
 * <p>Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [ [1,2,2], [5] ]
 *
 * @see <a href = "https://leetcode.com/problems/combination-sum-ii/">Combination Sum II</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CombinationSum2 extends CombinationSum {

  /**
   * Find all unique combinations in candidates where the candidate numbers sum to target (Any
   * element in the combination cannot be used repeatedly to get to the sum).
   *
   * @param candidates The candidates array to evaluate.
   * @param target The target for the combination sum.
   * @return List of candidate numbers.
   */
  public final List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
    Arrays.sort(candidates);

    this.candidates = candidates;
    this.target = target;

    final boolean allowDuplicates = false;
    for (int i = 0; i < this.candidates.length; ++i) {
      recursion(i, new ArrayList<>(), 0, allowDuplicates);
    }

    return combinationSumList.stream().collect(Collectors.toList());
  }
}
