package com.programming.practice.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SummaryRanges}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SummaryRangesTest {

  private final SummaryRanges obj = new SummaryRanges();

  @Test
  public void testScenario1() {
    final int[] nums = new int[] {0, 1, 2, 4, 5, 7};
    final List<String> expectedRanges = Arrays.asList("0->2", "4->5", "7");

    Assert.assertEquals(expectedRanges, obj.summaryRanges(nums));
  }

  @Test
  public void testScenario2() {
    final int[] nums = new int[] {0, 2, 3, 4, 6, 8, 9};
    final List<String> expectedRanges = Arrays.asList("0", "2->4", "6", "8->9");

    Assert.assertEquals(expectedRanges, obj.summaryRanges(nums));
  }

  @Test
  public void testScenario3() {
    final int[] nums = new int[] {};
    final List<String> expectedRanges = new ArrayList<>();

    Assert.assertEquals(expectedRanges, obj.summaryRanges(nums));
  }

  @Test
  public void testScenario4() {
    final int[] nums = new int[] {-1};
    final List<String> expectedRanges = Arrays.asList("-1");

    Assert.assertEquals(expectedRanges, obj.summaryRanges(nums));
  }

  @Test
  public void testScenario5() {
    final int[] nums = new int[] {0};
    final List<String> expectedRanges = Arrays.asList("0");

    Assert.assertEquals(expectedRanges, obj.summaryRanges(nums));
  }
}
