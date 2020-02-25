package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 *
 * <p>The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * <p>Note: A leaf is a node with no children.
 *
 * <p>Example:
 *
 * <p>Given binary tree [3,9,20,null,null,15,7]
 *
 * <p>return its depth = 3.
 *
 * @see <a href = "https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of
 *     Binary Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MaximumDepth {

  /**
   * Finds the maximum depth of the tree.
   *
   * @param root The root node of the binary tree.
   * @return The maximum depth of the tree.
   */
  public int maxDepth(final TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
