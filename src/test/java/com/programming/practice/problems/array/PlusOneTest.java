package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link PlusOne}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PlusOneTest {

  private final PlusOne obj = new PlusOne();

  @Test
  public void test0Digit() {
    final int[] digits = new int[] {0};
    final int[] expectedResult = new int[] {1};

    Assert.assertArrayEquals(expectedResult, obj.plusOne(digits));
  }

  @Test
  public void testScenario1() {
    final int[] digits = new int[] {1, 2, 3};
    final int[] expectedResult = new int[] {1, 2, 4};

    Assert.assertArrayEquals(expectedResult, obj.plusOne(digits));
  }

  @Test
  public void testScenario2() {
    final int[] digits = new int[] {4, 3, 2, 1};
    final int[] expectedResult = new int[] {4, 3, 2, 2};

    Assert.assertArrayEquals(expectedResult, obj.plusOne(digits));
  }

  @Test
  public void testExtraDigitAddedToSum() {
    final int[] digits = new int[] {9, 9, 9};
    final int[] expectedResult = new int[] {1, 0, 0, 0};

    Assert.assertArrayEquals(expectedResult, obj.plusOne(digits));
  }
}
