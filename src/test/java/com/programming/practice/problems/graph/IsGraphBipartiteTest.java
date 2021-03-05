package com.programming.practice.problems.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link IsGraphBiPartite}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class IsGraphBipartiteTest {

  private final IsGraphBiPartite obj = new IsGraphBiPartite();

  @Test
  public void testScenario1() {
    final int[][] graph = new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

    Assert.assertTrue(obj.isBipartite(graph));
  }

  @Test
  public void testScenario2() {
    final int[][] graph = new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};

    Assert.assertFalse(obj.isBipartite(graph));
  }
}
