package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ImplementTrie}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class ImplementTrieTest {

  private final ImplementTrie obj = new ImplementTrie();

  @Test
  public void testScenario1() {
    obj.insert("apple");

    Assert.assertTrue(obj.search("apple"));
    Assert.assertFalse(obj.search("app"));

    Assert.assertTrue(obj.startsWith("app"));

    obj.insert("app");
    Assert.assertTrue(obj.search("app"));
  }
}
