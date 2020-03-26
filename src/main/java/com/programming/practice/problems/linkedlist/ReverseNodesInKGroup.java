package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import java.util.LinkedList;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * <p>k is a positive integer and is less than or equal to the length of the linked list. If the
 * number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * <p>Example:
 *
 * <p>Given this linked list: 1->2->3->4->5
 *
 * <p>For k = 2, you should return: 2->1->4->3->5
 *
 * <p>For k = 3, you should return: 3->2->1->4->5
 *
 * @see <a href = "https://leetcode.com/problems/reverse-nodes-in-k-group/">Reverse Nodes in
 *     k-Group</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class ReverseNodesInKGroup {

  /**
   * Reverses the nodes of the linked list k at a time and return it's modified list.
   *
   * @param head The head of the original Linked list.
   * @param k The k positive integer.
   * @return The head of the reversed linked list.
   */
  public ListNode reverseKGroup(final ListNode head, final int k) {
    if (head == null) {
      return null;
    }

    // Get the number of reversals required
    int numberOfKIterations = Math.floorDiv(getLinkedListSize(head), k);

    ListNode currNode = head;
    ListNode result = null;

    new LinkedList<>();

    while (numberOfKIterations > 0) {

      // Prev node will always point to the first node of the most recently reversed linked list
      // Once the list is reversed concatenate the list to the result
      ListNode prev = null, next = null;

      int count = k;

      // While loop to reverse every K elements
      // Logic similar to reverse linked list {@link ReverseNodesInLinkedList}.
      while (count > 0) {
        next = currNode.next;
        currNode.next = prev;

        prev = currNode;
        currNode = next;
        --count;
      }

      result = joinLinkedLists(result, prev);

      --numberOfKIterations;
    }

    result = joinLinkedLists(result, currNode);

    return result;
  }

  /**
   * Computes the size of the linked list.
   *
   * @param head The head of the linked list.
   * @return The size of the linkedList.
   */
  private static int getLinkedListSize(final ListNode head) {
    int count = 0;

    ListNode currNode = head;
    while (currNode != null) {
      ++count;
      currNode = currNode.next;
    }

    return count;
  }

  /**
   * Joins the two linked list, and returns a head of the joined linked list.<br>
   * NOTE: Both l1 & l2 cannot be null.
   *
   * @param l1 The head of 1st linked list.
   * @param l2 The head of 2nd linked list.
   * @return The head of the joined linked list.
   */
  private static ListNode joinLinkedLists(final ListNode l1, final ListNode l2) {
    assert (l1 != null || l2 != null) : "Both l1 and l2 are null";

    if (l1 == null) {
      // If l1 == null then send l2
      return l2;
    } else if (l2 == null) {
      // If l2 = null then send l1
      return l1;
    }
    ListNode currNode = l1;

    // Move the currNode to the last element of l1, and then point
    while (currNode != null && currNode.next != null) {
      currNode = currNode.next;
    }

    currNode.next = l2;
    return l1;
  }
}
