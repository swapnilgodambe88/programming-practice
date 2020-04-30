package com.programming.practice.problems.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * <p>Each function accepts a timestamp parameter (in seconds granularity) and you may assume that
 * calls are being made to the system in chronological order (ie, the timestamp is monotonically
 * increasing). You may assume that the earliest timestamp starts at 1.
 *
 * <p>It is possible that several hits arrive roughly at the same time.
 *
 * <pre>
 * Example:
 *
 * HitCounter counter = new HitCounter();
 *
 * // hit at timestamp 1.
 * counter.hit(1);
 *
 * // hit at timestamp 2.
 * counter.hit(2);
 *
 * // hit at timestamp 3.
 * counter.hit(3);
 *
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 *
 * // hit at timestamp 300.
 * counter.hit(300);
 *
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 *
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/design-hit-counter/">Design Hit Counter</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DesignHitCounter {

  /** A queue to maintain timestamps received in the past 5 mins. */
  private final Queue<Integer> queue;

  /** Constructor for {@link DesignHitCounter}. */
  public DesignHitCounter() {
    this.queue = new LinkedList<>();
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(final int timestamp) {
    queue.add(timestamp);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(final int timestamp) {
    final int minTimestamp = timestamp - 300;

    if (minTimestamp > 0) {
      // Remove timestamp from the until until we have the last 5 minutes timestamp
      while (!queue.isEmpty() && queue.peek() <= minTimestamp) {
        queue.remove();
      }
    }

    return queue.size();
  }
}
