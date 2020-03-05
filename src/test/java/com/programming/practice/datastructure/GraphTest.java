package com.programming.practice.datastructure;

import com.programming.practice.problems.graph.util.GraphNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Black box tests for {@link Graph}
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class GraphTest {

  @Rule public final ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void testConstructorWithNoArguments() {
    final Graph graph = new Graph();

    Assert.assertTrue(graph.getGraphNodes().isEmpty());
  }

  @Test
  public void testConstructorWithArguments() {
    final Graph graph = new Graph(new int[] {1, 2, 3, 4});

    Assert.assertEquals(4, graph.getGraphNodes().size());
  }

  @Test
  public void testAddNode() {
    final Graph graph = new Graph();
    graph.addNode(1);

    Assert.assertEquals(1, graph.getGraphNodes().size());
  }

  @Test
  public void testAddNodeThrowsException() {
    final Graph graph = new Graph();
    graph.addNode(1);

    Assert.assertEquals(1, graph.getGraphNodes().size());

    exceptionRule.expect(UnsupportedOperationException.class);
    exceptionRule.expectMessage("Graph already contains a node with value: 1");

    graph.addNode(1);
  }

  @Test
  public void testGetNodeValueGraphNodeMap() {
    final Graph graph = new Graph(new int[] {1, 2});

    final Map<Integer, GraphNode> expectedMap = new HashMap<>();
    expectedMap.put(1, new GraphNode(1));
    expectedMap.put(2, new GraphNode(2));

    Assert.assertEquals(expectedMap, graph.getNodeValueGraphNodeMap());
  }

  @Test
  public void testGetGraphNodes() {
    final Graph graph = new Graph(new int[] {1, 2});

    final List<GraphNode> expectedNodes = new ArrayList<>();
    expectedNodes.add(new GraphNode(1));
    expectedNodes.add(new GraphNode(2));

    Assert.assertEquals(expectedNodes, graph.getGraphNodes());
  }

  @Test
  public void testLinkNodes() {
    final Graph graph = new Graph(new int[] {1, 2});

    graph.linkNodes(1, 2);

    final GraphNode node1 = graph.getNodeValueGraphNodeMap().get(1);
    final GraphNode node2 = graph.getNodeValueGraphNodeMap().get(2);

    Assert.assertEquals(1, node1.neighbors.size());
    Assert.assertEquals(1, node2.neighbors.size());
    Assert.assertEquals(node1, node2.neighbors.get(0));
    Assert.assertEquals(node2, node1.neighbors.get(0));
  }

  @Test
  public void testLinkNodesThrowsExceptionNode1NotPresent() {
    final Graph graph = new Graph(new int[] {1, 2});

    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(
        "Either node1 = 3 or node2 = 2 or both are not present on the graph.");
    graph.linkNodes(3, 2);
  }

  @Test
  public void testLinkNodesThrowsExceptionNode2NotPresent() {
    final Graph graph = new Graph(new int[] {1, 2});

    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage(
        "Either node1 = 1 or node2 = 10 or both are not present on the graph.");
    graph.linkNodes(1, 10);
  }

  @Test
  public void testToString() {
    final Graph graph = new Graph(new int[] {1, 2});

    final StringBuffer expectedString = new StringBuffer();
    expectedString.append(graph.getNodeValueGraphNodeMap().get(1)).append("\n");
    expectedString.append(graph.getNodeValueGraphNodeMap().get(2)).append("\n");

    Assert.assertEquals(expectedString.toString(), graph.toString());
  }

  @Test
  public void testBFSTraversalThrowsException() {
    final Graph graph = new Graph(new int[] {1, 2, 3, 4, 5, 6, 7});

    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("StartNode = 99 not present on the graph for BFS traversal.");

    graph.BFSTraversal(99);
  }

  @Test
  public void testBFSTraversal() {
    final Graph graph = new Graph(new int[] {1, 2, 3, 4, 5, 6, 7});

    graph.linkNodes(1, 2);
    graph.linkNodes(1, 3);
    graph.linkNodes(2, 7);
    graph.linkNodes(3, 4);
    graph.linkNodes(3, 5);
    graph.linkNodes(6, 4);
    graph.linkNodes(6, 5);

    final int[] expectedTraversal = new int[] {1, 2, 3, 7, 4, 5, 6};
    Assert.assertTrue(Arrays.equals(expectedTraversal, graph.BFSTraversal(1)));
  }

  @Test
  public void testDFSTraversalThrowsException() {
    final Graph graph = new Graph(new int[] {1, 2, 3, 4, 5, 6, 7});

    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("StartNode = 99 not present on the graph for DFS traversal.");

    graph.DFSTraversal(99);
  }

  @Test
  public void testDFSTraversal() {
    final Graph graph = new Graph(new int[] {1, 2, 3, 4, 5, 6, 7});

    graph.linkNodes(1, 2);
    graph.linkNodes(1, 3);
    graph.linkNodes(2, 7);
    graph.linkNodes(3, 4);
    graph.linkNodes(3, 5);
    graph.linkNodes(6, 4);
    graph.linkNodes(6, 5);

    final int[] expectedTraversal = new int[] {1, 3, 5, 6, 4, 2, 7};
    Assert.assertTrue(Arrays.equals(expectedTraversal, graph.DFSTraversal(1)));
  }
}
