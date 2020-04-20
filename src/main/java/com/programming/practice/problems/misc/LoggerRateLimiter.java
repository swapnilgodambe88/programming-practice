package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message
 * should be printed if and only if it is not printed in the last 10 seconds.
 *
 * <p>Given a message and a timestamp (in seconds granularity), return true if the message should be
 * printed in the given timestamp, otherwise returns false.
 *
 * <p>It is possible that several messages arrive roughly at the same time.
 *
 * <pre>
 * Example:
 *
 * Logger logger = new Logger();
 *
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 *
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 *
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 *
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 *
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 *
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/logger-rate-limiter/">Logger Rate Limiter</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class LoggerRateLimiter {

  private final Map<String, Integer> map;

  /** Constructor for {@link LoggerRateLimiter} */
  public LoggerRateLimiter() {
    this.map = new HashMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed. The timestamp is in seconds
   * granularity.
   *
   * @param timestamp The timestamp of the message.
   * @param message The message.
   */
  public boolean shouldPrintMessage(final int timestamp, final String message) {

    if (map.containsKey(message)) {
      final int timeDifference = timestamp - map.get(message);

      if (timeDifference >= 10) {
        map.put(message, timestamp);
        return true;
      } else {
        return false;
      }
    }

    map.put(message, timestamp);
    return true;
  }
}
