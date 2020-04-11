package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TopKFrequentElements}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TopKFrequentElementsTest {

  private final TopKFrequentElements obj = new TopKFrequentElements();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {1, 1, 1, 2, 2, 3};
    final List<Integer> expectedTopKFrequenctElements = Arrays.asList(1, 2);

    Assert.assertEquals(expectedTopKFrequenctElements, obj.topKFrequent(nums, 2));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {1};
    final List<Integer> expectedTopKFrequenctElements = Arrays.asList(1);

    Assert.assertEquals(expectedTopKFrequenctElements, obj.topKFrequent(nums, 1));
  }
}
