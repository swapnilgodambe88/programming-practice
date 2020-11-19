package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SumOfEvenNumbersAfterQueries}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class SumOfEvenNumbersAfterQueriesTest {
  private final SumOfEvenNumbersAfterQueries obj = new SumOfEvenNumbersAfterQueries();

  @Test
  public void testScenario1() {
    final int[] A = new int[] {1, 2, 3, 4};
    final int[][] queries = new int[][] {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

    final int[] expectedArray = new int[] {8, 6, 2, 4};
    Assert.assertArrayEquals(expectedArray, obj.sumEvenAfterQueries(A, queries));
  }

  @Test
  public void testScenario2() {
    final int[] A = new int[] {3, 2};
    final int[][] queries = new int[][] {{4, 0}, {3, 0}};

    final int[] expectedArray = new int[] {2, 12};
    Assert.assertArrayEquals(expectedArray, obj.sumEvenAfterQueries(A, queries));
  }
}
