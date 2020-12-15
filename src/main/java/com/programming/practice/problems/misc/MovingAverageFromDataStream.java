package com.programming.practice.problems.misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the
 * sliding window.
 *
 * <pre>
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/minimum-knight-moves/">Minimum Knight Moves</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MovingAverageFromDataStream {

  private final Queue<Integer> queue;
  private final int size;
  private int total;

  /**
   * Constructor for {@link MovingAverageFromDataStream}.
   *
   * @param size The size of the data stream.
   */
  public MovingAverageFromDataStream(final int size) {
    queue = new LinkedList<>();
    this.size = size;
    this.total = 0;
  }

  /**
   * Calculates the moving average of the {@link MovingAverageFromDataStream}.
   *
   * @param val The value to add to the stream.
   * @return The moving average of the stream.
   */
  public double next(final int val) {
    if (queue.size() == size) {
      final int dequeuedElement = queue.remove();
      total -= dequeuedElement;
    }

    queue.add(val);
    total += val;

    return total / (double) queue.size();
  }
}
