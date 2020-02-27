package com.programming.practice.problems.binarytree;

import com.programming.practice.problems.binarytree.util.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 *
 * <p>Note: A leaf is a node with no children.
 *
 * @see <a href = "https://leetcode.com/problems/path-sum/">Path Sum</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class PathSum {

  private boolean foundPath = false;
  /**
   * Determine if the tree has a root-to-leaf path such that adding up all the values along the path
   * equals the given sum.
   *
   * @param root The root of the tree.
   * @param sum The sum.
   * @return True if such path exists, otherwise false.
   */
  public boolean hasPathSum(final TreeNode root, final int sum) {

    addSum(root, 0, sum);
    return foundPath;
  }

  /**
   * Recursive function which add the node value to the sumSoFar and checks for equality to sum.
   *
   * @param root The root of the node.
   * @param sumSoFar The sum so far.
   * @param targetSum The target sum.
   */
  private void addSum(final TreeNode root, final int sumSoFar, final int targetSum) {
    if (root == null) {
      return;
    }

    if (TreeNode.isLeafNode(root) && sumSoFar + root.val == targetSum) {
      foundPath = true;
      return;
    }

    addSum(root.left, sumSoFar + root.val, targetSum);
    addSum(root.right, sumSoFar + root.val, targetSum);
  }
}
