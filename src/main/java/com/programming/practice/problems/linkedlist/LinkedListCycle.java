package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * <p>To represent a cycle in the given linked list, we use an integer pos which represents the
 * position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no
 * cycle in the linked list.
 *
 * @see <a href = "https://leetcode.com/problems/linked-list-cycle/">Linked List Cycle</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class LinkedListCycle {

  /**
   * Determines if the linked list has a cycle or not.
   *
   * <p><b>Using Floyd's Tortoise and hare algorithm</b>
   *
   * @param head The head of the linked list.
   * @return True If the linked list has cycle. Otherwise false.
   */
  public boolean hasCycle(final ListNode head) {

    ListNode tortoise = head;
    ListNode hare = head;

    // Since hare is the fast pointer, this would be the one reaching null (if loop doesn't exists).
    // Therefore no condition required for tortoise
    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;

      if (tortoise == hare) {
        return true;
      }
    }

    return false;
  }
}
