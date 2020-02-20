package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @see <a href = ""></a>
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class ThreeSumTest {

  private final ThreeSum obj = new ThreeSum();

  @Test
  public void testTwoTripletSolutionExists() {
    final int[] inputArray = new int[] {-1, 0, 1, 2, -1, -4};

    final List<List<Integer>> expectedTriplets = new ArrayList<>();
    expectedTriplets.add(Arrays.asList(-1, -1, 2));
    expectedTriplets.add(Arrays.asList(-1, 0, 1));

    Assert.assertEquals(expectedTriplets, obj.threeSum(inputArray));
  }

  @Test
  public void testUniqueTripletSolutionExists() {
    final int[] inputArray = new int[] {0, 0, 0, 0};

    final List<List<Integer>> expectedTriplets = new ArrayList<>();
    expectedTriplets.add(Arrays.asList(0, 0, 0));

    Assert.assertEquals(expectedTriplets, obj.threeSum(inputArray));
  }

  @Test
  public void testRandom1() {
    final int[] inputArray = new int[] {3, 0, -2, -1, 1, 2};

    final List<List<Integer>> expectedTriplets = new ArrayList<>();
    expectedTriplets.add(Arrays.asList(-2, -1, 3));
    expectedTriplets.add(Arrays.asList(-2, 0, 2));
    expectedTriplets.add(Arrays.asList(-1, 0, 1));

    Assert.assertEquals(expectedTriplets, obj.threeSum(inputArray));
  }
}
