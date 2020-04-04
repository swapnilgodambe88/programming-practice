package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note
 * here we are talking about the node number and not the value in the nodes.
 *
 * <p>You should try to do it in place. The program should run in O(1) space complexity and O(nodes)
 * time complexity.
 *
 * <pre>
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/odd-even-linked-list/">Odd Even Linked List</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class OddEvenLinkedList {

  /**
   * Groups all odd nodes together followed by even nodes.
   *
   * @param head The head of the linked list.
   * @return The head of the combined list.
   */
  public ListNode oddEvenList(final ListNode head) {

    if (head == null) {
      return null;
    }
    final ListNode firstEvenNode = head.next;

    ListNode oddNode = head;
    ListNode evenNode = firstEvenNode;

    while (oddNode != null && oddNode.next != null && evenNode != null && evenNode.next != null) {
      oddNode.next = oddNode.next.next;
      evenNode.next = evenNode.next.next;

      oddNode = oddNode.next;
      evenNode = evenNode.next;
    }

    oddNode.next = firstEvenNode;

    return head;
  }
}
