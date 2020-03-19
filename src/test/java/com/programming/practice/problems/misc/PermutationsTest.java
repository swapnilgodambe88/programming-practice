/** */
package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link Permutations}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PermutationsTest {

  private final Permutations obj = new Permutations();

  @Test
  public void testEmpty() {
    final int[] nums = new int[] {};

    final List<List<Integer>> expectedPermutations = new LinkedList<>();
    Assert.assertEquals(expectedPermutations, obj.permute(nums));
  }

  @Test
  public void testSinleElement() {
    final int[] nums = new int[] {1};

    final List<List<Integer>> expectedPermutations = new LinkedList<>();
    expectedPermutations.add(Arrays.asList(1));
    Assert.assertEquals(expectedPermutations, obj.permute(nums));
  }

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 2, 3};

    final List<List<Integer>> expectedPermutations = new LinkedList<>();
    expectedPermutations.add(Arrays.asList(1, 2, 3));
    expectedPermutations.add(Arrays.asList(1, 3, 2));
    expectedPermutations.add(Arrays.asList(2, 1, 3));
    expectedPermutations.add(Arrays.asList(2, 3, 1));
    expectedPermutations.add(Arrays.asList(3, 1, 2));
    expectedPermutations.add(Arrays.asList(3, 2, 1));

    Assert.assertEquals(expectedPermutations, obj.permute(nums));
  }
}
