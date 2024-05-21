package com.programming.practice.problems.misc;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/** Unit test for {@link PascalTriangle2}. */
public final class PascalTriangle2Test {

  private final PascalTriangle2 obj = new PascalTriangle2();

  @Test
  public void testRowIndex3() {
    final List<Integer> expectedOutput = List.of(1, 3, 3, 1);
    Assert.assertEquals(expectedOutput, obj.getRow(3));
  }

  @Test
  public void testRowIndex0() {
    final List<Integer> expectedOutput = List.of(1);
    Assert.assertEquals(expectedOutput, obj.getRow(0));
  }

  @Test
  public void testRowIndex1() {
    final List<Integer> expectedOutput = List.of(1, 1);
    Assert.assertEquals(expectedOutput, obj.getRow(1));
  }
}
