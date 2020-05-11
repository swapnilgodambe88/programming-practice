package com.programming.practice.problems.array;

/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 *
 * <p>Given a 2D integer array board representing the grid of candy, different positive integers
 * board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the
 * cell at position (i, j) is empty. The given board represents the state of the game following the
 * player's move. Now, you need to restore the board to a stable state by crushing candies according
 * to the following rules:
 *
 * <ol>
 *   <li>If three or more candies of the same type are adjacent vertically or horizontally, "crush"
 *       them all at the same time - these positions become empty.
 *   <li>After crushing all candies simultaneously, if an empty space on the board has candies on
 *       top of itself, then these candies will drop until they hit a candy or bottom at the same
 *       time. (No new candies will drop outside the top boundary.)
 *   <li>After the above steps, there may exist more candies that can be crushed. If so, you need to
 *       repeat the above steps.
 *   <li>If there does not exist more candies that can be crushed (ie. the board is stable), then
 *       return the current board.
 * </ol>
 *
 * You need to perform the above rules until the board becomes stable, then return the current
 * board.
 *
 * <pre>
 * Example:
 *
 * Input:
 * board =
 * [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
 *
 * Output:
 * [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/candy-crush/">Candy Crush</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CandyCrush {

  private int[][] board;
  private int rows;
  private int cols;

  /**
   * Performs the candy crush and returns the stable board.
   *
   * @param board The initial state of board.
   * @return The stable state of board.
   */
  public int[][] candyCrush(final int[][] board) {
    this.board = board;
    this.rows = this.board.length;
    this.cols = this.rows != 0 ? this.board[0].length : 0;

    final boolean crushHappened = crush();
    if (crushHappened) {
      drop();
      return candyCrush(this.board);
    }

    return this.board;
  }

  /**
   * After crushing all candies simultaneously, if an empty space on the board has candies on top of
   * itself, then these candies will drop until they hit a candy or bottom at the same time.
   */
  private void drop() {
    for (int colIdx = 0; colIdx < cols; ++colIdx) {
      int nonZeroElementIndex = rows - 1;

      for (int rowIdx = rows - 1; rowIdx >= 0; --rowIdx) {
        if (board[rowIdx][colIdx] != 0) {
          board[nonZeroElementIndex--][colIdx] = board[rowIdx][colIdx];
        }
      }

      while (nonZeroElementIndex >= 0) {
        board[nonZeroElementIndex--][colIdx] = 0;
      }
    }
  }

  /**
   * If three or more candies of the same type are adjacent vertically or horizontally, "crush" them
   * all at the same time - these positions become empty.
   *
   * @return True If crush happened. Otherwise, false.
   */
  private boolean crush() {
    final boolean[][] crushMask = new boolean[rows][cols];
    boolean crushHappened = false;

    // Crush vertically
    for (int i = 0; i + 2 < rows; ++i) {
      for (int j = 0; j < cols; ++j) {

        if (board[i][j] != 0 && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j]) {
          crushHappened = true;
          crushMask[i][j] = true;
          crushMask[i + 1][j] = true;
          crushMask[i + 2][j] = true;
        }
      }
    }

    // Crush horizontally
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j + 2 < cols; ++j) {

        if (board[i][j] != 0 && board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]) {
          crushHappened = true;
          crushMask[i][j] = true;
          crushMask[i][j + 1] = true;
          crushMask[i][j + 2] = true;
        }
      }
    }

    // Perform crush
    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < cols; ++j) {
        if (crushMask[i][j]) {
          board[i][j] = 0;
        }
      }
    }

    return crushHappened;
  }
}
