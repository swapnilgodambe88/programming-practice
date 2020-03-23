/** */
package com.programming.practice.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ImplementQueueUsingStack}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ImplementQueueUsingStackTest {

  @Test
  public void testQueueUsingStack() {
    final ImplementQueueUsingStack obj = new ImplementQueueUsingStack();

    Assert.assertTrue(obj.empty());

    obj.push(10);
    Assert.assertFalse(obj.empty());
    Assert.assertEquals(10, obj.peek());

    obj.push(11);
    obj.push(12);
    obj.push(13);
    obj.push(14);
    obj.push(15);

    Assert.assertFalse(obj.empty());
    Assert.assertEquals(10, obj.peek());

    Assert.assertEquals(10, obj.pop());
    Assert.assertEquals(11, obj.pop());
    Assert.assertEquals(12, obj.pop());
    Assert.assertEquals(13, obj.pop());
    Assert.assertEquals(14, obj.pop());
    Assert.assertEquals(15, obj.pop());

    Assert.assertTrue(obj.empty());
  }
}
