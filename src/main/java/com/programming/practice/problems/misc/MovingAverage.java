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
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/moving-average-from-data-stream/">Moving Average
 *     from Data Stream</a>
 */
public class MovingAverage {

  final Queue<Integer> queue;
  final int size;
  int runningSum;

  /**
   * Constructor for {@link MovingAverage}.
   *
   * @param size The size of the data stream.
   */
  public MovingAverage(final int size) {
    this.queue = new LinkedList<>();
    this.size = size;
    this.runningSum = 0;
  }

  public double next(final int val) {
    if (queue.size() == size) {
      final int dequeuedElement = queue.remove();
      runningSum -= dequeuedElement;
    }

    queue.add(val);
    runningSum += val;

    return runningSum / (double) queue.size();
  }
}
