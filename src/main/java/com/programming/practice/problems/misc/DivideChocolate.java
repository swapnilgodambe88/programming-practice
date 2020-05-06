package com.programming.practice.problems.misc;

/**
 * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given
 * by the array sweetness.
 *
 * <p>You want to share the chocolate with your K friends so you start cutting the chocolate bar
 * into K+1 pieces using K cuts, each piece consists of some consecutive chunks.
 *
 * <p>Being generous, you will eat the piece with the minimum total sweetness and give the other
 * pieces to your friends.
 *
 * <p>Find the maximum total sweetness of the piece you can get by cutting the chocolate bar
 * optimally.
 *
 * <pre>
 * Example 1:
 *
 * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * Output: 6
 * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
 * Example 2:
 *
 * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * Output: 1
 * Explanation: There is only one way to cut the bar into 9 pieces.
 * Example 3:
 *
 * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * Output: 5
 * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/divide-chocolate/">Divide Chocolate</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class DivideChocolate {

  /**
   * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar
   * optimally.
   *
   * @param sweetness The sweetness array.
   * @param K The number of friends to distribute the chocolate.
   * @return The maximum total sweetness of the piece you can get by cutting the chocolate bar
   *     optimally.
   */
  public int maximizeSweetness(final int[] sweetness, final int K) {
    int minSweetness = Integer.MAX_VALUE;
    int maxSweetness = 0;

    for (final int sweet : sweetness) {
      minSweetness = Math.min(minSweetness, sweet);
      maxSweetness += sweet;
    }

    int left = minSweetness, right = maxSweetness;

    // Find the ideal sweetness with the help of binary search
    while (left < right) {
      final int targetSweetness = left + (right - left) / 2;

      if (canSplit(sweetness, targetSweetness, K)) {
        // after a greedy approach above we check if the current sweetness is 'fair' if we got more
        // chunks than friends we have, that it value is OK and we will try to find a little more
        // sweetness for our friends if it exists
        left = targetSweetness + 1;
      } else {
        // otherwise, we have too much sweetness and some of our friends won't try the chocolate bar
        // hence, we want to reduce the sweetness in the next attempt and decrease our boundaries
        right = targetSweetness;
      }
    }

    // here our minimum and maximum sweetness are the same, we did all attempts and made our
    // decision.
    return left;
  }

  /**
   * Determines if the bar can be split between K people with the targetSweetness in every chunk.
   *
   * @param sweetness The sweetness array.
   * @param targetSweetness The targetSweetness.
   * @param k The K value.
   * @return True if the bar can be split between K people. Otherwise, false.
   */
  private static boolean canSplit(final int[] sweetness, final int targetSweetness, final int k) {
    int chunks = 0;
    int currentSweetness = 0;

    for (final int sweet : sweetness) {
      currentSweetness += sweet;

      // If the current sweetness went ahead of the target sweetness we have to move it away, and
      // start collecting a new one for another friend.
      if (currentSweetness > targetSweetness) {
        ++chunks;
        currentSweetness = 0;
      }
    }

    return chunks > k;
  }
}
