package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the
 * top?
 *
 * <pre>
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/climbing-stairs/description/">Climbing Stairs</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class ClimbingStairs {

  /**
   * A map to store intermediate distinct ways to climb stairs. This map can be used for
   * intermediate repetitive recursive iterations.
   */
  private static final Map<Integer, Integer> distinctWaysKeyedByStairs = new HashMap<>();

  public ClimbingStairs() {
    // 1 step can have 1 distinct way to climb.
    distinctWaysKeyedByStairs.put(1, 1);
    // 2 steps can have 2 distinct ways to climb.
    distinctWaysKeyedByStairs.put(2, 2);
  }

  /**
   * Provides the distinct ways to climb to the top.
   *
   * @param n The total number of steps.
   * @return The distinct ways to climb to the top.
   */
  public int climbStairs(int n) {
    if (distinctWaysKeyedByStairs.containsKey(n)) {
      return distinctWaysKeyedByStairs.get(n);
    }

    final int distinctWays = climbStairs(n - 1) + climbStairs(n - 2);
    distinctWaysKeyedByStairs.put(n, distinctWays);

    return distinctWays;
  }
}
