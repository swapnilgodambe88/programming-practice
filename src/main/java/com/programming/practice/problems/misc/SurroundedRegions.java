package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * <p>A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * <pre>
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 *
 * Explanation:
 *
 * <p>Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the
 * board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O'
 * on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells
 * connected horizontally or vertically.
 *
 * @see <a href = "https://leetcode.com/problems/surrounded-regions/">Surrounded Regions</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class SurroundedRegions {

  /** Class to represent position in a board. */
  class Position {
    public final int x;
    public final int y;

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
      if (x != other.x) {
        return false;
      }

      if (y != other.y) {
        return false;
      }

      return true;
    }
  }

  /**
   * 2 dimensional board that will be initialized inside the {@link #solve(char[][])
   */
  private char[][] board;

  private int rows;
  private int cols;

  /** A set to keep track of visited positions on the board. */
  private Set<Position> visitedPositions;

  /**
   * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
   *
   * @param board The 2D board.
   */
  public void solve(final char[][] board) {
    this.board = board;
    this.visitedPositions = new HashSet<>();
    this.rows = this.board.length;
    this.cols = this.rows > 0 ? this.board[0].length : 0;

    for (int rowIdx = 0; rowIdx < rows; ++rowIdx) {
      for (int colIdx = 0; colIdx < cols; ++colIdx) {
        markRegionAsOccupiedUsingDFS(new Position(rowIdx, colIdx));
      }
    }
  }

  /**
   * Using DFS algorithm, marks the the entire region containing the position as occupied if
   * surrounded by X.
   *
   * @param rowIdx The row index on the board.
   * @param colIdx The column index on the board.
   * @throws IllegalArgumentException If the rowIdx and colIdx are not valid.
   */
  private void markRegionAsOccupiedUsingDFS(final Position position) {

    // No need to evaluate the position if it is already visited or if it is X
    if (visitedPositions.contains(position) || board[position.x][position.y] == 'X') {
      return;
    }

    boolean canRegionBeOccupied = true;
    if (isPositionAtBoundary(position)) {
      canRegionBeOccupied = false;
    }

    // A set to keep track of positions visited in this iteration. If region can be occupied, then
    // all these positions will be marked as X
    final Set<Position> visitedPositionsInThisDFS = new HashSet<>();

    final Stack<Position> stack = new Stack<>();
    stack.add(position);

    while (!stack.isEmpty()) {
      final Position poppedPosition = stack.pop();

      visitedPositionsInThisDFS.add(poppedPosition);
      visitedPositions.add(poppedPosition);

      final List<Position> zeroNeighbors =
          getUnvisitedNeighborsWithMatchingPattern(poppedPosition, 'O');

      for (final Position neighbor : zeroNeighbors) {

        if (isPositionAtBoundary(neighbor)) {
          canRegionBeOccupied = false;
        }

        stack.add(neighbor);
      }
    }

    if (canRegionBeOccupied) {
      for (final Position positionToOccupy : visitedPositionsInThisDFS) {
        board[positionToOccupy.x][positionToOccupy.y] = 'X';
      }
    }
  }

  /**
   * Utility function to determine if a position is valid on the board.
   *
   * @param position The position on the board.
   * @return True If the position is valid. Otherwise, false.
   */
  private boolean isPositionValid(final Position position) {
    if (position.x >= 0 && position.x < rows && position.y >= 0 && position.y < cols) {
      return true;
    }

    return false;
  }

  /**
   * Utility function to return the neighbors (top, bottom, left, right) that matches the matching
   * pattern.
   *
   * @param position The position on board
   * @param matchingPattern The matching pattern to match the neighbor to.
   * @return True The neighbors.
   */
  private List<Position> getUnvisitedNeighborsWithMatchingPattern(
      final Position position, final char matchingPattern) {

    final List<Position> unvisitedNeighbors = new ArrayList<>();

    // Top neighbor
    final Position topPosition = new Position(position.x - 1, position.y);
    if (isPositionValid(topPosition)
        && !visitedPositions.contains(topPosition)
        && board[topPosition.x][topPosition.y] == matchingPattern) {
      unvisitedNeighbors.add(topPosition);
    }

    // Bottom neighbor
    final Position bottomPosition = new Position(position.x + 1, position.y);
    if (isPositionValid(bottomPosition)
        && !visitedPositions.contains(bottomPosition)
        && board[bottomPosition.x][bottomPosition.y] == matchingPattern) {
      unvisitedNeighbors.add(bottomPosition);
    }

    // left neighbor
    final Position leftPosition = new Position(position.x, position.y - 1);
    if (isPositionValid(leftPosition)
        && !visitedPositions.contains(leftPosition)
        && board[leftPosition.x][leftPosition.y] == matchingPattern) {
      unvisitedNeighbors.add(leftPosition);
    }

    // right neighbor
    final Position rightPosition = new Position(position.x, position.y + 1);
    if (isPositionValid(rightPosition)
        && !visitedPositions.contains(rightPosition)
        && board[rightPosition.x][rightPosition.y] == matchingPattern) {
      unvisitedNeighbors.add(rightPosition);
    }

    return unvisitedNeighbors;
  }

  /**
   * Utility function to determine if the position is at boundary of the board.
   *
   * @param rowIdx The position on the board
   * @throws AssertionError If assertions are enabled, and position provided is not valid
   */
  private boolean isPositionAtBoundary(final Position position) {

    assert isPositionValid(position) : "Invalid position passed to the function.";

    if (position.x == 0 || position.x == rows - 1 || position.y == 0 || position.y == cols - 1) {
      return true;
    }

    return false;
  }
}
