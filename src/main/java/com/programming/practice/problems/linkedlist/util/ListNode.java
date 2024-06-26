package com.programming.practice.problems.linkedlist.util;

import java.util.Objects;

/**
 * Singly linked-list representation.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ListNode {
  public int val;
  public ListNode next;

  /**
   * Constructor for {@link ListNode}.
   *
   * @param val The value for the node.
   */
  public ListNode(int val) {
    this.val = val;
    this.next = null;
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    ListNode iterator = this;
    String printValue = "";

    while (iterator != null) {
      printValue += " -> " + iterator.val;
      iterator = iterator.next;
    }
    return printValue;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (!(object instanceof ListNode)) {
      return false;
    }

    final ListNode other = (ListNode) object;
    if (val != other.val) {
      return false;
    }

    return Objects.equals(this.next, other.next);
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }

  /**
   * Converts an integer array to linked list.
   *
   * @param inputArray The input Array.
   * @return A {@link ListNode} representing singly linked list.
   */
  public static ListNode convertArrayToLinkedList(final int[] inputArray) {
    final ListNode headNode = new ListNode(-1);

    ListNode currNode = headNode;

    for (int i = 0; i < inputArray.length; ++i) {
      currNode.next = new ListNode(inputArray[i]);
      currNode = currNode.next;
    }

    return headNode.next;
  }
}
