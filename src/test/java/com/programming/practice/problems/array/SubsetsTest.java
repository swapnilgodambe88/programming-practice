package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link Subsets}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SubsetsTest {

  private final Subsets obj = new Subsets();

  @Test
  public void testEmpty() {
    final List<List<Integer>> expectedSubsets = new ArrayList<>();

    expectedSubsets.add(Arrays.asList());

    Assert.assertEquals(expectedSubsets, obj.subsets(new int[] {}));
  }

  @Test
  public void testScenario1() {
    final List<List<Integer>> expectedSubsets = new ArrayList<>();

    expectedSubsets.add(Arrays.asList());
    expectedSubsets.add(Arrays.asList(1));
    expectedSubsets.add(Arrays.asList(2));
    expectedSubsets.add(Arrays.asList(1, 2));
    expectedSubsets.add(Arrays.asList(3));
    expectedSubsets.add(Arrays.asList(1, 3));
    expectedSubsets.add(Arrays.asList(2, 3));
    expectedSubsets.add(Arrays.asList(1, 2, 3));

    Assert.assertEquals(expectedSubsets, obj.subsets(new int[] {1, 2, 3}));
  }
}
