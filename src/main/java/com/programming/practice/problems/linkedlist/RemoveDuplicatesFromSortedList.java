package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only
 * once. Return the linked list sorted as well.
 *
 * <pre>
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove
 *     Duplicates from Sorted List</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class RemoveDuplicatesFromSortedList {

  /**
   * Given the head of a sorted linked list, delete all duplicates such that each element appears
   * only once.
   *
   * @param head The Head node of the sorted linked-list.
   * @return Return the sorted linked list without duplicates.
   */
  public ListNode deleteDuplicates(ListNode head) {
    // If input linked list is empty, then return empty list
    if (head == null) {
      return head;
    }

    ListNode output = new ListNode(head.val);
    ListNode current = head;
    final ListNode outputHeadNode = output;

    while (current.next != null) {
      if (output.val != current.next.val) {
        output.next = new ListNode(current.next.val);
        output = output.next;
      }
      current = current.next;
    }

    return outputHeadNode;
  }
}
