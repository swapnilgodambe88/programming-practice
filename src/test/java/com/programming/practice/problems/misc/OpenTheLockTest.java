package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link OpenTheLock}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class OpenTheLockTest {

  private final OpenTheLock obj = new OpenTheLock();

  @Test
  public void testScenario1() {
    final String[] deadends = new String[] {"8888"};
    final String target = "0009";

    Assert.assertEquals(1, obj.openLock(deadends, target));
  }

  @Test
  public void testScenario2() {
    final String[] deadends = new String[] {"0201", "0101", "0102", "1212", "2002"};
    final String target = "0202";

    Assert.assertEquals(6, obj.openLock(deadends, target));
  }

  @Test
  public void testSolutionDoesntExist1() {
    final String[] deadends = new String[] {"0000"};
    final String target = "8888";

    Assert.assertEquals(-1, obj.openLock(deadends, target));
  }

  @Test
  public void testSolutionDoesntExist2() {
    final String[] deadends =
        new String[] {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
    final String target = "8888";

    Assert.assertEquals(-1, obj.openLock(deadends, target));
  }
}
