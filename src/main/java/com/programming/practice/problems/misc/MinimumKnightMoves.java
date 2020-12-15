package com.programming.practice.problems.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at
 * square [0, 0].
 *
 * <p>A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a
 * cardinal direction, then one square in an orthogonal direction.
 *
 * <p>Return the minimum number of steps needed to move the knight to the square [x, y]. It is
 * guaranteed the answer exists.
 *
 * <pre>
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 *
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/minimum-knight-moves/">Minimum Knight Moves</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumKnightMoves {

  private final int[][] directions =
      new int[][] {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {-2, -1}, {-1, -2}};

  /**
   * Return the minimum number of steps needed to move the knight to the square [x, y]. It is
   * guaranteed the answer exists.
   *
   * @param x The x-coordinate.
   * @param y The y-coordinate.
   * @return The minimum number of steps needed to move the knight to the square [x, y]. It is
   *     guaranteed the answer exists.
   */
  public int minKnightMoves(final int x, final int y) {

    // Covering the base cases
    if (x == 0 && y == 0) {
      return 0;
    }
    if (x == 1 && y == 1) {
      return 2;
    }

    // Since all four quadrants are similar, we only carry the search on the positive quadrant.
    final int obsX = Math.abs(x);
    final int obsY = Math.abs(y);

    final Queue<int[]> queue = new LinkedList<>();
    final Set<String> visitedCells = new HashSet<>();

    queue.add(new int[] {0, 0});
    visitedCells.add("0_0");

    int moves = 0;
    while (!queue.isEmpty()) {
      final int count = queue.size();

      for (int i = 0; i < count; ++i) {
        final int[] poppedCell = queue.remove();

        if (poppedCell[0] == obsX && poppedCell[1] == obsY) {
          return moves;
        }

        for (final int[] direction : directions) {
          final int[] neighbor =
              new int[] {poppedCell[0] + direction[0], poppedCell[1] + direction[1]};
          final String neighborString = neighbor[0] + "-" + neighbor[1];

          if (neighbor[0] >= 0 && neighbor[1] >= 0 && !visitedCells.contains(neighborString)) {
            queue.add(neighbor);
            visitedCells.add(neighborString);
          }
        }
      }

      moves++;
    }

    return -1;
  }
}
