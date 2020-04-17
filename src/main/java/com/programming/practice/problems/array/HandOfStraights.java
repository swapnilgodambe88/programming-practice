package com.programming.practice.problems.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Alice has a hand of cards, given as an array of integers.
 *
 * <p>Now she wants to rearrange the cards into groups so that each group is size W, and consists of
 * W consecutive cards.
 *
 * <p>Return true if and only if she can.
 *
 * <pre>
 * Example 1:
 *
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * Example 2:
 *
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/hand-of-straights/">Hand of Straights</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class HandOfStraights {

  /**
   * Determines if the hand is straight.
   *
   * @param hand The hand of cards.
   * @param W The number W.
   * @return True If the hand is straight. Otherwise, false.
   */
  public boolean isNStraightHand(final int[] hand, final int W) {
    final Map<Integer, Integer> map = new TreeMap<>();

    for (final int card : hand) {
      final int count = map.getOrDefault(card, 0);
      map.put(card, count + 1);
    }

    while (map.size() > 0) {

      // Since we are using treemap the keys will be sorted in ascending order.
      final int lowestCardInMap = map.keySet().iterator().next();

      for (int sequence = lowestCardInMap; sequence < lowestCardInMap + W; ++sequence) {
        if (!map.containsKey(sequence)) {
          return false;
        }

        final int count = map.get(sequence);
        if (count == 1) {
          map.remove(sequence);
        } else {
          map.put(sequence, count - 1);
        }
      }
    }

    return true;
  }
}
