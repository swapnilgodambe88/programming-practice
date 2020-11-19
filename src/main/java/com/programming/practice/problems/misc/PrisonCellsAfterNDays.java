package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 *
 * <p>Each day, whether the cell is occupied or vacant changes according to the following rules:
 *
 * <ul>
 *   <li>If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell
 *       becomes occupied.
 *   <li>Otherwise, it becomes vacant.
 * </ul>
 *
 * (Note that because the prison is a row, the first and the last cells in the row can't have two
 * adjacent neighbors.)
 *
 * <p>We describe the current state of the prison in the following way: cells[i] == 1 if the i-th
 * cell is occupied, else cells[i] == 0.
 *
 * <p>Given the initial state of the prison, return the state of the prison after N days (and N such
 * changes described above.)
 *
 * <pre>
 * Example 1:
 *
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * Example 2:
 *
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/prison-cells-after-n-days/solution/">Prison Cells
 *     After N Days</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class PrisonCellsAfterNDays {

  /**
   * @param cells
   * @param N
   * @return
   */
  public int[] prisonAfterNDays(int[] cells, final int N) {

    int count = 0;
    final Set<String> sequence = new LinkedHashSet<>();

    boolean hasCycle = false;
    while (count < N) {
      final int[] nextDayCells = getNextDayCells(cells);
      final String cellRepresentation = Arrays.toString(nextDayCells);

      if (!sequence.contains(cellRepresentation)) {
        sequence.add(cellRepresentation);
      } else {
        hasCycle = true;
        break;
      }

      count++;
      cells = nextDayCells;
    }

    if (hasCycle) {
      final int loopCount = N % sequence.size();

      for (int i = 0; i < loopCount; ++i) {
        cells = getNextDayCells(cells);
      }
    }

    return cells;
  }

  private int[] getNextDayCells(final int[] cells) {
    final int[] nextDay = new int[cells.length];

    nextDay[0] = 0;
    nextDay[cells.length - 1] = 0;

    for (int i = 1; i < cells.length - 1; ++i) {
      if (cells[i - 1] == cells[i + 1]) {
        nextDay[i] = 1;
      } else {
        nextDay[i] = 0;
      }
    }

    return nextDay;
  }
}
