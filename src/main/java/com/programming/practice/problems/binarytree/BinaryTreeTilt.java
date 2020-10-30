package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 *
 * <p>The tilt of a tree node is the absolute difference between the sum of all left subtree node
 * values and all right subtree node values. If a node does not have a left child, then the sum of
 * the left subtree node values is treated as 0. The rule is similar if there the node does not have
 * a right child.
 *
 * <pre>
 * Input: root = [1,2,3]
 * Output: 1
 * Explanation:
 * Tilt of node 2 : |0-0| = 0 (no children)
 * Tilt of node 3 : |0-0| = 0 (no children)
 * Tile of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum is 3)
 * Sum of every tilt : 0 + 0 + 1 = 1
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/binary-tree-tilt/">Binary Tree Tilt</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BinaryTreeTilt {

  private int tiltSum = 0;

  /**
   * Given the root of a binary tree, return the sum of every tree node's tilt.
   *
   * @param root The root of the binary tree.
   * @return The sum of every tree node's tilt.
   */
  public int findTilt(final TreeNode root) {
    this.valueSum(root);
    return tiltSum;
  }

  /**
   * Returns the sum of the leftnode + rightNodes + currentNode value. This also sums the tilt to
   * the tiltSum.
   *
   * @param root The root of the tree.
   * @return The sum of all the nodes of the tree.
   */
  private int valueSum(final TreeNode root) {
    if (root == null) {
      return 0;
    }

    final int leftSum = this.valueSum(root.left);
    final int rightSum = this.valueSum(root.right);

    final int tilt = Math.abs(leftSum - rightSum);
    tiltSum += tilt;

    return root.val + leftSum + rightSum;
  }
}
