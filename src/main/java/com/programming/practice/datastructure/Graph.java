package com.programming.practice.datastructure;

import com.programming.practice.problems.graph.util.GraphNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * A Graph representation.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class Graph {

  private final Map<Integer, GraphNode> nodeValueGraphNodeMap;
  /** Constructor for {@link Graph}. Declared private to prevent direct instantiation. */
  public Graph() {
    nodeValueGraphNodeMap = new HashMap<>();
  }

  /**
   * Constructor for {@link Graph}.
   *
   * @param nodes The nodes for the graph.
   */
  public Graph(final int[] nodes) {
    nodeValueGraphNodeMap = new HashMap<>();

    for (final int node : nodes) {
      nodeValueGraphNodeMap.put(node, new GraphNode(node));
    }
  }

  /**
   * Adds a node to the Graph.
   *
   * @param node The node to add.
   * @throws UnsupportedOperationException If the node is already present on the graph.
   */
  public void addNode(final int node) throws UnsupportedOperationException {
    if (nodeValueGraphNodeMap.containsKey(node)) {
      throw new UnsupportedOperationException("Graph already contains a node with value: " + node);
    }

    nodeValueGraphNodeMap.put(node, new GraphNode(node));
  }

  /** @return The map of node value to {@link GraphNode}. */
  public Map<Integer, GraphNode> getNodeValueGraphNodeMap() {
    return nodeValueGraphNodeMap;
  }

  /** @return A list of {@link GraphNode} present in the graph. */
  public List<GraphNode> getGraphNodes() {
    return new ArrayList<>(nodeValueGraphNodeMap.values());
  }

  /**
   * Links the two nodes on the graph.
   *
   * @param n1 The node 1.
   * @param n2 The node 2.
   * @throws IllegalArgumentException If either node1 or node2 is not present on the graph.
   */
  public void linkNodes(final int n1, final int n2) throws IllegalArgumentException {
    if (!nodeValueGraphNodeMap.containsKey(n1) || !nodeValueGraphNodeMap.containsKey(n2)) {
      throw new IllegalArgumentException(
          "Either node1 = " + n1 + " or node2 = " + n2 + " or both are not present on the graph.");
    }

    final GraphNode node1 = nodeValueGraphNodeMap.get(n1);
    final GraphNode node2 = nodeValueGraphNodeMap.get(n2);

    node1.neighbors.add(node2);
    node2.neighbors.add(node1);
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    final StringBuffer printString = new StringBuffer();

    for (final GraphNode node : nodeValueGraphNodeMap.values()) {
      printString.append(node.toString()).append("\n");
    }

    return printString.toString();
  }

  /**
   * Performs BFS traversal on the graph.
   *
   * @param startNode The start node of the graph to begin the traversal.
   * @return The BFS traversal path.
   * @throws IllegalArgumentException If the startNode is not present on the graph.
   */
  public int[] BFSTraversal(final int startNode) throws IllegalArgumentException {

    if (!nodeValueGraphNodeMap.containsKey(startNode)) {
      throw new IllegalArgumentException(
          "StartNode = " + startNode + " not present on the graph for BFS traversal.");
    }
    final int[] bfsTraversal = new int[nodeValueGraphNodeMap.size()];

    int index = 0;
    final Set<Integer> visitedNodes = new HashSet<>();

    final Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);

    while (!queue.isEmpty()) {
      final int dequeuedNode = queue.poll();
      visitedNodes.add(dequeuedNode);
      bfsTraversal[index++] = dequeuedNode;

      for (final GraphNode graphNode : nodeValueGraphNodeMap.get(dequeuedNode).neighbors) {
        if (!visitedNodes.contains(graphNode.val) && !queue.contains(graphNode.val)) {
          queue.add(graphNode.val);
        }
      }
    }

    return bfsTraversal;
  }

  /**
   * Performs DFS traversal on the graph.
   *
   * @param startNode The start node of the graph to begin the traversal.
   * @return The DFS traversal path.
   * @throws IllegalArgumentException If the startNode is not present on the graph.
   */
  public int[] DFSTraversal(final int startNode) throws IllegalArgumentException {

    if (!nodeValueGraphNodeMap.containsKey(startNode)) {
      throw new IllegalArgumentException(
          "StartNode = " + startNode + " not present on the graph for DFS traversal.");
    }
    final int[] dfsTraversal = new int[nodeValueGraphNodeMap.size()];

    int index = 0;
    final Set<Integer> visitedNodes = new HashSet<>();

    final Stack<Integer> stack = new Stack<>();
    stack.add(startNode);

    while (!stack.isEmpty()) {
      final int poppedNode = stack.pop();
      visitedNodes.add(poppedNode);
      dfsTraversal[index++] = poppedNode;

      for (final GraphNode graphNode : nodeValueGraphNodeMap.get(poppedNode).neighbors) {
        if (!visitedNodes.contains(graphNode.val) && !stack.contains(graphNode.val)) {
          stack.add(graphNode.val);
        }
      }
    }

    return dfsTraversal;
  }
}
