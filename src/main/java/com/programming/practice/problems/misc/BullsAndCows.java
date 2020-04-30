package com.programming.practice.problems.misc;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and
 * ask your friend to guess what the number is. Each time your friend makes a guess, you provide a
 * hint that indicates how many digits in said guess match your secret number exactly in both digit
 * and position (called "bulls") and how many digits match the secret number but locate in the wrong
 * position (called "cows"). Your friend will use successive guesses and hints to eventually derive
 * the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to
 * indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * <pre>
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7. Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 *
 * <pre>
 *
 * @see <a href = "https://leetcode.com/problems/bulls-and-cows/">Bulls and Cows</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class BullsAndCows {

  /**
   * Returns the hint for the Bulls and Cows game.
   *
   * @param secret The secret string.
   * @param guess The guess string.
   * @return The hint string.
   */
  public String getHint(final String secret, final String guess) {
    final StringBuffer returnString = new StringBuffer();

    final int bullCount = evaluateBulls(secret, guess);
    returnString.append(bullCount).append('A');

    final int cowCount = matchingCount(secret, guess) - bullCount;
    returnString.append(cowCount).append('B');

    return returnString.toString();
  }

  /**
   * Evaluates the bull count.
   *
   * @param secret The secret string.
   * @param guess The guess string.
   * @return The bull count.
   */
  private static int evaluateBulls(final String secret, final String guess) {
    int count = 0;

    for (int i = 0; i < secret.length(); ++i) {
      if (secret.charAt(i) == guess.charAt(i)) {
        ++count;
      }
    }

    return count;
  }

  /**
   * Evaluates the matching count of characters between the secret and the guess string.
   *
   * @param secret The secret string.
   * @param guess The guess string.
   * @return The matching count.
   */
  private static int matchingCount(final String secret, final String guess) {
    final int[] count = new int[10];

    for (final char character : guess.toCharArray()) {
      ++count[character - '0'];
    }

    int matchingCount = 0;
    for (final char character : secret.toCharArray()) {
      if (count[character - '0'] > 0) {
        ++matchingCount;
        --count[character - '0'];
      }
    }

    return matchingCount;
  }
}
