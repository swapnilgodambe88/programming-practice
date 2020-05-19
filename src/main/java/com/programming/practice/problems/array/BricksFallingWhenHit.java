package com.programming.practice.problems.array;

/**
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks. A brick will not drop if and only
 * if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent
 * bricks will not drop.
 *
 * <p>We will do some erasures sequentially. Each time we want to do the erasure at the location (i,
 * j), the brick (if it exists) on that location will disappear, and then some other bricks may drop
 * because of that erasure.
 *
 * <p>Return an array representing the number of bricks that will drop after each erasure in
 * sequence.
 *
 * <pre>
 * Example 1:
 * Input:
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * Output: [2]
 * Explanation:
 * If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 *
 * Example 2:
 * Input:
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * Output: [0,0]
 * Explanation:
 * When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.
 * Note that the erased brick (1, 0) will not be counted as a dropped brick.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/bricks-falling-when-hit/">Bricks Falling When
 *     Hit</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BricksFallingWhenHit {

  private static final int HIT = -1;
  private static final int BRICK = 1;
  private static final int VISITED = 2;

  private int[][] grid;
  private int rows;
  private int cols;

  /**
   * Returns the brick that will drop after each erasure in sequence.
   *
   * @param grid The grid.
   * @param hits The hits array.
   * @return The brick that will drop after each erasure in sequence.
   */
  public int[] hitBricks(final int[][] grid, final int[][] hits) {

    this.grid = grid;
    this.rows = this.grid.length;
    this.cols = this.rows > 0 ? this.grid[0].length : 0;

    markErasedBricks(hits);

    // Run the depth first search from top row in order to know which bricks are left after every
    // erase operation. We should mark these bricks as visited.
    for (int colIdx = 0; colIdx < cols; ++colIdx) {
      if (grid[0][colIdx] == BRICK) {
        dfs(0, colIdx);
      }
    }

    final int[] result = new int[hits.length];

    // Run the hits array in reverse order.
    // We should run a new DFS from here in order to know which cells can be visited.
    // Count the new visited cells except the DFS root cell (because it was erased, it didn't fall)
    for (int index = result.length - 1; index >= 0; --index) {
      final int x = hits[index][0];
      final int y = hits[index][1];

      if (grid[x][y] == HIT) {
        grid[x][y] = BRICK;
        if (isConnected(x, y)) {
          result[index] = dfs(x, y) - 1;
        }
      }
    }

    return result;
  }

  /** Marks bricks with hit as erased. */
  private void markErasedBricks(final int[][] hits) {

    for (final int[] hit : hits) {
      final int x = hit[0];
      final int y = hit[1];

      if (grid[x][y] == BRICK) {
        grid[x][y] = HIT;
      }
    }
  }

  /**
   * @param x The x coordinate.
   * @param y The y coordinate on grid.
   * @return True If the position is valid. Otherwise, false.
   */
  private boolean isPositionValid(final int x, final int y) {
    if (x < 0 || x >= rows || y < 0 || y >= cols) {
      return false;
    }

    return true;
  }

  /**
   * Check if the brick is connected to a no fall brick.
   *
   * @param x The x coordinate.
   * @param y The y coordinate on grid.
   * @return True if the brick is connected to any brick that won't fall.
   */
  private boolean isConnected(final int x, final int y) {
    if (x == 0) {
      return true;
    }

    if (isPositionValid(x - 1, y) && grid[x - 1][y] == VISITED) {
      return true;
    }

    if (isPositionValid(x + 1, y) && grid[x + 1][y] == VISITED) {
      return true;
    }

    if (isPositionValid(x, y - 1) && grid[x][y - 1] == VISITED) {
      return true;
    }

    if (isPositionValid(x, y + 1) && grid[x][y + 1] == VISITED) {
      return true;
    }

    return false;
  }

  /**
   * Run DFS and return number of connected bricks.
   *
   * @param x The x coordinate.
   * @param y The y coordinate on grid.
   * @return The number of connected bricks that would fall.
   */
  private int dfs(final int x, final int y) {
    if (!isPositionValid(x, y) || grid[x][y] != BRICK) {
      return 0;
    }

    grid[x][y] = VISITED;

    int sum = 1;
    sum += dfs(x - 1, y);
    sum += dfs(x + 1, y);
    sum += dfs(x, y - 1);
    sum += dfs(x, y + 1);

    return sum;
  }
}
