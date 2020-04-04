package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You
 * may assume all four edges of the grid are all surrounded by water.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class NumberOfIslands {

  /** Class representing a position on grid. */
  class Position {
    public int x;
    public int y;

    public Position(final int x, final int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(final Object object) {
      if (this == object) {
        return true;
      }

      if (!(object instanceof Position)) {
        return false;
      }

      final Position other = (Position) object;
      if (this.x != other.x) {
        return false;
      }

      if (this.y != other.y) {
        return false;
      }

      return true;
    }
  }

  private char[][] grid;
  private int rowCount;
  private int colCount;
  private Set<Position> visitedPosition;

  /**
   * Counts the number of islands.
   *
   * @param grid The 2D grid map of 1's (land) and 0's (water).
   * @return The number of islands on the grid.
   */
  public int numIslands(final char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    this.grid = grid;
    this.rowCount = grid.length;
    this.colCount = this.rowCount > 0 ? grid[0].length : 0;
    this.visitedPosition = new HashSet<>();

    int numberOfIslands = 0;

    for (int i = 0; i < rowCount; ++i) {
      for (int j = 0; j < colCount; ++j) {
        final Position currentPosition = new Position(i, j);
        if (grid[i][j] == '1' && !visitedPosition.contains(currentPosition)) {
          ++numberOfIslands;
          dfsTraversal(currentPosition);
        }
      }
    }

    return numberOfIslands;
  }

  /**
   * Performs a DFS traversal from the start position, and marks all connected positions (which are
   * 1) as visited.
   *
   * @param startPosition The start position which needs to be unvisited.
   */
  private void dfsTraversal(final Position startPosition) {
    assert !visitedPosition.contains(startPosition);

    final Stack<Position> stack = new Stack<>();
    stack.push(startPosition);

    while (!stack.isEmpty()) {
      final Position poppedPosition = stack.pop();
      visitedPosition.add(poppedPosition);

      final List<Position> unvisitedNeighbors = getUnVisitedNeighbors(poppedPosition);

      unvisitedNeighbors.stream()
          .forEach(
              neighbor -> {
                stack.add(neighbor);
              });
    }
  }

  /**
   * Determines if the position is valid.
   *
   * @param position The position to validate.
   * @return True if the position if valid. Otherwise, false.
   */
  private boolean isPositionValid(final Position position) {

    if (position.x >= 0 && position.x < rowCount && position.y >= 0 && position.y < colCount) {
      return true;
    }

    return false;
  }

  /**
   * Gets the unvisited neighbors which are '1'.
   *
   * @param position The position to evaluate.
   * @return List of unvisited neighbors which are '1'.
   */
  private List<Position> getUnVisitedNeighbors(final Position position) {

    final List<Position> neighbors = new ArrayList<>();

    final Position topPosition = new Position(position.x - 1, position.y);
    if (isPositionValid(topPosition)
        && !visitedPosition.contains(topPosition)
        && grid[topPosition.x][topPosition.y] == '1') {
      neighbors.add(topPosition);
    }

    final Position bottomPosition = new Position(position.x + 1, position.y);
    if (isPositionValid(bottomPosition)
        && !visitedPosition.contains(bottomPosition)
        && grid[bottomPosition.x][bottomPosition.y] == '1') {
      neighbors.add(bottomPosition);
    }

    final Position leftPosition = new Position(position.x, position.y - 1);
    if (isPositionValid(leftPosition)
        && !visitedPosition.contains(leftPosition)
        && grid[leftPosition.x][leftPosition.y] == '1') {
      neighbors.add(leftPosition);
    }

    final Position rightPosition = new Position(position.x, position.y + 1);
    if (isPositionValid(rightPosition)
        && !visitedPosition.contains(rightPosition)
        && grid[rightPosition.x][rightPosition.y] == '1') {
      neighbors.add(rightPosition);
    }

    return neighbors;
  }
}
