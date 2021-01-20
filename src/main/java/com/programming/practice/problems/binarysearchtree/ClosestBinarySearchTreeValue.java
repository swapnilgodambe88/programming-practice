package com.programming.practice.problems.binarysearchtree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is
 * closest to the target.
 *
 * <p>Note:
 *
 * <ul>
 *   <li>Given target value is a floating point.
 *   <li>You are guaranteed to have only one unique value in the BST that is closest to the target.
 * </ul>
 *
 * <pre>
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/closest-binary-search-tree-value/">Closest Binary
 *     Search Tree value</a>
 */
public final class ClosestBinarySearchTreeValue {

  private double delta = Double.MAX_VALUE;
  private int closestValue = Integer.MIN_VALUE;

  /**
   * Finds the node with the closest value to the target.
   *
   * @param root The root of the binary tree.
   * @param target The target value.
   * @return The node with the closest value to the target.
   */
  public int closestValue(final TreeNode root, final double target) {
    inOrderTraversal(root, target);
    return closestValue;
  }

  /**
   * In order traversal of the tree.
   *
   * @param root The root node of the binary search tree.
   * @param target The target value.
   */
  private void inOrderTraversal(final TreeNode root, final double target) {
    if (root != null) {
      inOrderTraversal(root.left, target);
      final double diff = Math.abs(root.val - target);

      if (diff < delta) {
        delta = diff;
        closestValue = root.val;
      }

      inOrderTraversal(root.right, target);
    }
  }
}
