package com.programming.practice.problems.binarysearchtree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
 * root node of a BST.
 *
 * <p>Calling next() will return the next smallest number in the BST.
 *
 * @see <a href = "https://leetcode.com/problems/binary-search-tree-iterator/">Binary Search Tree
 *     Iterator</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class BinarySearchTreeIterator {

  /**
   * Queue to maintain the inorder traversal of the binary tree. Once the node is iterated, it gets
   * removed from the queue.
   */
  private final Queue<TreeNode> queue;

  /**
   * The constructor for {@link BinarySearchTreeIterator}.
   *
   * @param root The root node of the Binary search tree.
   */
  public BinarySearchTreeIterator(final TreeNode root) {

    this.queue = new LinkedList<>();
    flattenBinarySearchTree(root);
  }

  /**
   * Flattens the binary search tree, in inorder traversal and stores off the node in queue.
   *
   * @param root The root node of the binary search tree.
   */
  private void flattenBinarySearchTree(final TreeNode root) {
    if (root != null) {
      flattenBinarySearchTree(root.left);
      queue.add(root);
      flattenBinarySearchTree(root.right);
    }
  }

  /**
   * @return the next smallest number
   * @throws UnsupportedOperationException If the next node in the tree is null.
   */
  public int next() {
    if (queue.isEmpty()) {
      throw new UnsupportedOperationException("End of iterator reached. No next element available");
    }

    return queue.remove().val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !queue.isEmpty();
  }
}
