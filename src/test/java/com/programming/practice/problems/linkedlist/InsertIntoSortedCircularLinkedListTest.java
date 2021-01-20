package com.programming.practice.problems.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link InsertIntoSortedCircularLinkedList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class InsertIntoSortedCircularLinkedListTest {

  private final InsertIntoSortedCircularLinkedList obj = new InsertIntoSortedCircularLinkedList();

  /**
   * Utility method to create a circular linked list.
   *
   * @param nodesToInsert The nodes to insert into the circular linked list
   * @return The head node of the circular linked list (the first node inserted)
   */
  private static InsertIntoSortedCircularLinkedList.Node createCircularLinkedList(
      final int[] nodesToInsert) {

    if (nodesToInsert.length == 0) {
      return null;
    }

    InsertIntoSortedCircularLinkedList.Node prevNode =
        new InsertIntoSortedCircularLinkedList.Node(nodesToInsert[0]);
    final InsertIntoSortedCircularLinkedList.Node head = prevNode;
    InsertIntoSortedCircularLinkedList.Node currentNode = null;

    for (int i = 1; i < nodesToInsert.length; ++i) {
      currentNode = new InsertIntoSortedCircularLinkedList.Node(nodesToInsert[i]);

      prevNode.next = currentNode;
      prevNode = currentNode;
    }

    if (nodesToInsert.length > 1) {
      currentNode.next = head;
    } else {
      head.next = head;
    }

    return head;
  }

  @Test
  public void testScenario1() {
    final InsertIntoSortedCircularLinkedList.Node head =
        createCircularLinkedList(new int[] {3, 4, 1});

    final InsertIntoSortedCircularLinkedList.Node headAfterInsert = obj.insert(head, 2);

    Assert.assertEquals(3, headAfterInsert.val);
    Assert.assertEquals(4, headAfterInsert.next.val);
    Assert.assertEquals(1, headAfterInsert.next.next.val);

    Assert.assertEquals(2, headAfterInsert.next.next.next.val);
  }

  @Test
  public void testScenario2() {
    final InsertIntoSortedCircularLinkedList.Node head = createCircularLinkedList(new int[] {});

    final InsertIntoSortedCircularLinkedList.Node headAfterInsert = obj.insert(head, 1);

    Assert.assertEquals(1, headAfterInsert.val);
    Assert.assertEquals(1, headAfterInsert.next.val);
  }

  @Test
  public void testScenario3() {
    final InsertIntoSortedCircularLinkedList.Node head = createCircularLinkedList(new int[] {1});

    final InsertIntoSortedCircularLinkedList.Node headAfterInsert = obj.insert(head, 0);

    Assert.assertEquals(1, headAfterInsert.val);
    Assert.assertEquals(0, headAfterInsert.next.val);
  }
}
