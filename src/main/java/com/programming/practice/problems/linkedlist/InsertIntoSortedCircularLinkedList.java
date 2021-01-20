package com.programming.practice.problems.linkedlist;

/**
 * Given a node from a Circular Linked List which is sorted in ascending order, write a function to
 * insert a value insertVal into the list such that it remains a sorted circular list. The given
 * node can be a reference to any single node in the list, and may not be necessarily the smallest
 * value in the circular list.
 *
 * <p>If there are multiple suitable places for insertion, you may choose any place to insert the
 * new value. After the insertion, the circular list should remain sorted.
 *
 * <p>If the list is empty (i.e., given node is null), you should create a new single circular list
 * and return the reference to that single node. Otherwise, you should return the original given
 * node.
 *
 * <pre>
 * Example 1:
 *
 * Input: head = [3,4,1], insertVal = 2
 * Output: [3,4,1,2]
 * Explanation: In the figure above, there is a sorted circular list of three elements. You are given a reference to the node with value 3, and we need to insert 2 into the list. The new node should be inserted between node 1 and node 3. After the insertion, the list should look like this, and we should still return node 3.
 *
 * Example 2:
 *
 * Input: head = [], insertVal = 1
 * Output: [1]
 * Explanation: The list is empty (given head is null). We create a new single circular list and return the reference to that single node.
 *
 *  Example 3:
 *
 * Input: head = [1], insertVal = 0
 * Output: [1,0]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/">Insert
 *     into a sorted Circular linked list</a>
 */
public final class InsertIntoSortedCircularLinkedList {

  /** Represents a circular linked list node. */
  static class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  };

  /**
   * Given a node from a Circular Linked List which is sorted in ascending order, inserta a value
   * insertVal into the list such that it remains a sorted circular list. The given node can be a
   * reference to any single node in the list, and may not be necessarily the smallest value in the
   * circular list.
   *
   * @param head The head of the circular linked list
   * @param insertVal The value of the node to insert.
   * @return The node inserted into the linked list.
   */
  public Node insert(final Node head, final int insertVal) {

    // The circular linked list is empty.
    if (head == null) {
      final Node nodeToInsert = new Node(insertVal);
      nodeToInsert.next = nodeToInsert;
      return nodeToInsert;
    }

    Node prev = head;
    Node current = head.next;

    do {
      // insetVal lies between prev and current
      // e.g. 1 -> 10 insert 7 OR 2 -> 2 insert 2
      if (prev.val <= insertVal && insertVal <= current.val) {

        // Insert the new node between prev and current
        break;
      }

      // prev node is the highest node and insertVal needs to be between prev node and current
      // e.g 10 -> 5 -> 6 -> 7 insert 4 OR
      // e.g 10 -> 5 -> 6 -> 7 insert 12 OR
      if (prev.val > current.val) {
        if (insertVal >= prev.val || insertVal <= current.val) {
          // Insert the new node between prev and current
          break;
        }
      }

      prev = prev.next;
      current = current.next;
    }

    // This condition refers to the complete traversal of the circular linked list where prev node
    // again points to the head.
    while (prev != head);

    final Node nodeToInsert = new Node(insertVal);
    prev.next = nodeToInsert;
    nodeToInsert.next = current;

    return head;
  }
}
