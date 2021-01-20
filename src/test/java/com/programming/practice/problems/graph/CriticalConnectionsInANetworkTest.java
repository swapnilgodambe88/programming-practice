package com.programming.practice.problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CriticalConnectionsInANetwork}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class CriticalConnectionsInANetworkTest {
  private final CriticalConnectionsInANetwork obj = new CriticalConnectionsInANetwork();

  @Test
  public void testScenario1() {
    final List<List<Integer>> connections = new ArrayList<>();
    connections.add(Arrays.asList(0, 1));
    connections.add(Arrays.asList(1, 2));
    connections.add(Arrays.asList(2, 0));
    connections.add(Arrays.asList(1, 3));

    final int n = 4;

    final List<List<Integer>> expectedCriticalConnections = new ArrayList<>();
    expectedCriticalConnections.add(Arrays.asList(1, 3));

    Assert.assertEquals(expectedCriticalConnections, obj.criticalConnections(n, connections));
  }
}
