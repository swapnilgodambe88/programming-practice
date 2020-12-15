package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MinimumDifficultyOfAJobSchedule}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class MinimumDifficultyOfAJobScheduleTest {
  private final MinimumDifficultyOfAJobSchedule obj = new MinimumDifficultyOfAJobSchedule();

  @Test
  public void testScenario1() {
    final int[] jobDifficulty = new int[] {1, 1, 1};
    final int d = 3;

    Assert.assertEquals(3, obj.minDifficulty(jobDifficulty, d));
  }

  @Test
  public void testScenario2() {
    final int[] jobDifficulty = new int[] {9, 9, 9};
    final int d = 4;

    Assert.assertEquals(-1, obj.minDifficulty(jobDifficulty, d));
  }

  @Test
  public void testScenario3() {
    final int[] jobDifficulty = new int[] {6, 5, 4, 3, 2, 1};
    final int d = 2;

    Assert.assertEquals(7, obj.minDifficulty(jobDifficulty, d));
  }

  @Test
  public void testScenario4() {
    final int[] jobDifficulty = new int[] {7, 1, 7, 1, 7, 1};
    final int d = 3;

    Assert.assertEquals(15, obj.minDifficulty(jobDifficulty, d));
  }

  @Test
  public void testScenario5() {
    final int[] jobDifficulty = new int[] {11, 111, 22, 222, 33, 333, 44, 444};
    final int d = 6;

    Assert.assertEquals(843, obj.minDifficulty(jobDifficulty, d));
  }
}
