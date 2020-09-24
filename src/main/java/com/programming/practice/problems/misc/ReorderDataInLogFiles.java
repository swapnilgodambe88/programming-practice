package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have an array of logs. Each log is a space delimited string of words.
 *
 * <p>For each log, the first word in each log is an alphanumeric identifier. Then, either:
 *
 * <ul>
 *   <li>Each word after the identifier will consist only of lowercase letters, or;
 *   <li>Each word after the identifier will consist only of digits.
 * </ul>
 *
 * We will call these two varieties of logs letter-logs and digit-logs. It is guaranteed that each
 * log has at least one word after its identifier.
 *
 * <p>Reorder the logs so that all of the letter-logs come before any digit-log. The letter-logs are
 * ordered lexicographically ignoring identifier, with the identifier used in case of ties. The
 * digit-logs should be put in their original order.
 *
 * <p>Return the final order of the logs.
 *
 * <pre>
 * Example 1:
 *
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/reorder-data-in-log-files/">Reorder Data in Log
 *     Files</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReorderDataInLogFiles {

  /**
   * Reorders the logs so that all of the letter-logs come before any digit-log. The letter-logs are
   * ordered lexicographically ignoring identifier, with the identifier used in case of ties. The
   * digit-logs should be put in their original order.
   *
   * @param logs The array of logs.
   * @return
   */
  public String[] reorderLogFiles(final String[] logs) {

    final Comparator<String> logComparator =
        (log1, log2) -> {
          final String[] split1 = log1.split("\\s", 2);
          final String[] split2 = log2.split("\\s", 2);

          final boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
          final boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

          if (!isDigit1 && !isDigit2) {
            final int compareValue = split1[1].compareTo(split2[1]);

            if (compareValue != 0) {
              return compareValue;
            }

            // Compare the identifiers if words are same
            return split1[0].compareTo(split2[0]);
          }
          return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        };
    Arrays.sort(logs, logComparator);

    return logs;
  }
}
