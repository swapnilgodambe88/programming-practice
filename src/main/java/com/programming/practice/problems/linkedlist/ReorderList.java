package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 *
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * @see <a href = "https://leetcode.com/problems/reorder-list/">Reorder List</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 * @company eBay
 */
public final class ReorderList {

  /**
   * Reorders the linked list such that if : L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
   * <p>
   * Logic:
   * <ul>
   * <li>start with node after head</li>
   * <li>Reverse the list</li>
   * <li>Increment the current pointer</li>
   * <li>Repeat reverse and increment steps</li>
   * </ul>
   *
   * @param head The head of the linked list.
   */
  public void reorderList(final ListNode head) {
    if (head == null) {
      return;
    }

    final ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

    ListNode prevNode = head;
    ListNode currNode = head.next;
    while (currNode != null) {

      currNode = reverseLinkedList.reverseList(currNode);

      // Connect the prevNode with the reversed list
      prevNode.next = currNode;

      // Increment both currNode & prevNodes
      prevNode = prevNode.next;
      currNode = currNode.next;
    }
  }
}
