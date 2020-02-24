package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CombinationSum2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CombinationSum2Test {

  private final CombinationSum2 obj = new CombinationSum2();

  @Test
  public void testScenario1() {
    final int[] candidates = new int[] {2, 3, 6, 7};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();
    expectedCombinationSumList.add(Arrays.asList(7));

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum2(candidates, 7));
  }

  @Test
  public void testScenario2() {
    final int[] candidates = new int[] {2, 3, 5};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();
    expectedCombinationSumList.add(Arrays.asList(3, 5));

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum2(candidates, 8));
  }

  @Test
  public void testScenario3() {
    final int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();
    expectedCombinationSumList.add(Arrays.asList(1, 2, 5));
    expectedCombinationSumList.add(Arrays.asList(1, 1, 6));
    expectedCombinationSumList.add(Arrays.asList(2, 6));
    expectedCombinationSumList.add(Arrays.asList(1, 7));

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum2(candidates, 8));
  }

  @Test
  public void testEmptyCombinationList() {
    final int[] candidates = new int[] {2, 3, 5};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum2(candidates, 1));
  }
}
