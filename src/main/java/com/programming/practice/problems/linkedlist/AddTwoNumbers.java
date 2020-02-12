package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <p>Example:
 *
 * <p>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 *
 * @see <a href = "https://leetcode.com/problems/add-two-numbers/">LeetCode - Add Two Numbers</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    final ListNode resultHeadNode = new ListNode(-1);

    ListNode l1Iterator = l1;
    ListNode l2Iterator = l2;
    ListNode currNode = resultHeadNode;

    int carryOver = 0;
    while (l1Iterator != null && l2Iterator != null) {
      int sum = l1Iterator.val + l2Iterator.val + carryOver;

      if (sum >= 10) {
        carryOver = Math.floorDiv(sum, 10);
        sum = sum % 10;
      } else {
        carryOver = 0;
      }

      currNode.next = new ListNode(sum);

      currNode = currNode.next;
      l1Iterator = l1Iterator.next;
      l2Iterator = l2Iterator.next;
    }

    while (l1Iterator != null) {
      int sum = l1Iterator.val + carryOver;

      if (sum >= 10) {
        carryOver = Math.floorDiv(sum, 10);
        sum = sum % 10;
      } else {
        carryOver = 0;
      }

      currNode.next = new ListNode(sum);

      currNode = currNode.next;
      l1Iterator = l1Iterator.next;
    }

    while (l2Iterator != null) {
      int sum = l2Iterator.val + carryOver;

      if (sum >= 10) {
        carryOver = Math.floorDiv(sum, 10);
        sum = sum % 10;
      } else {
        carryOver = 0;
      }

      currNode.next = new ListNode(sum);

      currNode = currNode.next;
      l2Iterator = l2Iterator.next;
    }

    if (carryOver > 0) {
      currNode.next = new ListNode(carryOver);
    }

    return resultHeadNode.next;
  }
}
