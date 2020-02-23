package com.programming.practice.problems.misc;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link NextPermutation}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class NextPermutationTest {

  private final NextPermutation obj = new NextPermutation();

  @Test
  public void testValidScenario1() {
    final int[] nums = new int[] {1, 2, 3};
    final int[] expectedNextPermutation = new int[] {1, 3, 2};

    obj.nextPermutation(nums);
    Assert.assertTrue(Arrays.equals(expectedNextPermutation, nums));
  }

  @Test
  public void testValidScenario2() {
    final int[] nums = new int[] {3, 2, 1};
    final int[] expectedNextPermutation = new int[] {1, 2, 3};

    obj.nextPermutation(nums);
    Assert.assertTrue(Arrays.equals(expectedNextPermutation, nums));
  }

  @Test
  public void testValidScenario3() {
    final int[] nums = new int[] {1, 1, 5};
    final int[] expectedNextPermutation = new int[] {1, 5, 1};

    obj.nextPermutation(nums);
    Assert.assertTrue(Arrays.equals(expectedNextPermutation, nums));
  }

  @Test
  public void testValidScenario4() {
    final int[] nums = new int[] {1, 5, 4, 7, 6, 5, 3, 1};
    final int[] expectedNextPermutation = new int[] {1, 5, 5, 1, 3, 4, 6, 7};

    obj.nextPermutation(nums);
    Assert.assertTrue(Arrays.equals(expectedNextPermutation, nums));
  }

  @Test
  public void testDigitsSame() {
    final int[] nums = new int[] {7, 7, 7, 7, 7};
    final int[] expectedNextPermutation = new int[] {7, 7, 7, 7, 7};

    obj.nextPermutation(nums);
    Assert.assertTrue(Arrays.equals(expectedNextPermutation, nums));
  }

  @Test
  public void testDigitsZero() {
    final int[] nums = new int[] {0, 0, 0};
    final int[] expectedNextPermutation = new int[] {0, 0, 0};

    obj.nextPermutation(nums);
    Assert.assertTrue(Arrays.equals(expectedNextPermutation, nums));
  }
}
