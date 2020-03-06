package com.programming.practice.problems.graph;

import com.programming.practice.datastructure.Graph;
import com.programming.practice.problems.graph.util.GraphNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link CloneGraph}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CloneGraphTest {

  private final CloneGraph obj = new CloneGraph();

  @Test
  public void testCloneGraphScenario1() {
    final Graph graph = new Graph(new int[] {1, 2, 3, 4});

    graph.linkNodes(1, 2);
    graph.linkNodes(2, 3);
    graph.linkNodes(3, 4);
    graph.linkNodes(4, 1);

    final GraphNode clonedGraphNode = obj.cloneGraph(graph.getNodeValueGraphNodeMap().get(1));
    Assert.assertEquals(1, clonedGraphNode.val);
  }

  @Test
  public void testNullGraph() {

    final GraphNode clonedGraphNode = obj.cloneGraph(null);
    Assert.assertNull(clonedGraphNode);
  }
}
