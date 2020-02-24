package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * <p>For example, given n = 3, a solution set is:
 *
 * <p>[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * @see <a href = "https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a>
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
final class GenerateParentheses {

  /** Private member variable to store all possible combination of parenthesis. */
  private List<String> combinationList = new ArrayList<>();

  /**
   * Generate all possible combination of parentheses for a given n.
   *
   * @param n The number n.
   * @return List of possible combination of parentheses.
   */
  public List<String> generateParenthesis(final int n) {

    if (n > 0) {
      addParenthesis("", 0, 0, n);
    }

    return combinationList;
  }

  /**
   * Recursive function to add a parenthesis to the stringFormedSoFar.
   *
   * @param stringFormedSoFar The string formed so far.
   * @param openCount The count of opening brackets.
   * @param closeCount The count of closing brackets.
   * @param n The number n.
   */
  private void addParenthesis(
      final String stringFormedSoFar, final int openCount, final int closeCount, final int n) {

    if (stringFormedSoFar.length() == 2 * n) {
      combinationList.add(stringFormedSoFar);
      return;
    }

    if (openCount < n) {
      addParenthesis(stringFormedSoFar + "(", openCount + 1, closeCount, n);
    }

    if (closeCount < openCount) {
      addParenthesis(stringFormedSoFar + ")", openCount, closeCount + 1, n);
    }
  }
}
