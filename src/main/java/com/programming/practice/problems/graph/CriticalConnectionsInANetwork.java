package com.programming.practice.problems.graph;

import java.util.*;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections
 * forming a network where connections[i] = [a, b] represents a connection between servers a and b.
 * Any server can reach any other server directly or indirectly through the network.
 *
 * <p>A critical connection is a connection that, if removed, will make some server unable to reach
 * some other server.
 *
 * <p>Return all critical connections in the network in any order.
 *
 * <pre>
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/critical-connections-in-a-network/">Critical
 *     Connections in a Network</a>
 */
public class CriticalConnectionsInANetwork {

  /** A graph representation of the network. */
  final Map<Integer, Set<Integer>> graph = new HashMap<>();

  /**
   * Returns the critical connections in the network.
   *
   * @param n The number of vertices on the network.
   * @param connections The list of connections on the network.
   * @return The list of critical connections in the network.
   */
  public List<List<Integer>> criticalConnections(
      final int n, final List<List<Integer>> connections) {

    createGraph(n, connections);

    final List<List<Integer>> criticalConnectionList = new ArrayList<>();

    for (final List<Integer> connection : connections) {
      removeConnectionFromGraph(connection);

      if (!areAllVerticesReachable()) {
        criticalConnectionList.add(connection);
      }
      addConnectionToGraph(connection);
    }

    return criticalConnectionList;
  }

  /**
   * Creates the graph representation of the network.
   *
   * @param n The number of vertices on the network.
   * @param connections The list of connections on the network.
   */
  private void createGraph(final int n, final List<List<Integer>> connections) {
    for (int node = 0; node < n; ++node) {
      graph.put(node, new HashSet<>());
    }

    for (final List<Integer> connection : connections) {
      addConnectionToGraph(connection);
    }
  }

  /**
   * Removes the provided connection from the network.
   *
   * @param connectionToRemove The connection to remove.
   */
  private void removeConnectionFromGraph(final List<Integer> connectionToRemove) {
    final int vertex1 = connectionToRemove.get(0);
    final int vertex2 = connectionToRemove.get(1);

    graph.get(vertex1).remove(vertex2);
    graph.get(vertex2).remove(vertex1);
  }

  /**
   * Adds a connection to the network.
   *
   * @param connectionToRemove The connection to add to the network.
   */
  private void addConnectionToGraph(final List<Integer> connectionToRemove) {
    final int vertex1 = connectionToRemove.get(0);
    final int vertex2 = connectionToRemove.get(1);

    graph.get(vertex1).add(vertex2);
    graph.get(vertex2).add(vertex1);
  }

  /**
   * Validates if all the vertices in the network are reachable from any vertex on the network.
   *
   * @return True If all vertices are reachable. Otherwise returns false.
   */
  private boolean areAllVerticesReachable() {

    final Set<Integer> visitedVerties = new HashSet<>();
    final Stack<Integer> stack = new Stack<>();

    final int startVertex = 0;
    stack.add(startVertex);

    while (!stack.isEmpty()) {
      final int poppedVertex = stack.pop();
      visitedVerties.add(poppedVertex);

      for (final int neighbor : graph.get(poppedVertex)) {
        if (!visitedVerties.contains(neighbor)) {
          stack.add(neighbor);
        }
      }
    }

    return visitedVerties.size() == graph.size();
  }
}
