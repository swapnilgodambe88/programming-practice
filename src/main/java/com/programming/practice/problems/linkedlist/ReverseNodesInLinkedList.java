package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Reverses nodes in a linked list.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ReverseNodesInLinkedList {

  /**
   * Reverses the linked list.<br>
   * <a href="https://www.geeksforgeeks.org/reverse-a-linked-list/">Thought process</a>
   *
   * @param head The starting node of the linked list.
   * @return The head of the new linked list. https://www.geeksforgeeks.org/reverse-a-linked-list/
   */
  public ListNode reverseNodes(final ListNode head) {

    ListNode prev = null, next = null, currNode = head;

    while (currNode != null) {
      next = currNode.next;

      currNode.next = prev;
      prev = currNode;
      currNode = next;
    }

    return prev;
  }
}
