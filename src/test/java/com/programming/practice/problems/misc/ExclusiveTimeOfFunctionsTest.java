package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ExclusiveTimeOfFunctions}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ExclusiveTimeOfFunctionsTest {

  private final ExclusiveTimeOfFunctions obj = new ExclusiveTimeOfFunctions();

  @Test
  public void testScenario1() {
    final int n = 2;
    final List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");

    final int[] expectedResult = new int[] {3, 4};
    Assert.assertArrayEquals(expectedResult, obj.exclusiveTime(n, logs));
  }

  @Test
  public void testScenario2() {
    final int n = 1;
    final List<String> logs =
        Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");

    final int[] expectedResult = new int[] {8};
    Assert.assertArrayEquals(expectedResult, obj.exclusiveTime(n, logs));
  }

  @Test
  public void testScenario3() {
    final int n = 2;
    final List<String> logs =
        Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");

    final int[] expectedResult = new int[] {7, 1};
    Assert.assertArrayEquals(expectedResult, obj.exclusiveTime(n, logs));
  }

  @Test
  public void testScenario4() {
    final int n = 2;
    final List<String> logs =
        Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8");

    final int[] expectedResult = new int[] {8, 1};
    Assert.assertArrayEquals(expectedResult, obj.exclusiveTime(n, logs));
  }

  @Test
  public void testScenario5() {
    final int n = 1;
    final List<String> logs = Arrays.asList("0:start:0", "0:end:0");

    final int[] expectedResult = new int[] {1};
    Assert.assertArrayEquals(expectedResult, obj.exclusiveTime(n, logs));
  }
}
