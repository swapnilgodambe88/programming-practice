package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * <p>You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * <p>Example:
 *
 * <p>Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @see <a href = "https://leetcode.com/problems/swap-nodes-in-pairs/">Swap Nodes in Pairs</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class SwapNodesInPairs {

  /**
   * Performs in place swaps of two adjacent nodes.
   *
   * @param head The head node of the linked list.
   * @return The head of the adjusted linked list.
   */
  public ListNode swapPairs(final ListNode head) {
    ListNode iter1 = new ListNode(-1);
    iter1.next = head;

    while (iter1 != null && iter1.next != null & iter1.next.next != null) {

      ListNode currNode = iter1.next;
      ListNode tempNode = currNode.next.next;

      iter1.next = currNode.next;
      iter1.next.next = currNode;
      currNode.next = tempNode;

      iter1 = iter1.next.next;
    }

    return iter1.next;
  }
}
