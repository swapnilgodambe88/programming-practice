package com.programming.practice.problems.misc;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/** Unit test for {@link PascalTriangle}. */
public final class PascalTriangleTest {

  private final PascalTriangle obj = new PascalTriangle();

  @Test
  public void testScenario1() {
    final int numRows = 5;
    final List<List<Integer>> expectedList =
        List.of(
            List.of(1),
            List.of(1, 1),
            List.of(1, 2, 1),
            List.of(1, 3, 3, 1),
            List.of(1, 4, 6, 4, 1));

    Assert.assertEquals(expectedList, obj.generate(numRows));
  }

  @Test
  public void testSingleRow() {
    final int numRows = 1;
    final List<List<Integer>> expectedList = List.of(List.of(1));

    Assert.assertEquals(expectedList, obj.generate(numRows));
  }

  @Test
  public void testZeroRow() {
    final int numRows = 0;
    final List<List<Integer>> expectedList = List.of();

    Assert.assertEquals(expectedList, obj.generate(numRows));
  }
}
