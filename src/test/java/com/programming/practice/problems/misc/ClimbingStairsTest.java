package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/** Unit tests for {@link ClimbingStairs}. */
public final class ClimbingStairsTest {

  private final ClimbingStairs obj = new ClimbingStairs();

  @Test
  public void testClimbingStairs2() {
    final int numberOfSteps = 2;
    Assert.assertEquals(2, obj.climbStairs(numberOfSteps));
  }

  @Test
  public void testClimbingStairs3() {
    final int numberOfSteps = 3;
    Assert.assertEquals(3, obj.climbStairs(numberOfSteps));
  }

  @Test
  public void testClimbingStairs10() {
    final int numberOfSteps = 10;
    Assert.assertEquals(89, obj.climbStairs(numberOfSteps));
  }

  @Test
  public void testClimbingStairs44() {
    final int numberOfSteps = 44;
    Assert.assertEquals(1134903170, obj.climbStairs(numberOfSteps));
  }
}
