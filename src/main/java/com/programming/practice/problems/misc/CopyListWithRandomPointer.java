package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could
 * point to any node in the list or null.
 *
 * <p>Return a deep copy of the list.
 *
 * <p>The Linked List is represented in the input/output as a list of n nodes. Each node is
 * represented as a pair of [val, random_index] where:
 *
 * <ul>
 *   <li>val: an integer representing Node.val
 *   <li>random_index: the index of the node (range from 0 to n-1) where random pointer points to,
 *       or null if it does not point to any node.
 * </ul>
 *
 * @see <a href = "">Copy list with Random Pointer</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class CopyListWithRandomPointer {

  /** A node representation. */
  public class Node {
    int val;
    Node next;
    Node random;

    public Node(final int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  private final Map<Node, Node> map;

  /** Constructor for {@link CopyListWithRandomPointer} */
  public CopyListWithRandomPointer() {
    this.map = new HashMap<>();
  }

  /**
   * Performs a deep copy of the linked list with random pointer.
   *
   * @param head The head of the linked list.
   * @return The head of the deep copied linked list.
   */
  public Node copyRandomList(final Node head) {
    Node currentNode = head;

    // Traverse the original linked list and create copy nodes
    while (currentNode != null) {
      final Node copyNode = new Node(currentNode.val);
      map.put(currentNode, copyNode);

      currentNode = currentNode.next;
    }

    // Traverse the original linked list and add the mappings to the copy nodes
    currentNode = head;
    while (currentNode != null) {
      final Node copyNode = map.get(currentNode);
      final Node copyNextNode = currentNode.next != null ? map.get(currentNode.next) : null;
      final Node copyRandomNode = currentNode.random != null ? map.get(currentNode.random) : null;

      copyNode.next = copyNextNode;
      copyNode.random = copyRandomNode;

      currentNode = currentNode.next;
    }

    return map.get(head);
  }
}
