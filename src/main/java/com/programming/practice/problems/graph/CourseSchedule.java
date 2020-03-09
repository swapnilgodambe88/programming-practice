package com.programming.practice.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * <p>Some courses may have prerequisites, for example to take course 0 you have to first take
 * course 1, which is expressed as a pair: [0,1]
 *
 * <p>Given the total number of courses and a list of prerequisite pairs, is it possible for you to
 * finish all courses?
 *
 * <p>Example 1:
 *
 * <p>Input: 2, [[1,0]] Output: true Explanation: There are a total of 2 courses to take. To take
 * course 1 you should have finished course 0. So it is possible.
 *
 * <p>Example 2:
 *
 * <p>Input: 2, [[1,0],[0,1]] Output: false Explanation: There are a total of 2 courses to take. To
 * take course 1 you should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 *
 * @see <a href = "https://leetcode.com/problems/course-schedule/">Course Schedule</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @note Failing two test cases on leetcode because of time limit exceeded.
 */
public final class CourseSchedule {

  /**
   * Global variable used for DFS traversal.<br>
   * NOTE: Gets reset for DFS traversal for every node.
   */
  private final Set<Integer> visitedNodes = new HashSet<>();

  /** A map to store graph neighbors information. */
  private final Map<Integer, List<Integer>> neighborMap = new HashMap<>();

  /**
   * Evaluates if the courses can be finished or not.
   *
   * @param numCourses The number of courses.
   * @param prerequisites The prerequisites.
   * @return True If the courses can be finished. Otherwise false.
   */
  public boolean canFinish(final int numCourses, final int[][] prerequisites) {
    createDirectedGraph(numCourses, prerequisites);

    return isCyclePresentInGraph();
  }

  /**
   * Create a directed graph.
   *
   * @param numCourses The number of courses.
   * @param prerequisites The prerequisites.
   */
  private void createDirectedGraph(final int numCourses, final int[][] prerequisites) {
    neighborMap.clear();

    // Add nodes
    for (int i = 0; i < numCourses; ++i) {
      neighborMap.put(i, new ArrayList<>());
    }

    // Add neighbor information to graph
    for (final int[] prerequisite : prerequisites) {
      neighborMap.get(prerequisite[1]).add(prerequisite[0]);
    }
  }

  /** @return True If a cycle is present on the graph. Otherwise returns false. */
  private boolean isCyclePresentInGraph() {
    for (final int startNode : neighborMap.keySet()) {
      visitedNodes.clear();
      if (!DFS(startNode, new ArrayList<>())) {
        return false;
      }
    }

    return true;
  }

  /**
   * DFS traversal with the start node.
   *
   * @param startNode The start node of the DFS traversal.
   * @param nodesVisitedSoFar A list to keep track of nodes visited so far. A loop is detected if
   *     the same vertex is encountered already present on the list.
   * @return True If DFS traversal is complete and not loop is present. Otherwise false if loop is
   *     detected.
   */
  private boolean DFS(final int startNode, final List<Integer> nodesVisitedSoFar) {
    boolean executedIfCondition = false;
    if (!nodesVisitedSoFar.contains(startNode) && !visitedNodes.contains(startNode)) {
      executedIfCondition = true;
      nodesVisitedSoFar.add(startNode);
      visitedNodes.add(startNode);

      for (final int neighbor : neighborMap.get(startNode)) {
        if (!DFS(neighbor, getDeepCopy(nodesVisitedSoFar))) {
          return false;
        }
      }
    }

    // Loop is only present if the above condition is not executed because the node is present on
    // the nodesVisitedSoFar list.
    if (!executedIfCondition && nodesVisitedSoFar.contains(startNode)) {
      return false;
    }

    return true;
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
