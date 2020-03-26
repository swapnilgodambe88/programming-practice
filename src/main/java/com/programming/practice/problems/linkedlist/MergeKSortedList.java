package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 *
 * <p>Example:
 *
 * <p>Input: [ 1->4->5, 1->3->4, 2->6 ]
 *
 * <p>Output: 1->1->2->3->4->4->5->6
 *
 * @see <a href = "https://leetcode.com/problems/merge-k-sorted-lists/">Merge k Sorted Lists</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class MergeKSortedList {

  private final MergeTwoSortedList mergeTwoSortedLists = new MergeTwoSortedList();

  /**
   * Merges K sorted lists.
   *
   * @param lists A list of linked list each of which is sorted.
   * @return The merged sorted list.
   */
  public ListNode mergeKLists(final ListNode[] lists) {
    ListNode mergeList = null;

    for (final ListNode list : lists) {
      mergeList = mergeTwoSortedLists.mergeTwoLists(list, mergeList);
    }

    return mergeList;
  }
}
