package com.programming.practice.problems.misc;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their
 * depth.
 *
 * <p>Each element is either an integer, or a list -- whose elements may also be integers or other
 * lists.
 *
 * <pre>
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/nested-list-weight-sum/">Nested List Weight Sum</a>
 */
public final class NestedListWeightSum {

  /** Interface representing an Nested Integer. */
  public interface NestedInteger {
    /** @return true if this NestedInteger holds a single integer, rather than a nested list. */
    public boolean isInteger();

    /**
     * Return null if this NestedInteger holds a nested list
     *
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     */
    public Integer getInteger();

    /** Set this NestedInteger to hold a single integer. */
    public void setInteger(final int value);

    /** Set this NestedInteger to hold a nested list and adds a nested integer to it. */
    public void add(final NestedInteger ni);

    /**
     * Return null if this NestedInteger holds a single integer
     *
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     */
    public List<NestedInteger> getList();
  }

  /**
   * Calculates the sum of all the integers in the list weighted by their depth.
   *
   * @param nestedList The nested list.
   * @return The depth sum.
   */
  public int depthSum(final List<NestedInteger> nestedList) {

    int depthSum = 0;
    for (final NestedInteger nestedInteger : nestedList) {
      depthSum += evaluateListDepth(nestedInteger, 1);
    }
    return depthSum;
  }

  /**
   * Evaluates the depth sum of provided nestedInteger.
   *
   * @param nestedInteger The nested Integer.
   * @param depth The depth.
   * @return The depth sum of the provided nested Integer.
   */
  private int evaluateListDepth(final NestedInteger nestedInteger, final int depth) {
    if (nestedInteger.isInteger()) {
      return depth * nestedInteger.getInteger();
    }

    int depthSum = 0;
    for (final NestedInteger nestedIntegerElement : nestedInteger.getList()) {
      depthSum += evaluateListDepth(nestedIntegerElement, depth + 1);
    }

    return depthSum;
  }
}
