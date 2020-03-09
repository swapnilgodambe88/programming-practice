package com.programming.practice.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result
 * graph is then a rooted tree. Among all possible rooted trees, those with minimum height are
 * called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and
 * return a list of their root labels.
 *
 * <p>Format The graph contains n nodes which are labeled from 0 to n - 1. You will be given the
 * number n and a list of undirected edges (each edge is a pair of labels).
 *
 * <p>You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * @see <a href = "https://leetcode.com/problems/minimum-height-trees/">Minimum Height Trees</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumHeightTrees {

  /** Keep track of minimum MHT so far. */
  private int minimumSoFar = Integer.MAX_VALUE;
  /** A map to hold a nodes neighbor information. */
  private final Map<Integer, List<Integer>> nodeToNeighborsMap = new HashMap<>();

  /** A map to hold the minimum DST path for each node. */
  private final Map<Integer, Integer> nodeToMinimumDST = new HashMap<>();

  /**
   * Finds all MHTs and returns a list of their root labels.
   *
   * @param n The number of nodes labeled 0 to n - 1.
   * @param edges The edges.
   * @return A list of MHTs root labels
   */
  public List<Integer> findMinHeightTrees(final int n, final int[][] edges) {
    createGraph(n, edges);

    // Get minimum path DFS for every node.
    for (int i = 0; i < n; i++) {
      minimumPathDFS(i, i, new ArrayList<>());

      if (nodeToMinimumDST.get(i) < minimumSoFar) {
        minimumSoFar = nodeToMinimumDST.get(i);
      }
    }

    final List<Integer> minimimumHeightTrees = new ArrayList<>();
    final int minimumSoFar_ = minimumSoFar;

    // Avoiding for each since leetcode doesn't recognize Map.Entry object
    nodeToMinimumDST.forEach(
        (node, mimimumDST) -> {
          if (mimimumDST == minimumSoFar_) {
            minimimumHeightTrees.add(node);
          }
        });

    return minimimumHeightTrees;
  }

  /**
   * Constructs a graph.
   *
   * @param n The number of nodes labeled 0 to n - 1.
   * @param edges The edges.
   */
  private void createGraph(final int n, final int[][] edges) {
    // Add nodes to map
    for (int i = 0; i < n; ++i) {
      nodeToNeighborsMap.put(i, new ArrayList<>());
    }

    // Add neighbor information to map
    for (final int[] edge : edges) {
      nodeToNeighborsMap.get(edge[0]).add(edge[1]);
      nodeToNeighborsMap.get(edge[1]).add(edge[0]);
    }
  }

  /**
   * Finds the minimumPathDSF for a startNode and stores off the resut in {@link
   * MinimumHeightTrees#nodeToMinimumDST}.
   *
   * @param startNode The start node.
   * @param currentNode The current node for recursion.
   * @param nodesTraversedSoFar A list of nodes traversed so far.
   */
  private void minimumPathDFS(
      final int startNode, final int currentNode, final List<Integer> nodesTraversedSoFar) {

    nodesTraversedSoFar.add(currentNode);

    boolean dfsPerformedOnAnyNeighbors = false;
    for (final int neighbor : nodeToNeighborsMap.get(currentNode)) {
      // Only perform DFS on the node if not visited
      if (!nodesTraversedSoFar.contains(neighbor)) {
        dfsPerformedOnAnyNeighbors = true;
        minimumPathDFS(startNode, neighbor, getDeepCopy(nodesTraversedSoFar));
      }
    }

    // All the nodes are traversed
    if (!dfsPerformedOnAnyNeighbors) {
      final int spanLength = nodesTraversedSoFar.size();

      if (!nodeToMinimumDST.containsKey(startNode)
          || // very first insert into the map
          spanLength > nodeToMinimumDST.get(startNode) // height of tree is max height of all
      // children
      ) {
        nodeToMinimumDST.put(startNode, spanLength);
      }
    }
  }

  /**
   * Generates a deep copy of the list.
   *
   * @param originalList The original list.
   * @return A deep copy of the list.
   */
  private static List<Integer> getDeepCopy(final List<Integer> originalList) {
    final List<Integer> clonnedList = new ArrayList<>();

    originalList.forEach(
        element -> {
          clonnedList.add(element);
        });
    return clonnedList;
  }
}
