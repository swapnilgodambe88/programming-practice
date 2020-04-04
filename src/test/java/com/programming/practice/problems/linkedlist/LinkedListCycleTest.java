package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link LinkedListCycle}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LinkedListCycleTest {

  private final LinkedListCycle obj = new LinkedListCycle();

  @Test
  public void testCycleExists() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3});

    ListNode currentNode = l1;
    // Go till last node
    while (currentNode.next == null) {
      currentNode = currentNode.next;
    }

    // Connect last node to first node
    currentNode.next = l1;

    Assert.assertTrue(obj.hasCycle(l1));
  }

  @Test
  public void testCycleDoesntExists_evenElements() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8});

    Assert.assertFalse(obj.hasCycle(l1));
  }

  @Test
  public void testCycleDoesntExists_oddElements() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

    Assert.assertFalse(obj.hasCycle(l1));
  }

  @Test
  public void testEmptyList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {});

    Assert.assertFalse(obj.hasCycle(l1));
  }
}
