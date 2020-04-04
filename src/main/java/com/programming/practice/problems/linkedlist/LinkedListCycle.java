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
   * @param head The head of the linked list.
   * @return True If the linked list has cycle. Otherwise false.
   */
  public boolean hasCycle(final ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode oneJumpNode = head;
    ListNode twoJumpNode = head.next;

    while (oneJumpNode != null && twoJumpNode != null) {
      if (oneJumpNode.val == twoJumpNode.val) {
        return true;
      }

      oneJumpNode = oneJumpNode.next;

      if (twoJumpNode.next != null) {
        twoJumpNode = twoJumpNode.next.next;
      } else {

        // This condition will only be executed if list doesn't contain cycle & twoJumpNode is at
        // last node
        twoJumpNode = twoJumpNode.next;
      }
    }

    return false;
  }
}
