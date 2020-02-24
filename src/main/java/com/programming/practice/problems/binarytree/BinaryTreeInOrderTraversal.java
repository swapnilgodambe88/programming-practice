package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the in-order traversal of its nodes' values.
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-inorder-traversal/">Binary Tree Inorder
 *     Traversal</a>
 * @author Swapnil Godambe. Copyright 2020.
 */
final class BinaryTreeInOrderTraversal {

  /** Member variable to hold traversal values. */
  private final List<Integer> traversalNodes = new ArrayList<>();

  /**
   * In order traversal of Binary tree.
   *
   * @param root The root node.
   * @return The list representing the in-order traversal.
   */
  public List<Integer> inorderTraversal(final TreeNode root) {
    inOrderTraversalRecursive(root);

    return traversalNodes;
  }

  /**
   * Recursive function to perform in-order traversal.
   *
   * @param node The root node.
   */
  private void inOrderTraversalRecursive(final TreeNode node) {
    if (node != null) {
      inOrderTraversalRecursive(node.left);
      traversalNodes.add(node.val);
      inOrderTraversalRecursive(node.right);
    }
  }
}
