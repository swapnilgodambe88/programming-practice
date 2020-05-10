package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CountOfSmallerNumbersAfterSelf}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CountOfSmallerNumbersAfterSelfTest {

  private final CountOfSmallerNumbersAfterSelf obj = new CountOfSmallerNumbersAfterSelf();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 0, 2};

    final List<Integer> expectedList = Arrays.asList(1, 0, 0);
    Assert.assertEquals(expectedList, obj.countSmaller(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {-1, 0};

    final List<Integer> expectedList = Arrays.asList(0, 0);
    Assert.assertEquals(expectedList, obj.countSmaller(nums));
  }

  @Test
  public void testScenario3() {
    final int[] nums = new int[] {5, 2, 6, 1};

    final List<Integer> expectedList = Arrays.asList(2, 1, 1, 0);
    Assert.assertEquals(expectedList, obj.countSmaller(nums));
  }

  @Test
  public void testScenario4() {
    final int[] nums = new int[] {2, 0, 1};

    final List<Integer> expectedList = Arrays.asList(2, 0, 0);
    Assert.assertEquals(expectedList, obj.countSmaller(nums));
  }

  @Test
  public void testScenario5() {
    final int[] nums = new int[] {-1, -1};

    final List<Integer> expectedList = Arrays.asList(0, 0);
    Assert.assertEquals(expectedList, obj.countSmaller(nums));
  }
}
