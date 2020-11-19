package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link PrisonCellsAfterNDays}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PrisonCellsAfterNDaysTest {

  private final PrisonCellsAfterNDays obj = new PrisonCellsAfterNDays();

  @Test
  public void testScenario1() {
    final int[] cells = new int[] {0, 1, 0, 1, 1, 0, 0, 1};
    final int[] expectedCellsState = new int[] {0, 0, 1, 1, 0, 0, 0, 0};

    Assert.assertArrayEquals(expectedCellsState, obj.prisonAfterNDays(cells, 7));
  }

  @Test
  public void testScenario2() {
    final int[] cells = new int[] {1, 0, 0, 1, 0, 0, 1, 0};
    final int[] expectedCellsState = new int[] {0, 0, 1, 1, 1, 1, 1, 0};

    Assert.assertArrayEquals(expectedCellsState, obj.prisonAfterNDays(cells, 1000000000));
  }
}
