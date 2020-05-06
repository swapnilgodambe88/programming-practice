package com.programming.practice.problems.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2',
 * '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we
 * can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * <p>The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * <p>You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 *
 * <p>Given a target representing the value of the wheels that will unlock the lock, return the
 * minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 * <pre>
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 *
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 *
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 *
 * Example 4:
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/open-the-lock/">Open the lock</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class OpenTheLock {

  /**
   * Given a target representing the value of the wheels that will unlock the lock, returns the
   * minimum total number of turns required to open the lock, or -1 if it is impossible.
   *
   * @param deadends The array of deadends
   * @param target The target lock combination.
   * @return The minimum total number of turns required to open the lock. -1 if it is impossible.
   */
  public int openLock(final String[] deadends, final String target) {
    final Set<String> deadendSet = new HashSet<>();

    for (final String deadend : deadends) {
      deadendSet.add(deadend);
    }

    final Set<String> visitedCombination = new HashSet<>();
    final Queue<String> queue = new LinkedList<>();
    queue.add("0000");

    int depth = 0;
    while (!queue.isEmpty()) {

      final int combinationsToEvaluateAtCurrentLevel = queue.size();

      for (int i = 0; i < combinationsToEvaluateAtCurrentLevel; ++i) {
        final String currentCombination = queue.poll();

        if (currentCombination.equals(target)) {
          return depth;
        }

        if (deadendSet.contains(currentCombination)
            || visitedCombination.contains(currentCombination)) {
          continue;
        }

        final String[] nextPossibleCombinations = getNextPossibleCombinations(currentCombination);

        for (final String nextCombination : nextPossibleCombinations) {
          queue.add(nextCombination);
        }

        // Once all the possible combinations from the current combinations are added to the queue,
        // mark this current combination as visited.
        visitedCombination.add(currentCombination);
      }

      ++depth;
    }

    return -1;
  }

  /**
   * Generates all possible combinations from a current combination.
   *
   * @param currentCombination The current combination string.
   * @return All possible combinations from a current combination
   */
  private static String[] getNextPossibleCombinations(final String currentCombination) {
    final String[] nextPossibleCombinations = new String[8];

    int count = 0;
    for (int i = 0; i < 4; ++i) {
      // Because of implicit type casting charAt character is converted to ascii value. So
      // subtracting by '0' gives the integer value.

      final int intValueOfCharacter = currentCombination.charAt(i) - '0';
      final int next = (intValueOfCharacter + 1) % 10;

      // 10 is added to prevent negative value. e.g. intValueOfCharacter is 0 then prev needs to be
      // 9
      final int previous = (10 + intValueOfCharacter - 1) % 10;

      nextPossibleCombinations[count++] =
          currentCombination.substring(0, i) + next + currentCombination.substring(i + 1);
      nextPossibleCombinations[count++] =
          currentCombination.substring(0, i) + previous + currentCombination.substring(i + 1);
    }

    return nextPossibleCombinations;
  }
}
