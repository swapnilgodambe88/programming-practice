package com.programming.practice.problems.graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * <p>Recall that a graph is bipartite if we can split its set of nodes into two independent subsets
 * A and B, such that every edge in the graph has one node in A and another node in B.
 *
 * <p>The graph is given in the following form: graph[i] is a list of indexes j for which the edge
 * between nodes i and j exists. Each node is an integer between 0 and graph.length - 1. There are
 * no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element
 * twice.
 *
 * <pre>
 * Example 1:
 *
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]]
 * Output: true
 * Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.
 *
 * Example 2:
 *
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/is-graph-bipartite/">Is Graph bipartite</a>
 */
public final class IsGraphBiPartite {

  /** An enumeration representing the color of the vertex. */
  enum Color {
    UNDEFINED,
    BLUE,
    RED;
  }

  /**
   * Given an undirected graph, return true if and only if it is bipartite.
   *
   * @param graph The graph representation.
   * @return True If the graph is bipartite, otherwise returns false.
   */
  public boolean isBipartite(final int[][] graph) {
    final Color[] color = new Color[graph.length];
    Arrays.fill(color, Color.UNDEFINED);

    // Algorithm:
    // 1. If vertex i is not colored. Then color it with BLUE
    // 2. Perform Depth search traversal, and alternate the color between BLUE and RED
    // 3. If we find a neighbor vertex with the same COLOR of the current vertex, then the graph is
    // not bipartite.
    for (int i = 0; i < graph.length; ++i) {
      if (color[i] == Color.UNDEFINED) {
        final Stack<Integer> stack = new Stack<>();
        stack.push(i);
        color[i] = Color.BLUE;

        while (!stack.isEmpty()) {
          final int poppedVertex = stack.pop();

          for (final int neighbor : graph[poppedVertex]) {
            if (color[neighbor] == Color.UNDEFINED) {
              stack.push(neighbor);

              // Color the neighbor with the opposite color of the current vertex
              color[neighbor] = color[poppedVertex] == Color.BLUE ? Color.RED : Color.BLUE;
            } else if (color[neighbor] == color[poppedVertex]) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }
}
