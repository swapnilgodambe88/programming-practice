package com.programming.practice.problems.graph;

import com.programming.practice.problems.graph.util.GraphNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a reference of a node in a connected undirected graph.
 *
 * <p>Return a deep copy (clone) of the graph.
 *
 * @see <a href = "https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class CloneGraph {

  /** A map to maintain count of visited nodes on the cloned map. */
  private final Map<Integer, GraphNode> visitedNode = new HashMap<>();
  /**
   * Clones a graph.
   *
   * @param GraphNode The start node of the original graph.
   * @return The start node of the cloned graph.
   */
  public GraphNode cloneGraph(final GraphNode node) {
    if (node == null) {
      return null;
    }

    final GraphNode clonnedNode = new GraphNode(node.val);
    visitedNode.put(clonnedNode.val, clonnedNode);

    DFS(node, clonnedNode);
    return clonnedNode;
  }

  /**
   * DFS traversal of the graph in recursive manner.
   *
   * @param node The original node.
   * @param clonnedNode The cloned node.
   */
  public void DFS(final GraphNode node, final GraphNode clonnedNode) {

    for (final GraphNode neighbor : node.neighbors) {
      if (visitedNode.containsKey(neighbor.val)) {
        clonnedNode.neighbors.add(visitedNode.get(neighbor.val));
      } else {
        final GraphNode neighborClone = new GraphNode(neighbor.val);
        clonnedNode.neighbors.add(neighborClone);
        visitedNode.put(neighborClone.val, neighborClone);

        DFS(neighbor, neighborClone);
      }
    }
  }
}
