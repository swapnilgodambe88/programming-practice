package com.programming.practice.problems.misc;

import com.programming.practice.problems.array.SortColors;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SortColors}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SortColorsTest {

  private final SortColors obj = new SortColors();

  @Test
  public void testEmptyColors() {
    final int[] colors = new int[] {};
    final int[] expectedSortedColors = new int[] {};

    obj.sortColors(colors);
    Assert.assertArrayEquals(expectedSortedColors, colors);
  }

  @Test
  public void testScenario1() {
    final int[] colors = new int[] {2, 0, 2, 1, 1, 0};
    final int[] expectedSortedColors = new int[] {0, 0, 1, 1, 2, 2};

    obj.sortColors(colors);
    Assert.assertArrayEquals(expectedSortedColors, colors);
  }

  @Test
  public void testScenario2() {
    final int[] colors = new int[] {2, 1, 2, 1, 1, 2};
    final int[] expectedSortedColors = new int[] {1, 1, 1, 2, 2, 2};

    obj.sortColors(colors);
    Assert.assertArrayEquals(expectedSortedColors, colors);
  }
}
