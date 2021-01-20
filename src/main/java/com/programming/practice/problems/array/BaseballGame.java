package com.programming.practice.problems.array;

import java.util.Stack;

/**
 * You are keeping score for a baseball game with strange rules. The game consists of several
 * rounds, where the scores of past rounds may affect future rounds' scores.
 *
 * <p>At the beginning of the game, you start with an empty record. You are given a list of strings
 * ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 *
 * <ul>
 *   <li>An integer x - Record a new score of x.
 *   <li>"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there
 *       will always be two previous scores.
 *   <li>"D" - Record a new score that is double the previous score. It is guaranteed there will
 *       always be a previous score.
 *   <li>"C" - Invalidate the previous score, removing it from the record. It is guaranteed there
 *       will always be a previous score.
 * </ul>
 *
 * <p>Return the sum of all the scores on the record.
 *
 * <pre>
 * Example 1:
 *
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 *
 * Example 2:
 *
 * Input: ops = ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "-2" - Add -2 to the record, record is now [5, -2].
 * "4" - Add 4 to the record, record is now [5, -2, 4].
 * "C" - Invalidate and remove the previous score, record is now [5, -2].
 * "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
 * "9" - Add 9 to the record, record is now [5, -2, -4, 9].
 * "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
 * "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
 * The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
 *
 * Example 3:
 *
 * Input: ops = ["1"]
 * Output: 1
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/baseball-game/">Baseball Game</a>
 */
public class BaseballGame {

  /** An enumeration representing the operations. */
  enum Operation {
    INVALIDATE("C"),
    DOUBLE("D"),
    ADD("+");

    private final String op;

    /**
     * Constructor for {@link Operation}.
     *
     * @param op The string representation of operation.
     */
    Operation(final String op) {
      this.op = op;
    }

    /** @return The string representation of the operation. */
    String getOp() {
      return op;
    }
  }

  /**
   * Calculates the points in the Baseball game.
   *
   * @param ops The operation stack.
   * @return The sum of points at the end of the Baseball game.
   */
  public int calPoints(final String[] ops) {
    final Stack<Integer> stack = new Stack<>();

    for (final String operation : ops) {
      if (operation.equals(Operation.INVALIDATE.getOp())) {
        stack.pop();
      } else if (operation.equals(Operation.DOUBLE.getOp())) {
        final int topResult = stack.peek();

        stack.push(topResult * 2);
      } else if (operation.equals(Operation.ADD.getOp())) {
        final int result1 = stack.pop();
        final int result2 = stack.pop();

        stack.push(result2);
        stack.push(result1);
        stack.push(result1 + result2);
      } else {
        stack.push(Integer.parseInt(operation));
      }
    }

    int totalPoints = 0;
    while (!stack.isEmpty()) {
      totalPoints += stack.pop();
    }

    return totalPoints;
  }
}
