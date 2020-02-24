package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link FourSum}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class FourSumTest {

  private final FourSum obj = new FourSum();

  @Test
  public void testSolutionExists() {
    final List<List<Integer>> expectedQuadruplets = new ArrayList<>();

    expectedQuadruplets.add(Arrays.asList(-2, -1, 1, 2));
    expectedQuadruplets.add(Arrays.asList(-2, 0, 0, 2));
    expectedQuadruplets.add(Arrays.asList(-1, 0, 0, 1));

    final int[] inputArray = new int[] {1, 0, -1, 0, -2, 2};
    Assert.assertEquals(expectedQuadruplets, obj.fourSum(inputArray, 0));
  }

  @Test
  public void testNoSolutionExists() {
    final List<List<Integer>> expectedQuadruplets = new ArrayList<>();

    final int[] inputArray = new int[] {1, 0, -1, 0, -2, 2};
    Assert.assertEquals(expectedQuadruplets, obj.fourSum(inputArray, 99));
  }

  @Test
  public void testDuplicateQuadrupletsSolutionExists() {
    final List<List<Integer>> expectedQuadruplets = new ArrayList<>();

    expectedQuadruplets.add(Arrays.asList(-3, -2, 2, 3));
    expectedQuadruplets.add(Arrays.asList(-3, -1, 1, 3));
    expectedQuadruplets.add(Arrays.asList(-3, 0, 0, 3));
    expectedQuadruplets.add(Arrays.asList(-3, 0, 1, 2));
    expectedQuadruplets.add(Arrays.asList(-2, -1, 0, 3));
    expectedQuadruplets.add(Arrays.asList(-2, -1, 1, 2));
    expectedQuadruplets.add(Arrays.asList(-2, 0, 0, 2));
    expectedQuadruplets.add(Arrays.asList(-1, 0, 0, 1));

    final int[] inputArray = new int[] {-3, -2, -1, 0, 0, 1, 2, 3};
    Assert.assertEquals(expectedQuadruplets, obj.fourSum(inputArray, 0));
  }
}
