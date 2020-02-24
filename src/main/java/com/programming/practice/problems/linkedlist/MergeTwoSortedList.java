package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * <p>Example:
 *
 * <p>Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 *
 * @see <a href = "https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MergeTwoSortedList {

  /**
   * Merge two sorted lists.
   *
   * @param l1 Sorted List 1.
   * @param l2 Sorted List 2.
   * @return Merged sorted list.
   */
  public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
    ListNode mergeList = new ListNode(-1);

    ListNode iter1 = l1;
    ListNode iter2 = l2;
    ListNode mergeIter = mergeList;

    while (iter1 != null && iter2 != null) {
      int mergeVal = -1;

      if (iter1.val < iter2.val) {
        mergeVal = iter1.val;
        iter1 = iter1.next;
      } else {
        mergeVal = iter2.val;
        iter2 = iter2.next;
      }

      mergeIter.next = new ListNode(mergeVal);
      mergeIter = mergeIter.next;
    }

    // Iterate remaining elements in l1
    while (iter1 != null) {
      mergeIter.next = new ListNode(iter1.val);
      iter1 = iter1.next;
      mergeIter = mergeIter.next;
    }

    // Iterate remaining elements in l2
    while (iter2 != null) {
      mergeIter.next = new ListNode(iter2.val);
      iter2 = iter2.next;
      mergeIter = mergeIter.next;
    }

    return mergeList.next;
  }
}
