package com.programming.practice.problems.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to
 * the following rules:
 *
 * <ul>
 *   <li>Each row must contain the digits 1-9 without repetition.
 *   <li>Each column must contain the digits 1-9 without repetition.
 *   <li>Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * </ul>
 *
 * @see <a href = "https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class ValidSudoku {

  /**
   * 2 dimensional board that will be initialized inside the {@link #isValidSudoku(char[][])
   */
  private char[][] board;

  /**
   * Validates the Sudoku board,
   *
   * @param board Two dimensional array representing the Sudoku board.
   * @return True of the Sudoku board is valid. Otherwise false.
   */
  public boolean isValidSudoku(final char[][] board) {
    this.board = board;

    for (int rowIdx = 0; rowIdx < 9; ++rowIdx) {
      if (!doesRowContainValidDigits(rowIdx)) {
        return false;
      }
    }

    for (int colIdx = 0; colIdx < 9; ++colIdx) {
      if (!doesColumnContainValidDigits(colIdx)) {
        return false;
      }
    }

    for (int rowIdx = 0; rowIdx < 9; rowIdx += 3) {
      for (int colIdx = 0; colIdx < 9; colIdx += 3) {
        if (!doesBlockContainValidDigits(rowIdx, colIdx)) {
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Validates if the row contains valid digits.
   *
   * @param rowIdx The row index.
   * @return True if row is valid, otherwise false.
   */
  private boolean doesRowContainValidDigits(final int rowIdx) {

    final Set<Character> set = new HashSet<>();
    int countDigits = 0;

    for (final char digit : this.board[rowIdx]) {
      if (digit != '.') {
        ++countDigits;
        set.add(digit);
      }
    }

    return set.size() == countDigits;
  }

  /**
   * Validates if the column contains valid digits.
   *
   * @param colIdx The column index.
   * @return True if the column is valid, otherwise false.
   */
  private boolean doesColumnContainValidDigits(final int colIdx) {

    final Set<Character> set = new HashSet<>();
    int countDigits = 0;

    for (int rowIdx = 0; rowIdx < 9; ++rowIdx) {
      final char digit = this.board[rowIdx][colIdx];
      if (digit != '.') {
        ++countDigits;
        set.add(digit);
      }
    }

    return set.size() == countDigits;
  }

  /**
   * Validates if the block contains valid digits.
   *
   * @param rowIdx The top right row index of the block.
   * @param colIdx The top right column index of the block.
   * @return True If the block contains valid digits, otherwise false.
   */
  private boolean doesBlockContainValidDigits(final int rowIdx, final int colIdx) {

    final Set<Character> set = new HashSet<>();
    int countDigits = 0;

    for (int i = rowIdx; i < rowIdx + 3; ++i) {
      for (int j = colIdx; j < colIdx + 3; ++j) {
        final char digit = this.board[i][j];
        if (digit != '.') {
          ++countDigits;
          set.add(digit);
        }
      }
    }

    return set.size() == countDigits;
  }
}
