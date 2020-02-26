package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * <p>The minimum depth is the number of nodes along the shortest path from the root node down to
 * the nearest leaf node.
 *
 * <p>Note: A leaf is a node with no children.
 *
 * <p>Example:
 *
 * <p>Given binary tree [3,9,20,null,null,15,7], return its minimum depth = 2.
 *
 * @see <a href = "https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of
 *     Binary Tree</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MinimumDepth {

  /**
   * Finds the minimum depth of a binary tree.
   *
   * @param root The root of the binary tree.
   * @return The minimum depth of the tree.
   */
  public int minDepth(final TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null) {
      return minDepth(root.right) + 1;
    }

    if (root.right == null) {
      return minDepth(root.left) + 1;
    }

    return 1 + Math.min(minDepth(root.left), minDepth(root.right));
  }
}
