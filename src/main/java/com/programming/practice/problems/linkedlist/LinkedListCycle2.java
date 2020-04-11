package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * <p>To represent a cycle in the given linked list, we use an integer pos which represents the
 * position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no
 * cycle in the linked list.
 *
 * <p>Note: Do not modify the linked list.
 *
 * @see <a href = "https://leetcode.com/problems/linked-list-cycle-ii/">Linked list cycle 2</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LinkedListCycle2 {

  /**
   * Returns the node where cycle begins. If there is no cycle, returns null.
   *
   * <p><b>Using Floyd's Tortoise and hare algorithm</b>
   *
   * @param head The head of the linked list.
   * @return The node where cycle begins. If there is no cycle, returns null.
   */
  public ListNode detectCycle(final ListNode head) {

    ListNode ptr1 = intersectionNode(head);

    if (ptr1 == null) {
      return null;
    }

    ListNode ptr2 = head;

    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    return ptr1;
  }

  /**
   * Returns the intersection point where two pointers meet. Returns null, if there is no cycle in
   * the list.
   *
   * <p><b>Using Floyd's Tortoise and hare algorithm</b>
   *
   * @param head The head of the linked list.
   * @return the intersection point where two pointers meet. Returns null, if there is no cycle in
   *     the list.
   */
  private static ListNode intersectionNode(final ListNode head) {
    ListNode tortoise = head;
    ListNode hare = head;

    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;

      if (tortoise == hare) {
        return tortoise;
      }
    }

    return null;
  }
}
