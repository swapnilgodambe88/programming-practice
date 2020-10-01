package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link RandomizedSet}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RandomizedSetTest {

  private final RandomizedSet obj = new RandomizedSet();

  @Test
  public void testScenario1() {
    Assert.assertTrue(obj.insert(1));
    Assert.assertFalse(obj.remove(2));
    Assert.assertTrue(obj.insert(2));

    obj.getRandom();

    Assert.assertTrue(obj.remove(1));
    Assert.assertFalse(obj.insert(2));

    obj.getRandom();
  }
}
