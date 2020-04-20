package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link AddAndSearchWord}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class AddAndSearchWordTest {

  @Test
  public void testScenario() {
    final AddAndSearchWord obj = new AddAndSearchWord();

    obj.addWord("bad");
    obj.addWord("dad");
    obj.addWord("mad");

    Assert.assertFalse(obj.search(("pad")));
    Assert.assertTrue(obj.search(("bad")));
    Assert.assertTrue(obj.search((".ad")));
    Assert.assertTrue(obj.search(("b..")));
    Assert.assertTrue(obj.search("..."));
    Assert.assertFalse(obj.search("bada"));
    Assert.assertFalse(obj.search("ba"));
  }
}
