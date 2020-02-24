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
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SwapNodesInPairs {

  /**
   * Performs in place swaps of two adjacent nodes.
   *
   * @param head The head node of the linked list.
   * @return The head of the adjusted linked list.
   */
  public ListNode swapPairs(final ListNode head) {
    ListNode iter = new ListNode(-1);
    iter.next = head;

    // Creating a copy of the iter node since we will increment it in while loop
    final ListNode iterCopy = iter;

    while (iter != null && iter.next != null && iter.next.next != null) {

      ListNode oddNode = iter.next;
      ListNode evenNode = oddNode.next;

      iter.next = evenNode;
      oddNode.next = evenNode.next;
      evenNode.next = oddNode;

      iter = iter.next.next;
    }

    return iterCopy.next;
  }
}
