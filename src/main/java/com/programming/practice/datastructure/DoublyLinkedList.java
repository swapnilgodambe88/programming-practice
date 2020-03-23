package com.programming.practice.datastructure;

/**
 * A DoublyLinkedList implementation.
 *
 * @param <T> The type of element in doubly linked list.
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DoublyLinkedList<T> {

  /**
   * Representation of doubly linked list node
   *
   * @author Swapnil Godambe.<br>
   *     Copyright 2020.
   */
  public final class DDLNode {
    public final T value;
    public DDLNode prev;
    public DDLNode next;

    /**
     * Constructor for {@link DDLNode}.
     *
     * @param value The value of the node.
     */
    public DDLNode(final T value) {
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }

  private DDLNode head;
  private DDLNode tail;
  private int capacity;

  /** Constructor for {@link DoublyLinkedList}. */
  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.capacity = 0;
  }

  /** @return True If the doubly linked list is empty. Otherwise, false. */
  public boolean isEmpty() {
    return capacity == 0;
  }

  /**
   * Adds a node with the provided value to the head of the doubly linked list.
   *
   * @param value The value of the node.
   * @return The inserted {@link DDLNode}.
   */
  public DDLNode addToHead(final T value) {
    final DDLNode nodeToInsert = new DDLNode(value);

    if (isEmpty()) {
      head = nodeToInsert;
      tail = nodeToInsert;
    } else {
      nodeToInsert.next = head;
      head.prev = nodeToInsert;
      head = nodeToInsert;
    }

    capacity++;
    return nodeToInsert;
  }

  /**
   * Adds a node with the provided value to the tail of the doubly linked list.
   *
   * @param value The value of the node.
   * @return The inserted {@link DDLNode}.
   */
  public DDLNode addToTail(final T value) {
    final DDLNode nodeToInsert = new DDLNode(value);

    if (isEmpty()) {
      head = nodeToInsert;
      tail = nodeToInsert;
    } else {
      nodeToInsert.prev = tail;
      tail.next = nodeToInsert;
      tail = nodeToInsert;
    }

    capacity++;
    return nodeToInsert;
  }

  /**
   * Removes the nodes from the head of the doubly linked list.
   *
   * @return The integer value of the node.
   * @throws UnsupportedOperationException If the doubly linked list is empty.
   */
  public T removeFromHead() throws UnsupportedOperationException {
    if (isEmpty()) {
      throw new UnsupportedOperationException(
          "Cannot remove element from Head since doubly linked list is empty");
    }

    final DDLNode nodeToRemove = head;
    head = head.next;

    // NOTE: This condition will be false if the list has a single node and needs to be removed.
    if (head != null) {
      head.prev = null;
    }

    nodeToRemove.next = null;
    nodeToRemove.prev = null;

    capacity--;
    return nodeToRemove.value;
  }

  /**
   * Removes the nodes from the tail of the doubly linked list.
   *
   * @return The integer value of the node.
   * @throws UnsupportedOperationException If the doubly linked list is empty.
   */
  public T removeFromTail() throws UnsupportedOperationException {
    if (isEmpty()) {
      throw new UnsupportedOperationException(
          "Cannot remove element from Tail since doubly linked list is empty");
    }

    final DDLNode nodeToRemove = tail;
    tail = tail.prev;

    // NOTE: This condition will be false if the list has a single node and needs to be removed.
    if (tail != null) {
      tail.next = null;
    }

    nodeToRemove.next = null;
    nodeToRemove.prev = null;

    capacity--;
    return nodeToRemove.value;
  }

  /**
   * Removes the provided {@link DDLNode} from the doubly linked list.
   *
   * @param nodeToRemove The {@link DDLNode} to remove (cannot be null).
   * @throws UnsupportedOperationException If the provided node is null.
   */
  public void removeDDLNode(DDLNode nodeToRemove) throws UnsupportedOperationException {
    if (nodeToRemove == null) {
      throw new UnsupportedOperationException("Node to remove is null");
    } else if (nodeToRemove == head) {
      removeFromHead();
      return;
    } else if (nodeToRemove == tail) {
      removeFromTail();
      return;
    } else {
      final DDLNode prevNode = nodeToRemove.prev;
      final DDLNode nextNode = nodeToRemove.next;

      prevNode.next = nextNode;
      nextNode.prev = prevNode;

      capacity--;
      nodeToRemove = null;
    }
  }

  /**
   * @return The {@link DDLNode} at the head of the doubly linked list. Returns null, if list is
   *     empty.
   */
  public DDLNode peekHead() {
    if (isEmpty()) {
      return null;
    }

    return head;
  }

  /**
   * @return The {@link DDLNode} at the tail of the doubly linked list. Returns null, if list is
   *     empty.
   */
  public DDLNode peekTail() {
    if (isEmpty()) {
      return null;
    }

    return tail;
  }
}
