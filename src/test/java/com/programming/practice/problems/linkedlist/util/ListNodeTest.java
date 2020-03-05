package com.programming.practice.problems.linkedlist.util;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link ListNode}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class ListNodeTest {

  @Test
  public void testHashCode() {
    final ListNode node = new ListNode(3);

    Assert.assertEquals(Objects.hash(node.val, node.next), node.hashCode());
  }

  @Test
  public void testListNode() {
    final ListNode node = new ListNode(3);

    Assert.assertEquals(3, node.val);
    Assert.assertNull(node.next);
  }

  @Test
  public void testToString() {
    final ListNode node = new ListNode(3);

    Assert.assertTrue(" -> 3".equals(node.toString()));
  }

  @Test
  public void testSameObject() {
    final ListNode node1 = new ListNode(3);

    Assert.assertTrue(node1.equals(node1));
  }

  @Test
  public void testEqualsObject() {
    final ListNode node1 = new ListNode(3);
    final ListNode node2 = new ListNode(3);

    Assert.assertTrue(node1.equals(node2));
  }

  @Test
  public void testNotEqualsObjectInVal() {
    final ListNode node1 = new ListNode(3);
    final ListNode node2 = new ListNode(4);

    Assert.assertFalse(node1.equals(node2));
  }

  @Test
  public void testNotEqualsObjectInNext() {
    final ListNode node1 = new ListNode(3);
    final ListNode node2 = new ListNode(3);
    node2.next = new ListNode(99);

    Assert.assertFalse(node1.equals(node2));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testNotEqualsObjectInInstance() {
    final ListNode node1 = new ListNode(3);
    final Integer number = new Integer(19);

    Assert.assertFalse(node1.equals(number));
  }
}
