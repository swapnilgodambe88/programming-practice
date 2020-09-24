package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * In a given grid, each cell can have one of three values:
 * <ul>
 * <li>the value 0 representing an empty cell;</li>
 * <li>the value 1 representing a fresh orange;</li>
 * <li>the value 2 representing a rotten orange.</li>
 * </ul>
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes
 * rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this
 * is impossible, return -1 instead.
 *
 * <pre>
 * Example 1:
 *
 * Input: [[2,1,1],[1,1,0],[0,1,1]] Output: 4
 *
 * Example 2:
 *
 * Input: [[2,1,1],[0,1,1],[1,0,1]] Output: -1 Explanation: The orange in the bottom left corner
 * (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 *
 * Example 3:
 *
 * Input: [[0,2]] Output: 0 Explanation: Since there are already no fresh oranges at minute 0, the
 * answer is just 0.
 *
 * <pre>
 *
 * @see <a href = "https://leetcode.com/problems/rotting-oranges/">Rotting Oranges</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class RottingOranges {

  private static final int FRESH = 1;
  private static final int ROTTEN = 2;

  /** A class representing a position on the grid. */
  class Position {
    public final int x;
    public final int y;

    /**
     * Public constructor for {@link Position}
     *
     * @param x The x coordinate of the position.
     * @param y The y coordinate of the position.
     */
    public Position(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
      final StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append("(").append(x).append(", ").append(y).append(")");

      return stringBuffer.toString();
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object object) {
      if (this == object) {
        return true;
      }

      if (object instanceof Position) {
        final Position other = (Position) object;

        if (x != other.x || y != other.y) {
          return false;
        }

        return true;
      }

      return false;
    }
  }

  /**
   * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this
   * is impossible, return -1 instead.
   *
   * @param grid The grid representing the oranges.
   * @return The minimum number of minutes that must elapse until no cell has a fresh orange. If
   *     this is impossible, return -1 instead.
   */
  public int orangesRotting(final int[][] grid) {

    // If the grid contains no fresh apples then no need to invoke the BFS functionality
    if (getFreshOrangeCount(grid) == 0) {
      return 0;
    }

    return BFS(grid);
  }

  /**
   * Returns a list of positions containing the rotten oranges in the grid.
   *
   * @param grid The grid.
   * @return The list of positions containing the rotten oranges in the grid.
   */
  private List<Position> getAllRottenOrangePosition(final int[][] grid) {
    final int rows = grid.length;
    final int cols = rows > 0 ? grid[0].length : 0;

    final List<Position> rottenOrangesPosition = new ArrayList<>();
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (grid[i][j] == ROTTEN) {
          rottenOrangesPosition.add(new Position(i, j));
        }
      }
    }

    return rottenOrangesPosition;
  }

  /**
   * Returns the count of fresh oranges in the grid.
   *
   * @param grid The grid containing the oranges.
   * @return The count of fresh oranges in the grid.
   */
  private int getFreshOrangeCount(final int[][] grid) {
    final int rows = grid.length;
    final int cols = rows > 0 ? grid[0].length : 0;
    int freshOrangesCount = 0;

    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (grid[i][j] == FRESH) {
          ++freshOrangesCount;
        }
      }
    }

    return freshOrangesCount;
  }

  /**
   * Performs a BFS traversal and returns the elapsed time to rot all the oranges.
   *
   * @param grid The grid.
   * @return The minimum number of minutes that must elapse until no cell has a fresh orange. If
   *     this is impossible, return -1 instead.
   */
  private int BFS(final int[][] grid) {

    // Initialize the elapsedMinutes to -1
    int elapsedMinutes = -1;
    final Queue<Position> queue = new LinkedList<>();

    // We need to add all the rotten oranges in the queue at once because all the oranges will start
    // rotting neighboring oranges at once
    queue.addAll(getAllRottenOrangePosition(grid));

    final Set<Position> visitedPosition = new HashSet<>();

    while (!queue.isEmpty()) {
      elapsedMinutes++;

      final int numberOfQueueElements = queue.size();
      for (int i = 0; i < numberOfQueueElements; ++i) {

        final Position poppedElement = queue.poll();
        visitedPosition.add(poppedElement);

        final List<Position> neighbors = getFreshNeighbors(poppedElement, grid);

        for (final Position neighbor : neighbors) {
          if (!visitedPosition.contains(neighbor)) {
            grid[neighbor.x][neighbor.y] = ROTTEN;
            queue.add(neighbor);
          }
        }
      }
    }

    // If there are still fresh oranges that means some fresh oranges and disconnected, and hence
    // return -1
    return getFreshOrangeCount(grid) == 0 ? elapsedMinutes : -1;
  }

  /**
   * Returns all the neighboring fresh oranges.
   *
   * @param position The current position on the grid.
   * @param grid The grid.
   * @return The neighboring fresh oranges.
   */
  private List<Position> getFreshNeighbors(final Position position, final int[][] grid) {
    final List<Position> neighbors = new ArrayList<>();

    final Position topPosition = new Position(position.x - 1, position.y);
    if (isPositionValid(topPosition, grid) && grid[topPosition.x][topPosition.y] == FRESH) {
      neighbors.add(topPosition);
    }

    final Position bottomPosition = new Position(position.x + 1, position.y);
    if (isPositionValid(bottomPosition, grid)
        && grid[bottomPosition.x][bottomPosition.y] == FRESH) {
      neighbors.add(bottomPosition);
    }

    final Position leftPosition = new Position(position.x, position.y - 1);
    if (isPositionValid(leftPosition, grid) && grid[leftPosition.x][leftPosition.y] == FRESH) {
      neighbors.add(leftPosition);
    }

    final Position rightPosition = new Position(position.x, position.y + 1);
    if (isPositionValid(rightPosition, grid) && grid[rightPosition.x][rightPosition.y] == FRESH) {
      neighbors.add(rightPosition);
    }

    return neighbors;
  }

  /**
   * Checks if the position is valid.
   *
   * @param position The position to evaluate.
   * @param grid The grid.
   * @return True if the position is valid. Otherwise false.
   */
  private boolean isPositionValid(final Position position, final int[][] grid) {
    final int rows = grid.length;
    final int cols = rows > 0 ? grid[0].length : 0;

    if (position.x >= 0 && position.x < rows && position.y >= 0 && position.y < cols) {
      return true;
    }

    return false;
  }
}
