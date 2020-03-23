package com.programming.practice.datastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DoublyLinkedList}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DoublyLinkedListTest {

  @Test
  public void testScenario1() {
    final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

    Assert.assertTrue(dll.isEmpty());
    Assert.assertNull(dll.peekHead());
    Assert.assertNull(dll.peekTail());

    dll.addToHead(11);
    Assert.assertFalse(dll.isEmpty());
    Assert.assertNotNull(dll.peekHead());
    Assert.assertNotNull(dll.peekTail());
    Assert.assertEquals(11, (int) dll.peekHead().value);
    Assert.assertEquals(11, (int) dll.peekTail().value);
    Assert.assertEquals(dll.peekHead(), dll.peekTail());

    dll.addToTail(12);
    Assert.assertFalse(dll.isEmpty());
    Assert.assertNotNull(dll.peekTail());
    Assert.assertEquals(12, (int) dll.peekTail().value);

    dll.addToHead(10);
    final DoublyLinkedList<Integer>.DDLNode insertedDDLNode1 = dll.addToHead(9);
    Assert.assertEquals(dll.peekHead(), insertedDDLNode1);

    final DoublyLinkedList<Integer>.DDLNode insertedDDLNode2 = dll.addToTail(14);
    Assert.assertEquals(dll.peekTail(), insertedDDLNode2);

    Assert.assertNotNull(dll.peekTail());
    Assert.assertEquals(14, (int) dll.peekTail().value);

    Assert.assertNotNull(dll.peekHead());
    Assert.assertEquals(9, (int) dll.peekHead().value);

    Assert.assertEquals(
        "Failed assertion on new tail node after removing the previous tail node",
        14,
        (int) dll.removeFromTail());
    Assert.assertNotNull(dll.peekTail());
    Assert.assertEquals(12, (int) dll.peekTail().value);

    Assert.assertEquals(9, (int) dll.removeFromHead());
    Assert.assertNotNull(dll.peekHead());
    Assert.assertEquals(
        "Failed assertion on new head node after removing the previous head node",
        10,
        (int) dll.peekHead().value);

    final DoublyLinkedList<Integer>.DDLNode nodeAfterHead = dll.peekHead().next;
    dll.removeDDLNode(nodeAfterHead);

    Assert.assertEquals(
        "Failed assertion on peekNode.next after removing the peekNode next element",
        12,
        (int) dll.peekHead().next.value);
  }

  @Test
  public void testRemoveFromHeadThrowsException() {
    final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

    Assert.assertThrows(
        "Cannot remove element from Head since doubly linked list is empty",
        UnsupportedOperationException.class,
        () -> {
          dll.removeFromHead();
        });
  }

  @Test
  public void testRemoveFromTailThrowsException() {
    final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

    Assert.assertThrows(
        "Cannot remove element from Tail since doubly linked list is empty",
        UnsupportedOperationException.class,
        () -> {
          dll.removeFromTail();
        });
  }

  @Test
  public void testRemoveDLLNodeThrowsException() {
    final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

    Assert.assertThrows(
        "Node to remove is null",
        UnsupportedOperationException.class,
        () -> {
          dll.removeDDLNode(null);
        });
  }

  @Test
  public void testRemoveDLLNodeRemoveHead() {
    final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    dll.addToHead(1);
    dll.addToHead(2);
    dll.addToHead(3);
    dll.addToHead(4);

    dll.removeDDLNode(dll.peekHead());
    Assert.assertEquals(3, (int) dll.peekHead().value);
  }

  @Test
  public void testRemoveDLLNodeRemoveTail() {
    final DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
    dll.addToTail(1);
    dll.addToTail(2);
    dll.addToTail(3);
    dll.addToTail(4);

    dll.removeDDLNode(dll.peekTail());
    Assert.assertEquals(3, (int) dll.peekTail().value);
  }
}
