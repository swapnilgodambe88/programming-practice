package com.programming.practice.problems.array;

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
    final int[] expectedTopKFrequenctElements = new int[] {1, 2};

    Assert.assertArrayEquals(expectedTopKFrequenctElements, obj.topKFrequent(nums, 2));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {1};
    final int[] expectedTopKFrequenctElements = new int[] {1};

    Assert.assertArrayEquals(expectedTopKFrequenctElements, obj.topKFrequent(nums, 1));
  }
}
