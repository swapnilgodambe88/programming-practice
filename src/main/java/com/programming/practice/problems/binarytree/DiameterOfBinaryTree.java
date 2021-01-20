package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of
 * a binary tree is the length of the longest path between any two nodes in a tree. This path may or
 * may not pass through the root.
 *
 * <pre>
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary
 *     Tree</a>
 */
public final class DiameterOfBinaryTree {

  private int diameter = 0;

  /**
   * Calculates the diameter of a binary tree.
   *
   * @param root The root of the binary tree.
   * @return The diameter of the binary tree.
   */
  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    depth(root);
    return diameter - 1;
  }

  /**
   * Calculates the depth of the binary tree.
   *
   * @param node The node or the binary tree.
   * @return The depth.
   */
  private int depth(final TreeNode node) {
    if (node == null) {
      return 0;
    }

    final int leftDepth = depth(node.left);
    final int rightDepth = depth(node.right);

    diameter = Math.max(diameter, leftDepth + rightDepth + 1);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
