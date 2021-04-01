package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DiagonalTraverse2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 */
public class DiagonalTraverse2Test {

  private final DiagonalTraverse2 obj = new DiagonalTraverse2();

  @Test
  public void testScenario1() {
    final List<List<Integer>> nums = new ArrayList<>();
    nums.add(Arrays.asList(1, 2, 3, 4, 5));
    nums.add(Arrays.asList(6, 7));
    nums.add(Arrays.asList(8));
    nums.add(Arrays.asList(9, 10, 11));
    nums.add(Arrays.asList(12, 13, 14, 15, 16));

    final int[] expectedTraversalOrder =
        new int[] {1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16};
    Assert.assertArrayEquals(expectedTraversalOrder, obj.findDiagonalOrder(nums));
  }

  @Test
  public void testScenario2() {
    final List<List<Integer>> nums = new ArrayList<>();
    nums.add(Arrays.asList(1, 2, 3));
    nums.add(Arrays.asList(4, 5, 6));
    nums.add(Arrays.asList(7, 8, 9));

    final int[] expectedTraversalOrder = new int[] {1, 4, 2, 7, 5, 3, 8, 6, 9};
    Assert.assertArrayEquals(expectedTraversalOrder, obj.findDiagonalOrder(nums));
  }

  @Test
  public void testScenario3() {
    final List<List<Integer>> nums = new ArrayList<>();
    nums.add(Arrays.asList(1, 2, 3));
    nums.add(Arrays.asList(4));
    nums.add(Arrays.asList(5, 6, 7));
    nums.add(Arrays.asList(8));
    nums.add(Arrays.asList(9, 10, 11));

    final int[] expectedTraversalOrder = new int[] {1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11};
    Assert.assertArrayEquals(expectedTraversalOrder, obj.findDiagonalOrder(nums));
  }

  @Test
  public void testScenario4() {
    final List<List<Integer>> nums = new ArrayList<>();
    nums.add(Arrays.asList(1, 2, 3, 4, 5, 6));

    final int[] expectedTraversalOrder = new int[] {1, 2, 3, 4, 5, 6};
    Assert.assertArrayEquals(expectedTraversalOrder, obj.findDiagonalOrder(nums));
  }
}
