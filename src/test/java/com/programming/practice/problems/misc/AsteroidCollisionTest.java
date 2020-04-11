package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link AsteroidCollision}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class AsteroidCollisionTest {

  private final AsteroidCollision obj = new AsteroidCollision();

  @Test
  public void testScenario1() {
    final int[] asteroids = new int[] {5, 10, -5};
    final int[] expectedAsteroidState = new int[] {5, 10};

    Assert.assertArrayEquals(expectedAsteroidState, obj.asteroidCollision(asteroids));
  }

  @Test
  public void testScenario2() {
    final int[] asteroids = new int[] {8, -8};
    final int[] expectedAsteroidState = new int[] {};

    Assert.assertArrayEquals(expectedAsteroidState, obj.asteroidCollision(asteroids));
  }

  @Test
  public void testScenario3() {
    final int[] asteroids = new int[] {10, 2, -5};
    final int[] expectedAsteroidState = new int[] {10};

    Assert.assertArrayEquals(expectedAsteroidState, obj.asteroidCollision(asteroids));
  }

  @Test
  public void testScenario4() {
    final int[] asteroids = new int[] {-2, -1, 1, 2};
    final int[] expectedAsteroidState = new int[] {-2, -1, 1, 2};

    Assert.assertArrayEquals(expectedAsteroidState, obj.asteroidCollision(asteroids));
  }
}
