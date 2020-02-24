package com.programming.practice.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CombinationSum}.
 *
 * @author Swapnil Godambe.<br/>
 *         Copyright 2020.
 */
public final class CombinationSumTest {

  private final CombinationSum obj = new CombinationSum();

  @Test
  public void testScenario1() {
    final int[] candidates = new int[] {2, 3, 6, 7};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();
    expectedCombinationSumList.add(Arrays.asList(2, 2, 3));
    expectedCombinationSumList.add(Arrays.asList(7));

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum(candidates, 7));
  }

  @Test
  public void testScenario2() {
    final int[] candidates = new int[] {2, 3, 5};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();
    expectedCombinationSumList.add(Arrays.asList(2, 3, 3));
    expectedCombinationSumList.add(Arrays.asList(3, 5));
    expectedCombinationSumList.add(Arrays.asList(2, 2, 2, 2));

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum(candidates, 8));
  }

  @Test
  public void testEmptyCombinationList() {
    final int[] candidates = new int[] {2, 3, 5};

    final List<List<Integer>> expectedCombinationSumList = new ArrayList<>();

    Assert.assertEquals(expectedCombinationSumList, obj.combinationSum(candidates, 1));
  }
}
