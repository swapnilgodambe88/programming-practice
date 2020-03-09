package com.programming.practice.problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from,
 * to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.
 *
 * <p>Note:
 *
 * <p>If there are multiple valid itineraries, you should return the itinerary that has the smallest
 * lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a
 * smaller lexical order than ["JFK", "LGB"]. All airports are represented by three capital letters
 * (IATA code). You may assume all tickets form at least one valid itinerary. Example 1:
 *
 * <p>Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] Output: ["JFK", "MUC",
 * "LHR", "SFO", "SJC"]
 *
 * <p>Example 2:
 *
 * <p>Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] Output:
 * ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 *
 * @see <a href = "https://leetcode.com/problems/reconstruct-itinerary/">Reconstruct Itinerary</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReconstructItinerary {

  /** A map to store the graph representation. */
  private final Map<String, PriorityQueue<String>> mapOfCityConnection = new HashMap<>();

  private final List<String> reconstructedItinerary = new ArrayList<>();

  /**
   * Reconstructs the itinerary.
   *
   * @param tickets The list of tickets.
   * @return The reconstructed itinerary.
   */
  public List<String> findItinerary(final List<List<String>> tickets) {
    constructGraph(tickets);

    dfs("JFK");

    Collections.reverse(reconstructedItinerary);

    return reconstructedItinerary;
  }

  /**
   * Constructs a graph out of the tickets.
   *
   * @param tickets The list of tickets.
   */
  private void constructGraph(final List<List<String>> tickets) {

    for (final List<String> ticket : tickets) {
      final String fromDest = ticket.get(0);
      final String toDest = ticket.get(1);

      if (!mapOfCityConnection.containsKey(fromDest)) {
        mapOfCityConnection.put(fromDest, new PriorityQueue<>());
      }

      mapOfCityConnection.get(fromDest).add(toDest);
    }
  }

  /**
   * DFS Traversal of the graph.
   *
   * @param from The from city.
   */
  private void dfs(final String from) {
    if (mapOfCityConnection.containsKey(from)) {
      final PriorityQueue<String> queue = mapOfCityConnection.get(from);

      while (!queue.isEmpty()) {
        dfs(queue.poll());
      }
    }

    reconstructedItinerary.add(from);
  }
}
