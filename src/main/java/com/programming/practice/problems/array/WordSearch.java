package com.programming.practice.problems.array;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * <p>The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once.
 *
 * <pre>
 * Example:
 *
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/word-search/">Word Search</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class WordSearch {

  private char[][] board;
  private int rowCount = 0;
  private int colCount = 0;

  /**
   * Checks whether the word exists in the grid or not.
   *
   * @param board The board to search for the word.
   * @param word The word to search.
   * @return True If the word exists in the grid. Otherwise false.
   */
  public boolean exist(final char[][] board, final String word) {
    this.board = board;
    this.rowCount = board.length;
    this.colCount = (rowCount > 0) ? board[0].length : 0;

    for (int x = 0; x < rowCount; ++x) {
      for (int y = 0; y < colCount; ++y) {
        if (dfs(x, y, new boolean[rowCount][colCount], 0, word)) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Performs DFS search for the word on the grid.
   *
   * @param x The x co-ordinate of the starting point.
   * @param y The y co-ordinate of the starting point.
   * @param visited The array to represent visited positions.
   * @param index The current index to evaluate for DFS.
   * @param word The word to search for DFS.
   * @return True If the word exists. Otherwise false
   */
  private boolean dfs(
      final int x, final int y, final boolean[][] visited, final int index, final String word) {
    if (x < 0 || x >= rowCount || y < 0 || y >= colCount) {
      return false;
    }

    if (visited[x][y] == true) {
      return false;
    }

    if (word.charAt(index) != board[x][y]) {
      return false;
    }

    if (index == word.length() - 1) {
      return true;
    }

    visited[x][y] = true;
    boolean result = false;

    result = dfs(x + 1, y, visited, index + 1, word);
    result = result || dfs(x - 1, y, visited, index + 1, word);
    result = result || dfs(x, y + 1, visited, index + 1, word);
    result = result || dfs(x, y - 1, visited, index + 1, word);

    visited[x][y] = false;

    return result;
  }
}
