package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * <pre>
 * Example 1:
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-preorder-traversal/">Binary Tree
 *     Preorder Traversal</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2024.
 */
public final class PreOrderTraversal {

  /** A list to store traversed nodes. */
  private final List<Integer> traversalNodes = new ArrayList<>();

  /**
   * @param root The root of the binary tree.
   * @return The pre-order traversal of binary tree.
   */
  public List<Integer> preorderTraversal(final TreeNode root) {
    preOrderTraversalRecursive(root);
    return traversalNodes;
  }

  private void preOrderTraversalRecursive(final TreeNode root) {
    if (root == null) {
      return;
    }

    traversalNodes.add(root.val);
    preOrderTraversalRecursive(root.left);
    preOrderTraversalRecursive(root.right);
  }
}
