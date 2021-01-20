package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SparseVector}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class SparseVectorTest {

  @Test
  public void testScenario1() {
    final SparseVector v1 = new SparseVector(new int[] {1, 0, 0, 2, 3});
    final SparseVector v2 = new SparseVector(new int[] {0, 3, 0, 4, 0});

    Assert.assertEquals(8, v1.dotProduct(v2));
  }

  @Test
  public void testScenario2() {
    final SparseVector v1 = new SparseVector(new int[] {0, 1, 0, 0, 0});
    final SparseVector v2 = new SparseVector(new int[] {0, 0, 0, 0, 2});

    Assert.assertEquals(0, v1.dotProduct(v2));
  }

  @Test
  public void testScenario3() {
    final SparseVector v1 = new SparseVector(new int[] {0, 1, 0, 0, 2, 0, 0});
    final SparseVector v2 = new SparseVector(new int[] {1, 0, 0, 0, 3, 0, 4});

    Assert.assertEquals(6, v1.dotProduct(v2));
  }
}
