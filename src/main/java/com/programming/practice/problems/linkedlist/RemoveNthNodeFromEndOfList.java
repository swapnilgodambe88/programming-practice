package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * <p>Example:
 *
 * <p>Given linked list: 1->2->3->4->5, and n = 2.
 *
 * <p>After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * <p>Note: Given n will always be valid.
 *
 * @see <a href = "https://leetcode.com/problems/remove-nth-node-from-end-of-list/">Remove Nth Node
 *     From End of List</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class RemoveNthNodeFromEndOfList {

  /**
   * Removes the nth node from the list.
   *
   * @param node The head node of the linked list.
   * @param n The number n.
   * @return The head node of the new linked list.
   */
  public ListNode removeNthFromEnd(final ListNode node, final int n) {
    final ListNode resultHead = node;

    ListNode iter1 = node, iter2 = node;
    int movePosition = n;

    // Iterate such that iter2 points to nth node from start
    while (movePosition > 0 && iter2 != null) {
      iter2 = iter2.next;
      movePosition--;
    }

    // If n provided is greater than the length of linked list OR n = 0 return the list unaltered
    if (movePosition > 0 || n == 0) {
      return node;
      // If iter2 = null means n = length of list. Therefore need to delete the first node of the
      // list.
    } else if (iter2 == null) {
      return node.next;
    }

    // Loop through the list such that node to be delete is after iter1.next
    while (iter2.next != null) {
      iter1 = iter1.next;
      iter2 = iter2.next;
    }

    final ListNode nodeToDelete = iter1.next;
    iter1.next = nodeToDelete.next;

    return resultHead;
  }
}
