package com.programming.practice.problems.misc;

import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * <p>For each asteroid, the absolute value represents its size, and the sign represents its
 * direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * <p>Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode. Two asteroids moving in the same
 * direction will never meet.
 *
 * <pre>
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 *
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 *
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 *
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/asteroid-collision/">Asteroid Collision</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class AsteroidCollision {

  /**
   * Find out the state of the asteroids after all collisions.
   *
   * @param asteroids An asteroids array.
   * @return The state of asteroids after all collisions.
   */
  public int[] asteroidCollision(final int[] asteroids) {

    final Stack<Integer> stack = new Stack<>();

    for (final int astroid : asteroids) {
      stack.push(astroid);

      while (!stack.isEmpty()) {
        if (stack.size() < 2) {
          break;
        }

        final int rightAsteroid = stack.pop();
        final int leftAsteroid = stack.pop();

        if (doAsteroidsCollide(leftAsteroid, rightAsteroid)) {
          final Integer remainingAsteroidAfterCollision =
              findRemainingAsteroidAfterCollision(leftAsteroid, rightAsteroid);

          if (remainingAsteroidAfterCollision == null) {
            // Both asteroids cancel out each other and get destroyed.
            break;
          } else {
            // If only one asteroid remains after collision, then push the remaining asteroid on the
            // stack and continue the iteration of the while loop
            stack.push(remainingAsteroidAfterCollision);
          }
        } else {
          // If asteroids don't collide means both are traveling in the same direction. Therefore
          // push both the asteroids back into the stack
          stack.push(leftAsteroid);
          stack.push(rightAsteroid);
          break;
        }
      }
    }

    final int[] finalAsteroidState = new int[stack.size()];
    int index = stack.size() - 1;

    while (!stack.isEmpty()) {
      finalAsteroidState[index--] = stack.pop();
    }

    return finalAsteroidState;
  }

  /**
   * Check if asteroids collide or not.
   *
   * @param leftAsteroid The left asteroid.
   * @param rightAsteroid The right asteroid.
   * @return True If both asteroids collide. Otherwise, false.
   */
  private static boolean doAsteroidsCollide(final int leftAsteroid, final int rightAsteroid) {
    if (leftAsteroid > 0 && rightAsteroid < 0) {
      return true;
    }

    return false;
  }

  /**
   * Returns the remaining asteroid after collision. Returns null if both asteroids are destroyed
   * after collision.
   *
   * @param leftAsteroid The left asteroid.
   * @param rightAsteroid The right asteroid.
   * @return The remaining asteroid after collision. Returns null if both asteroids are destroyed.
   */
  private static Integer findRemainingAsteroidAfterCollision(
      final int leftAsteroid, final int rightAsteroid) {
    if (Math.abs(leftAsteroid) == Math.abs(rightAsteroid)) {
      return null;
    } else if (Math.abs(leftAsteroid) > Math.abs(rightAsteroid)) {
      return leftAsteroid;
    }

    return rightAsteroid;
  }
}
