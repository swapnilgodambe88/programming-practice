package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TimeBasedKeyValueStore}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 */
public class TimeBasedKeyValueStoreTest {

  @Test
  public void testScenario1() {

    final TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();

    obj.set("foo", "bar", 1);
    Assert.assertEquals("bar", obj.get("foo", 1));
    Assert.assertEquals("bar", obj.get("foo", 3));

    obj.set("foo", "bar2", 4);
    Assert.assertEquals("bar2", obj.get("foo", 4));
    Assert.assertEquals("bar2", obj.get("foo", 5));
  }

  @Test
  public void testScenario2() {

    final TimeBasedKeyValueStore obj = new TimeBasedKeyValueStore();

    obj.set("love", "high", 10);
    obj.set("love", "low", 20);
    Assert.assertEquals("", obj.get("love", 5));
    Assert.assertEquals("high", obj.get("love", 10));
    Assert.assertEquals("high", obj.get("love", 15));
    Assert.assertEquals("low", obj.get("love", 20));
    Assert.assertEquals("low", obj.get("love", 25));
  }
}
