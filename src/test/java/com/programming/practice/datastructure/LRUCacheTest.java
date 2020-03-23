package com.programming.practice.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LRUCache}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LRUCacheTest {

  @Test
  public void testScenarioWithCapacity2() {
    final LRUCache cache = new LRUCache(2);

    cache.put(1, 1);
    cache.put(2, 2);

    Assert.assertEquals(1, cache.get(1));

    cache.put(3, 3);
    Assert.assertEquals(-1, cache.get(2));

    cache.put(4, 4);
    Assert.assertEquals(-1, cache.get(1));

    Assert.assertEquals(3, cache.get(3));
    Assert.assertEquals(4, cache.get(4));

    cache.put(4, 99);
    Assert.assertEquals(99, cache.get(4));
  }

  @Test
  public void testScenarioWithCapacity1() {
    final LRUCache cache = new LRUCache(1);

    cache.put(2, 1);

    Assert.assertEquals(1, cache.get(2));
  }
}
